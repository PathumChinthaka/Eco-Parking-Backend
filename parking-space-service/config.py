import os

class Config:
    SQLALCHEMY_DATABASE_URI = os.getenv(
        "DATABASE_URL",
        "postgresql://postgres:admin@localhost:5432/eco_parking"
    )
    SQLALCHEMY_TRACK_MODIFICATIONS = False
