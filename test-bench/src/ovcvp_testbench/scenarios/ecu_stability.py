from ovcvp_testbench.validation.validator import validate


def run_ecu_restart(client):

    before = client.get("/api/ecu")

    previous_restart_count = before["restartCount"]

    client.post("/api/ecu/restart")

    after = client.get("/api/ecu")

    result = validate(
        scenario="ECU restart",
        condition=(
            after["status"] == "RESTARTING"
            and after["restartCount"] == previous_restart_count + 1
        ),
        success_message="ECU restart detected correctly",
        failure_message=f"Unexpected ECU state: {after}"
    )

    client.post("/api/ecu/recover")

    return result