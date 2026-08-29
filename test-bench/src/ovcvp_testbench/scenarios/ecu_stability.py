from ovcvp_testbench.validation.validator import ValidationContext


def run_ecu_restart(client):

    context = ValidationContext("ECU restart")

    try:
        before = client.get("/api/ecu")
        previous_count = before["restartCount"]

        client.post("/api/ecu/restart")

        after = client.get("/api/ecu")

        return context.result(
            condition=(
                after["status"] == "RESTARTING"
                and after["restartCount"] == previous_count + 1
            ),
            success_message="ECU restart detected correctly",
            failure_message="ECU restart validation failed",
            evidence={
                "before": before,
                "after": after
            }
        )

    finally:
        client.post("/api/ecu/recover")