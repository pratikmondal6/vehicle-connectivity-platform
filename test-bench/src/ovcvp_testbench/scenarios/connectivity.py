from ovcvp_testbench.validation.validator import ValidationContext


def run_connectivity_failure(client):

    context = ValidationContext("Connectivity failure")

    try:
        client.post("/api/connectivity/disconnect")

        telemetry = client.get("/api/telemetry")
        connectivity = telemetry["connectivityState"]

        return context.result(
            condition=(
                connectivity["status"] == "DISCONNECTED"
                and connectivity["signalStrength"] == 0
            ),
            success_message="Connectivity failure detected correctly",
            failure_message="Connectivity failure was not detected",
            evidence={
                "connectivity": connectivity
            }
        )

    finally:
        client.post("/api/connectivity/connect")