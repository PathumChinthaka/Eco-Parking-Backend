from flask import Flask
from config import Config
from database import db, ma
from routes import bp

app = Flask(__name__)
app.config.from_object(Config)

db.init_app(app)
ma.init_app(app)
app.register_blueprint(bp, url_prefix='/spaces')

if __name__ == '__main__':
    with app.app_context():
        db.create_all()
    app.run(port=5001)
