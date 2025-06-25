from flask import Blueprint, request, jsonify
from models import ParkingSpace, ParkingSpaceSchema
from database import db

bp = Blueprint('api', __name__, url_prefix='/api')
schema = ParkingSpaceSchema()
schemas = ParkingSpaceSchema(many=True)

@bp.route('/spaces', methods=['GET'])
def list_spaces():
    query = ParkingSpace.query
    location = request.args.get('location')
    available = request.args.get('available')

    if location:
        query = query.filter_by(location=location)
    if available:
        query = query.filter_by(is_available=(available.lower() == 'true'))

    return schemas.jsonify(query.all())

@bp.route('/spaces/<int:space_id>', methods=['GET'])
def get_space(space_id):
    space = ParkingSpace.query.get_or_404(space_id)
    return schema.jsonify(space)

@bp.route('/spaces', methods=['POST'])
def create_space():
    data = request.json
    space = ParkingSpace(**data)
    db.session.add(space)
    db.session.commit()
    return schema.jsonify(space), 201

@bp.route('/spaces/<int:space_id>', methods=['PUT'])
def update_space(space_id):
    space = ParkingSpace.query.get_or_404(space_id)
    data = request.json
    for key, value in data.items():
        setattr(space, key, value)
    db.session.commit()
    return schema.jsonify(space)

@bp.route('/spaces/<int:space_id>/reserve', methods=['POST'])
def reserve_space(space_id):
    space = ParkingSpace.query.get_or_404(space_id)
    if not space.is_available:
        return jsonify({'error': 'Space not available'}), 400
    space.is_available = False
    space.status = 'reserved'
    space.reserved_by = request.json.get('user_id')
    db.session.commit()
    return schema.jsonify(space)

@bp.route('/spaces/<int:space_id>/release', methods=['POST'])
def release_space(space_id):
    space = ParkingSpace.query.get_or_404(space_id)
    space.is_available = True
    space.status = 'available'
    space.reserved_by = None
    db.session.commit()
    return schema.jsonify(space)
