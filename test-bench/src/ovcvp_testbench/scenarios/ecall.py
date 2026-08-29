from ovcvp_testbench.validation.validator import ValidationContext


def run_ecall_success(client):

    context = ValidationContext("eCall success")

    try:
        client.post("/api/connectivity/connect")
        client.post("/api/ecu/recover")
        client.post("/api/calls/reset")

        client.post("/api/calls/ecall")
        client.post("/api/calls/connect")

        call = client.get("/api/calls")
        connectivity = client.get("/api/connectivity")
        ecu = client.get("/api/ecu")

        condition = (
            call["type"] == "ECALL"
            and call["status"] == "CONNECTED"
            and connectivity["status"] == "CONNECTED"
            and ecu["status"] == "HEALTHY"
        )

        return context.result(
            condition=condition,
            success_message="eCall connected successfully",
            failure_message="eCall validation failed",
            evidence={
                "call": call,
                "connectivity": connectivity,
                "ecu": ecu
            }
        )

    finally:
        client.post("/api/calls/reset")
        client.post("/api/connectivity/connect")
        client.post("/api/ecu/recover")