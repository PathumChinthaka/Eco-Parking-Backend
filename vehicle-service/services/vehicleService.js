const Vehicle = require('../models/Vehicle');

const createVehicle = (data) => Vehicle.create(data);
const getAllVehicles = () => Vehicle.findAll();
const getVehicleById = (id) => Vehicle.findByPk(id);
const getVehiclesByUserId = (userId) => Vehicle.findAll({ where: { userId } });
const deleteVehicle = (id) => Vehicle.destroy({ where: { id } });
const updateVehicle = (id, data) => {
  return Vehicle.update(data, { where: { id }, returning: true })
    .then(([_, updated]) => updated[0]);
};

module.exports = {
  createVehicle,
  getAllVehicles,
  getVehicleById,
  getVehiclesByUserId,
  deleteVehicle,
  updateVehicle,
};
