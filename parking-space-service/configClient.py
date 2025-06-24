import requests

class SpringConfigClient:
    def __init__(self, config_server_url="http://localhost:8888", app_name="parking-service", profile="default"):
        self.url = f"{config_server_url}/{app_name}/{profile}"

    def fetch(self):
        try:
            response = requests.get(self.url)
            response.raise_for_status()
            props = {}
            for source in response.json().get("propertySources", []):
                props.update(source.get("source", {}))
            return props
        except Exception as e:
            print(f"Error fetching config: {e}")
            return {}
