import requests
import socket
import threading
import time

EUREKA_SERVER = "http://localhost:8761/eureka"
SERVICE_NAME = "PARKING-SERVICE"
HOSTNAME = socket.gethostname()
IP = socket.gethostbyname(HOSTNAME)
PORT = 5001

def register_with_eureka():
    payload = {
        "instance": {
            "hostName": HOSTNAME,
            "instanceId": 'parking-service-instance-1',
            "app": SERVICE_NAME,
            "vipAddress": 'parking-service',
            "ipAddr": IP,
            "status": "UP",
            "port": {
                "$": PORT,
                "@enabled": "true"
            },
            "dataCenterInfo": {
                "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
                "name": "MyOwn"
            }
        },
    }
    headers = {"Content-Type": "application/json"}
    try:
        res = requests.post(f"{EUREKA_SERVER}/apps/{SERVICE_NAME}", json=payload, headers=headers)
        print("Registered with Eureka:", res.status_code)
    except Exception as e:
        print("Eureka registration failed:", e)

def start_heartbeat():
    def heartbeat():
        while True:
            try:
                res = requests.put(f"{EUREKA_SERVER}/apps/{SERVICE_NAME}/parking-service-instance-1")
                print("Eureka heartbeat sent:", res.status_code)
            except Exception as e:
                print("Eureka heartbeat failed:", e)
            time.sleep(30)

    threading.Thread(target=heartbeat, daemon=True).start()
