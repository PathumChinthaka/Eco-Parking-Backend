const { DataTypes } = require('sequelize');
const { getSequelize } = require('../config/db');

const sequelize = getSequelize();

let Vehicle;

if(sequelize){
  Vehicle = sequelize.define(
    "Vehicle",
    {
      userId: {
        type: DataTypes.STRING,
        allowNull: false,
      },
      plateNumber: {
        type: DataTypes.STRING,
        allowNull: false,
        unique: true,
      },
      type: {
        type: DataTypes.ENUM("car", "bike", "van", "lorry"),
        allowNull: false,
      },
      brand: {
        type: DataTypes.STRING,
      },
      color: {
        type: DataTypes.STRING,
      },
    },
    {
      schema: "vehicle_service",
      tableName: "Vehicles",
      timestamps: true,
    }
  );
}

module.exports = Vehicle;
