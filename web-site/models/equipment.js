'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Equipment = sequelize.define('Equipment',{
		id_equipment: {
			field: 'id_equipment',
			type: DataTypes.STRING,
			primaryKey: true,
			autoIncrement: true
		},
		fk_user: {
			field: 'fk_user',
			type: DataTypes.INTEGER,
			foreignKey: true
		},		
		operational_system: {
			field: 'operational_system',
			type: DataTypes.STRING,
			allowNull: false
		},
		manufacturer: {
			field: 'manufacturer',
			type: DataTypes.STRING,
			allowNull: false
		},
		architecture: {
			field: 'architecture',
			type: DataTypes.STRING,
			allowNull: false
		},
		equipment_ram: {
			field: 'equipment_ram',
			type: DataTypes.STRING,
			allowNull: false
		},
        equipment_hd: {
			field: 'equipment_hd',
			type: DataTypes.STRING,
			allowNull: false
		},
		name_processor: {
			field: 'name_processor',
			type: DataTypes.STRING,
			allowNull: false
		},
		physical_cpus: {
			field: 'physical_cpus',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		logical_cpus: {
			field: 'logical_cpus',
			type: DataTypes.INTEGER,
			allowNull: false
		}
	}, 
	{
		tableName: 'tb_equipment',
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Equipment;
};
