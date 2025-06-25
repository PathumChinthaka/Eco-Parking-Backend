const express = require("express");
const cors = require("cors");
const dotenv = require("dotenv").config();
const { connectDB, getSequelize } = require("./config/db");
require("./config/eurekaClient");
const { fetchConfig } = require("./config/configs");

(async () => {
  const config = await fetchConfig();

  // initialize DB with fetched config
  await connectDB(config);

  const app = express();

  app.use(cors());
  app.use(express.json());

  app.get("/health", (req, res) => {
    res.json({ status: "UP" });
  });

  app.use("/api/vehicles", require("./routes/vehicleRoute"));

  app.get("/", (req, res) => res.send("Vehicle Service Running"));

  const sequelize = getSequelize();

  if (sequelize) {
    sequelize.sync().then(() => {
      console.log("All models synced.");
      app.listen(config["config.PORT"], () =>
        console.log(`Vehicle Service running on port ${config["config.PORT"]}`)
      );
    });
  }
})();
