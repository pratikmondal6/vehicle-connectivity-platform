from ovcvp_testbench.client.telematics_client import TelematicsClient

from ovcvp_testbench.scenarios.ecall import run_ecall_success
from ovcvp_testbench.scenarios.connectivity import (
    run_connectivity_failure,
)
from ovcvp_testbench.scenarios.ecu_stability import run_ecu_restart


def main():

    client = TelematicsClient()

    scenarios = [
        run_ecall_success,
        run_connectivity_failure,
        run_ecu_restart,
    ]

    print("\nOVCVP Automated Test Bench")
    print("=" * 50)

    passed = 0

    for scenario in scenarios:

        try:
            result = scenario(client)

            status = "PASS" if result.passed else "FAIL"

            print(
                f"[{status}] "
                f"{result.scenario}: "
                f"{result.message}"
            )

            if result.passed:
                passed += 1

        except Exception as error:
            print(
                f"[ERROR] {scenario.__name__}: {error}"
            )

    print("=" * 50)
    print(f"Result: {passed}/{len(scenarios)} passed")


if __name__ == "__main__":
    main()