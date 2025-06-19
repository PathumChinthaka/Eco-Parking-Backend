from database import db, ma

class ParkingSpace(db.Model):
    __tablename__ = 'parking_spaces'
    __table_args__ = {'schema': 'parking_service'}

    id = db.Column(db.Integer, primary_key=True)
    location = db.Column(db.String(100), nullable=False)
    is_available = db.Column(db.Boolean, default=True)
    reserved_by = db.Column(db.String(50), nullable=True)
    status = db.Column(db.String(50), default='available')  
    type = db.Column(db.String(20))  

class ParkingSpaceSchema(ma.SQLAlchemyAutoSchema):
    class Meta:
        model = ParkingSpace
        load_instance = True
