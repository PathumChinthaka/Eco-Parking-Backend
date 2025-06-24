const express = require('express');
const router = express.Router();
const controller = require('../controller/vehicleController');

router.post('/', controller.addVehicle);
router.get('/', controller.getAll);
router.get('/:id', controller.getById);
router.get('/user/:userId', controller.getByUserId);
router.delete('/:id', controller.delete);
router.put('/:id', controller.update);

module.exports = router;
