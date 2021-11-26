var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Empresa = require('../models').Empresa;

let sessoes = [];

/* Recuperar usuário por login e senha */
router.post('/auth', function(req, res, next) {
	console.log('Recovering user by login and password');

	var email = req.body.email; // depois de .body, use o nome (name) do campo em seu formulário de login
	var password = req.body.password; // depois de .body, use o nome (name) do campo em seu formulário de login	
	
	let instrucaoSql = `select * from tb_company where company_email='${email}' and company_password='${password}'`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Empresa
	}).then(resultado => {
		console.log(`Found: ${resultado.length}`);

		if (resultado.length == 1) {
			sessoes.push(resultado[0].dataValues.company_email);
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
	console.log('Creating a compnany');
	
	Empresa.create({
		id_company : null,
		company_name : req.body.company_name,
		company_cnpj : req.body.company_cnpj,
		company_address : req.body.company_address,
		company_email : req.body.company_email,
		company_password : req.body.company_password,
		company_phone_number : req.body.company_phone_number
	}).then(resultado => {
		console.log(`New company created: ${resultado}`)
        res.send(resultado);
    }).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});


/* Verificação de usuário */
router.get('/session/:company_email', function(req, res, next) {
	let login = req.params.company_email;
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
router.get('/logoff/:company_email', function(req, res, next) {
	let login = req.params.company_email;
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
	Empresa.findAndCountAll().then(resultado => {
		console.log(`${resultado.count} logs`);

		res.json(resultado.rows);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

module.exports = router;
