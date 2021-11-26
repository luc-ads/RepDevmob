'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let FucionarioGestor = sequelize.define('FucionarioGestor', {
        horario: {
            field: 'horario',
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        descricao: {
            field: 'descricao',
            type: DataTypes.STRING,
            allowNull: false
        },
        fk_usuario: {
            field: 'fk_usuario',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        fk_chat: {
            field: 'fk_chat',
            type: DataTypes.INTEGER,
            allowNull: false
        }
    }, {
        tableName: 'tabela_publicacao',
        freezeTableName: true,
        underscored: true,
        timestamps: false,
    });

    return FucionarioGestor;
};