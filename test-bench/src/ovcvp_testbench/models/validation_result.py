from dataclasses import dataclass, field
from typing import Any


@dataclass
class ValidationResult:
    test_run_id: str
    scenario: str
    passed: bool
    message: str
    started_at: str
    finished_at: str
    duration_ms: int
    evidence: dict[str, Any] = field(default_factory=dict)