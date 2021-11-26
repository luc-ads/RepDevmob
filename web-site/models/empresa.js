'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Empresa = sequelize.define('Empresa',{
		id_company: {
			field: 'id_company',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},
		company_name: {
			field: 'company_name',
			type: DataTypes.STRING,
			allowNull: false
		},		
		company_cnpj: {
			field: 'company_cnpj',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		company_address: {
			field: 'company_address',
			type: DataTypes.STRING,
			allowNull: false
		},
		company_email: {
			field: 'company_email',
			type: DataTypes.STRING,
			allowNull: false
		},
		company_password: {
			field: 'company_password',
			type: DataTypes.STRING,
			allowNull: false
		},
        company_phone_number: {
			field: 'company_phone_number',
			type: DataTypes.STRING,
			allowNull: false
		}
	}, 
	{
		tableName: 'tb_company',
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Empresa;
};
