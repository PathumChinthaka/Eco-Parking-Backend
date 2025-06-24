const { Sequelize } = require("sequelize");
require("dotenv").config();

let sequelize;

async function connectDB(config) {
  sequelize = new Sequelize(
    config["config.PG_DB"],
    config["config.PG_USER"],
    config["config.PG_PASSWORD"],
    {
      host: config["config.PG_HOST"],
      dialect: "postgres",
      logging: false,
    }
  );

  try {
    await sequelize.authenticate();
    console.log("PostgreSQL connected successfully");
  } catch (error) {
    console.error("Unable to connect to the database:", error);
  }
}

function getSequelize() {
  if (!sequelize) return null;
  return sequelize;
}

module.exports = { getSequelize, connectDB };
