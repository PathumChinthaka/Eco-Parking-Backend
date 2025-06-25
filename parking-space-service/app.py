from flask import Flask
from config import Config
from database import db, ma
from routes import bp
from eureka import register_with_eureka, start_heartbeat
from configClient import SpringConfigClient

remote_config = SpringConfigClient().fetch()

app = Flask(__name__)
app.config.from_object(Config)

db.init_app(app)
ma.init_app(app)
app.register_blueprint(bp)

if __name__ == '__main__':
    with app.app_context():
        db.create_all()
        register_with_eureka()
        start_heartbeat()
    app.run(port=remote_config['PORT'])
