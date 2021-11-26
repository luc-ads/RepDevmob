'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Leitura = sequelize.define('Leitura',{	
		id_log: {
			field: 'id_log',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},	
		fk_equipment: {
			field: 'fk_equipment',
			type: DataTypes.STRING,
			primaryKey: true,
			autoIncrement: false
		},
		cpu_percentage: {
			field: 'cpu_percentage',
			type: DataTypes.DOUBLE,
			allowNull: true
		},
		hd_percentage: {
			field: 'hd_percentage',
			type: DataTypes.DECIMAL,
			allowNull: true
		},
		ram_percentage: {
			field: 'ram_percentage',
			type: DataTypes.BIGINT,
			allowNull: true
		},
		momento_grafico: {
			type: DataTypes.VIRTUAL, // campo 'falso' (não existe na tabela). Deverá ser preenchido 'manualmente' no select
			allowNull: true
		}
	}, 
	{
		tableName: 'tb_computer_log', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Leitura;
};
