from ovcvp_testbench.models.validation_result import ValidationResult


def validate(
        scenario: str,
        condition: bool,
        success_message: str,
        failure_message: str
) -> ValidationResult:

    return ValidationResult(
        scenario=scenario,
        passed=condition,
        message=success_message if condition else failure_message
    )