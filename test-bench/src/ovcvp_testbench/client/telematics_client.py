import requests

from ovcvp_testbench.config import (
    BASE_URL,
    REQUEST_TIMEOUT_SECONDS,
)


class TelematicsClient:

    def __init__(self, base_url: str = BASE_URL):
        self.base_url = base_url

    def get(self, path: str) -> dict:
        response = requests.get(
            f"{self.base_url}{path}",
            timeout=REQUEST_TIMEOUT_SECONDS
        )

        response.raise_for_status()

        return response.json()

    def post(self, path: str) -> dict:
        response = requests.post(
            f"{self.base_url}{path}",
            timeout=REQUEST_TIMEOUT_SECONDS
        )

        response.raise_for_status()

        return response.json()