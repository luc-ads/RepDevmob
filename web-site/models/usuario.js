	'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Usuario = sequelize.define('Usuario',{
		id_user: {
			field: 'id_user',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},
		fk_company: {
			field: 'fk_company',
			type: DataTypes.INTEGER,
			foreignKey: true
		},
		fk_manager: {
			field: 'fk_manager',
			type: DataTypes.INTEGER,
			allowNull: false
		},		
		user_name: {
			field: 'user_name',
			type: DataTypes.STRING,
			allowNull: false
		},
		user_email: {
			field: 'user_email',
			type: DataTypes.STRING,
			allowNull: false
		},
		user_password: {
			field: 'user_password',
			type: DataTypes.STRING,
			allowNull: false
		},
		user_phone_number: {
			field: 'user_phone_number',
			type: DataTypes.STRING,
			allowNull: false
		}
	}, 
	{
		tableName: 'tb_users',
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Usuario;
};
