from datetime import datetime, timezone
from time import perf_counter
from uuid import uuid4

from ovcvp_testbench.models.validation_result import ValidationResult


class ValidationContext:

    def __init__(self, scenario: str):
        self.test_run_id = str(uuid4())
        self.scenario = scenario
        self.started_at = datetime.now(timezone.utc)
        self.started_timer = perf_counter()

    def result(
            self,
            condition: bool,
            success_message: str,
            failure_message: str,
            evidence: dict
    ) -> ValidationResult:

        finished_at = datetime.now(timezone.utc)

        duration_ms = int(
            (perf_counter() - self.started_timer) * 1000
        )

        return ValidationResult(
            test_run_id=self.test_run_id,
            scenario=self.scenario,
            passed=condition,
            message=success_message if condition else failure_message,
            started_at=self.started_at.isoformat(),
            finished_at=finished_at.isoformat(),
            duration_ms=duration_ms,
            evidence=evidence
        )