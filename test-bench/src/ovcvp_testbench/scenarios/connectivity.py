from ovcvp_testbench.validation.validator import validate


def run_connectivity_failure(client):

    client.post("/api/connectivity/disconnect")

    telemetry = client.get("/api/telemetry")

    connectivity = telemetry["connectivityState"]

    result = validate(
        scenario="Connectivity failure",
        condition=(
            connectivity["status"] == "DISCONNECTED"
            and connectivity["signalStrength"] == 0
        ),
        success_message="Connectivity failure detected correctly",
        failure_message=f"Unexpected connectivity state: {connectivity}"
    )

    client.post("/api/connectivity/connect")

    return result