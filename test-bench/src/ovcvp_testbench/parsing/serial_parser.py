REQUIRED_FIELDS = {
    "TS",
    "ECU",
    "LEVEL",
    "EVENT",
}


class SerialParsingError(ValueError):
    pass


def parse_serial_line(line: str) -> dict:

    if not line or not line.strip():
        raise SerialParsingError("Serial line cannot be empty")

    fields = {}

    for component in line.strip().split("|"):

        if "=" not in component:
            raise SerialParsingError(
                f"Malformed serial component: {component}"
            )

        key, value = component.split("=", 1)

        key = key.strip()
        value = value.strip()

        if not key:
            raise SerialParsingError(
                "Serial field name cannot be empty"
            )

        if not value:
            raise SerialParsingError(
                f"Serial field '{key}' cannot be empty"
            )

        fields[key] = value

    missing_fields = REQUIRED_FIELDS - fields.keys()

    if missing_fields:
        raise SerialParsingError(
            f"Missing required fields: {sorted(missing_fields)}"
        )

    return {
        "timestamp": fields["TS"],
        "ecu_id": fields["ECU"],
        "level": fields["LEVEL"],
        "event": fields["EVENT"],
    }