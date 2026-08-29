import json
from dataclasses import asdict
from pathlib import Path


class JsonReporter:

    def __init__(self, output_directory="reports"):
        self.output_directory = Path(output_directory)
        self.output_directory.mkdir(
            parents=True,
            exist_ok=True
        )

    def write(self, result):

        path = self.output_directory / (
            f"{result.test_run_id}.json"
        )

        with path.open(
                "w",
                encoding="utf-8"
        ) as file:
            json.dump(
                asdict(result),
                file,
                indent=2
            )

        return path