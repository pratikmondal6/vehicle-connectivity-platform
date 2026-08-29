from dataclasses import dataclass


@dataclass
class ValidationResult:
    scenario: str
    passed: bool
    message: str