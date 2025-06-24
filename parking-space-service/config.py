import os
from configClient import SpringConfigClient

class Config:
    config_client = SpringConfigClient("http://localhost:8888", "parking-service")
    remote_config = config_client.fetch()

    print("remote config", remote_config)

    SQLALCHEMY_DATABASE_URI = os.getenv("DATABASE_URL",remote_config['DB_URL'])
    SQLALCHEMY_TRACK_MODIFICATIONS = False
