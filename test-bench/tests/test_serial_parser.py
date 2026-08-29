import unittest

from ovcvp_testbench.parsing.serial_parser import (
    SerialParsingError,
    parse_serial_line,
)


class SerialParserTest(unittest.TestCase):

    def test_should_parse_valid_serial_line(self):

        raw = (
            "TS=2026-08-29T13:52:06Z"
            "|ECU=TCU-001"
            "|LEVEL=INFO"
            "|EVENT=HEARTBEAT"
        )

        result = parse_serial_line(raw)

        self.assertEqual(
            result["timestamp"],
            "2026-08-29T13:52:06Z"
        )

        self.assertEqual(
            result["ecu_id"],
            "TCU-001"
        )

        self.assertEqual(
            result["level"],
            "INFO"
        )

        self.assertEqual(
            result["event"],
            "HEARTBEAT"
        )

    def test_should_reject_empty_serial_line(self):

        with self.assertRaises(SerialParsingError):
            parse_serial_line("")

    def test_should_reject_malformed_component(self):

        raw = (
            "TS=2026-08-29T13:52:06Z"
            "|ECU=TCU-001"
            "|BROKEN"
            "|EVENT=HEARTBEAT"
        )

        with self.assertRaises(SerialParsingError):
            parse_serial_line(raw)

    def test_should_reject_missing_required_field(self):

        raw = (
            "TS=2026-08-29T13:52:06Z"
            "|ECU=TCU-001"
            "|LEVEL=INFO"
        )

        with self.assertRaises(SerialParsingError):
            parse_serial_line(raw)


if __name__ == "__main__":
    unittest.main()