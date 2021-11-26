var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Equipment = require('../models').Equipment;

router.get('/:idUser', function(req, res, next) {
	console.log('Recovering equipment by user id');

	var idUser = req.params.idUser;
	
	let instrucaoSql = `select * from tb_equipment where fk_user=${idUser}`;
	console.log(instrucaoSql);

//	sequelize.query(instrucaoSql, {
//		model: Equipment,
//		mapToModel: true,		
//	}).then(resultado => {
//		console.log(`Found: ${resultado.length}`);
//	}).catch(erro => {
//		console.error(erro);
//		res.status(500).send(erro.message);
//  	});

	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
	.then(resultado => {
		res.json(resultado[0]);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

module.exports = router;