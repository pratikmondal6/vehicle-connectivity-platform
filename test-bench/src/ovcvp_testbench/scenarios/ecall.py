from ovcvp_testbench.validation.validator import validate


def run_ecall_success(client):

    client.post("/api/connectivity/connect")
    client.post("/api/ecu/recover")
    client.post("/api/calls/reset")

    client.post("/api/calls/ecall")
    client.post("/api/calls/connect")

    call = client.get("/api/calls")

    return validate(
        scenario="eCall success",
        condition=(
            call["type"] == "ECALL"
            and call["status"] == "CONNECTED"
        ),
        success_message="eCall connected successfully",
        failure_message=f"Unexpected call state: {call}"
    )