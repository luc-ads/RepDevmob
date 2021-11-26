var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Usuario = require('../models').Usuario;

let sessoes = [];

/* Recuperar usuário por login e senha */
router.post('/auth', function(req, res, next) {
	console.log('Recovering user by login and password');

	var email = req.body.email; // depois de .body, use o nome (name) do campo em seu formulário de login
	var password = req.body.password; // depois de .body, use o nome (name) do campo em seu formulário de login	
	
	let instrucaoSql = `select * from tb_users where user_email='${email}' and user_password='${password}'`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Usuario
	}).then(resultado => {
		console.log(`Found: ${resultado.length}`);

		if (resultado.length == 1) {
			sessoes.push(resultado[0].dataValues.user_email);
			console.log('Session: ', sessoes);
			res.json(resultado[0]);
		} else if (resultado.length == 0) {
			res.status(403).send('Email and/or password invalid(s)');
		} else {
			res.status(403).send('More than one user with the same email and password!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

/* Cadastrar usuário */
router.post('/register', function(req, res, next) {
	console.log('Creating an user');
	
	Usuario.create({
		id_user: null,
		fk_company : req.body.fk_company,
		fk_manager : req.body.fk_manager,
		user_name : req.body.name,
		user_email : req.body.email,
		user_password: req.body.password,
		user_phone_number: req.body.user_phone_number
	}).then(resultado => {
		console.log(`New user created: ${resultado}`)
        res.send(resultado);
    }).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});


/* Verificação de usuário */
router.get('/session/:user_email', function(req, res, next) {
	let login = req.params.user_email;
	console.log(`Checking if the user ${login} has a session`);

	let tem_sessao = false;
	for (let u=0; u<sessoes.length; u++) {
		if (sessoes[u] == login) {
			tem_sessao = true;
			break;
		}
	}

	if (tem_sessao) {
		let mensagem = `User ${login} has active session!`;
		console.log(mensagem);
		res.send(mensagem);
	} else {
		res.sendStatus(403);
	}
	
});


/* Logoff de usuário */
router.get('/logoff/:user_email', function(req, res, next) {
	let login = req.params.user_email;
	console.log(`Ending user session ${login}`);
	let nova_sessoes = []
	for (let u=0; u < sessoes.length; u++) {
		if (sessoes[u] != login) {
			nova_sessoes.push(sessoes[u]);
		}
	}
	sessoes = nova_sessoes;
	res.send(`User session ${login} successfully terminated!`);
});


/* Recuperar todos os usuários */
router.get('/', function(req, res, next) {
	console.log('Recovering all users');
	Usuario.findAndCountAll().then(resultado => {
		console.log(`${resultado.count} logs`);

		res.json(resultado.rows);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

module.exports = router;
