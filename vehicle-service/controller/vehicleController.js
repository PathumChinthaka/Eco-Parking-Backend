const service = require('../services/vehicleService');

exports.addVehicle = async (req, res) => {
  try {
    const vehicle = await service.createVehicle(req.body);
    res.status(201).json(vehicle);
  } catch (err) {
    res.status(400).json({ message: err.message });
  }
};

exports.getAll = async (req, res) => {
  const vehicles = await service.getAllVehicles();
  res.json(vehicles);
};

exports.getById = async (req, res) => {
  const vehicle = await service.getVehicleById(req.params.id);
  vehicle ? res.json(vehicle) : res.status(404).send("Not found");
};

exports.getByUserId = async (req, res) => {
  const vehicles = await service.getVehiclesByUserId(req.params.userId);
  res.json(vehicles);
};

exports.delete = async (req, res) => {
  await service.deleteVehicle(req.params.id);
  res.status(204).send();
};

exports.update = async (req, res) => {
  const updated = await service.updateVehicle(req.params.id, req.body);
  res.json(updated);
};
