package org.firstinspires.ftc.teamcode.utils;

//==============================Robot Core=============================
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

//================================Vison================================
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

//==============================Road Runner============================
import com.acmerobotics.roadrunner.Pose2d;

//=================================Enumes==============================
import org.firstinspires.ftc.teamcode.enums.DriveTypes;
import org.firstinspires.ftc.teamcode.enums.AllianceColors;

/**
 * A utility class that provides helper methods for displaying common telemetry information
 * on both the Driver Station and FTC Dashboard.
 *
 * <p>These methods simplify debugging by standardizing the way robot status, drivetrain data,
 * and sensor information are reported to telemetry outputs.</p>
 *
 * @version 2.0 (Date Code: 10.29.25.1.35)
 */
public final class TelemetryMethods {

    /**
     * Displays the power levels of the four drivetrain motors on both telemetry outputs.
     *
     * @param driverStationTelemetry The telemetry object for displaying data on the driver station.
     * @param dashboardTelemetry The telemetry object for displaying data on the FTC Dashboard.
     * @param frontLeftPower Power of the front-left motor.
     * @param backLeftPower Power of the back-left motor.
     * @param frontRightPower Power of the front-right motor.
     * @param backRightPower Power of the back-right motor.
     */
    public static void displayMotorPowers(Telemetry driverStationTelemetry,
                                          Telemetry dashboardTelemetry,
                                          double frontLeftPower,
                                          double backLeftPower,
                                          double frontRightPower,
                                          double backRightPower) {
        driverStationTelemetry.addLine("-----------------------------");
        driverStationTelemetry.addData("FL Power", frontLeftPower);
        driverStationTelemetry.addData("BL Power", backLeftPower);
        driverStationTelemetry.addData("FR Power", frontRightPower);
        driverStationTelemetry.addData("BR Power", backRightPower);

        dashboardTelemetry.addLine("-----------------------------");
        dashboardTelemetry.addData("FL Power", frontLeftPower);
        dashboardTelemetry.addData("BL Power", backLeftPower);
        dashboardTelemetry.addData("FR Power", frontRightPower);
        dashboardTelemetry.addData("BR Power", backRightPower);
    }

    /**
     * Displays the current version of the active code on telemetry.
     *
     * @param driverStationTelemetry The telemetry object for displaying data on the driver station.
     * @param dashboardTelemetry The telemetry object for displaying data on the FTC Dashboard.
     * @param version The version string to display (e.g., "2.0.10.29.25.1.35").
     */
    public static void displayCodeVersion(Telemetry driverStationTelemetry,
                                          Telemetry dashboardTelemetry,
                                          String version) {
        driverStationTelemetry.addLine("-----------------------------");
        driverStationTelemetry.addData("Version", version);

        dashboardTelemetry.addLine("-----------------------------");
        dashboardTelemetry.addData("Version", version);
    }

    /**
     * Displays the robot's position and heading in degrees.
     *
     * @param driverStationTelemetry The telemetry object for displaying data on the driver station.
     * @param dashboardTelemetry The telemetry object for displaying data on the FTC Dashboard.
     * @param x The robot’s X coordinate (in inches or cm, depending on implementation).
     * @param y The robot’s Y coordinate.
     * @param theta The robot’s heading angle in degrees.
     */
    public static void displayCoordonates(Telemetry driverStationTelemetry,
                                          Telemetry dashboardTelemetry,
                                          double x, double y, double theta) {
        driverStationTelemetry.addLine("-----------------------------");
        driverStationTelemetry.addData("X Position", x);
        driverStationTelemetry.addData("Y Position", y);
        driverStationTelemetry.addData("Heading (Degrees)", theta);

        dashboardTelemetry.addLine("-----------------------------");
        dashboardTelemetry.addData("X Position", x);
        dashboardTelemetry.addData("Y Position", y);
        dashboardTelemetry.addData("Heading (Degrees)", theta);
    }

    /**
     * Displays the current drive mode (ROBOT-CENTRIC or FIELD-CENTRIC) for each gamepad.
     *
     * @param driverStationTelemetry The telemetry object for displaying data on the driver station.
     * @param dashboardTelemetry The telemetry object for displaying data on the FTC Dashboard.
     * @param gamepad1DriveType The drive mode for Gamepad 1.
     * @param gamepad2DriveType The drive mode for Gamepad 2.
     */
    public static void displayDriveModes(Telemetry driverStationTelemetry,
                                         Telemetry dashboardTelemetry,
                                         DriveTypes gamepad1DriveType,
                                         DriveTypes gamepad2DriveType) {
        driverStationTelemetry.addLine("-----------------------------");
        driverStationTelemetry.addLine("Gamepad1 Drive-Type: " + gamepad1DriveType);
        driverStationTelemetry.addLine("Gamepad2 Drive-Type: " + gamepad2DriveType);

        dashboardTelemetry.addLine("-----------------------------");
        dashboardTelemetry.addLine("Gamepad1 Drive-Type: " + gamepad1DriveType);
        dashboardTelemetry.addLine("Gamepad2 Drive-Type: " + gamepad2DriveType);
    }

    /**
     * Displays the current alliance color (RED, BLUE, or NONE).
     *
     * @param driverStationTelemetry The telemetry object for displaying data on the driver station.
     * @param dashboardTelemetry The telemetry object for displaying data on the FTC Dashboard.
     * @param allianceColor The color of the current alliance.
     */
    public static void displayAlliance(Telemetry driverStationTelemetry,
                                       Telemetry dashboardTelemetry,
                                       AllianceColors allianceColor) {
        driverStationTelemetry.addLine("-----------------------------");
        driverStationTelemetry.addLine("Alliance Color: " + allianceColor);

        dashboardTelemetry.addLine("-----------------------------");
        dashboardTelemetry.addLine("Alliance Color: " + allianceColor);
    }

    /**
     * Displays the robot's current position and heading based on a {@link Pose2d}.
     *
     * @param driverStationTelemetry The telemetry object for displaying data on the driver station.
     * @param dashboardTelemetry The telemetry object for displaying data on the FTC Dashboard.
     * @param pose The {@link Pose2d} object representing the robot's position and heading.
     */
    public static void displayPosition(Telemetry driverStationTelemetry,
                                       Telemetry dashboardTelemetry,
                                       Pose2d pose) {
        driverStationTelemetry.addLine("-----------------------------");
        driverStationTelemetry.addData("X", pose.position.x);
        driverStationTelemetry.addData("Y", pose.position.y);
        driverStationTelemetry.addData("Heading (Degrees)", Math.toDegrees(pose.heading.toDouble()));

        dashboardTelemetry.addLine("-----------------------------");
        dashboardTelemetry.addData("X", pose.position.x);
        dashboardTelemetry.addData("Y", pose.position.y);
        dashboardTelemetry.addData("Heading (Degrees)", Math.toDegrees(pose.heading.toDouble()));
    }

    /**
     * Displays detailed information about a detected AprilTag on both telemetry outputs.
     *
     * <p>If the given detection is {@code null}, no data is displayed.</p>
     *
     * @param driverStationTelemetry The telemetry object for displaying data on the driver station.
     * @param dashboardTelemetry The telemetry object for displaying data on the FTC Dashboard.
     * @param detectedId The {@link AprilTagDetection} object representing the detected AprilTag, or {@code null} if none was detected.
     */
    public static void displayAprilTag(Telemetry driverStationTelemetry,
                                Telemetry dashboardTelemetry,
                                AprilTagDetection detectedId) {
        if (detectedId == null) return;

        driverStationTelemetry.addLine(String.format("\n==== (ID %d) %s", detectedId.id, detectedId.metadata.name));
        driverStationTelemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (cm)", detectedId.ftcPose.x, detectedId.ftcPose.y, detectedId.ftcPose.z));
        driverStationTelemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detectedId.ftcPose.pitch, detectedId.ftcPose.roll, detectedId.ftcPose.yaw));
        driverStationTelemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (cm, deg, deg)", detectedId.ftcPose.range, detectedId.ftcPose.bearing, detectedId.ftcPose.elevation));

        dashboardTelemetry.addLine(String.format("\n==== (ID %d) %s", detectedId.id, detectedId.metadata.name));
        dashboardTelemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (cm)", detectedId.ftcPose.x, detectedId.ftcPose.y, detectedId.ftcPose.z));
        dashboardTelemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detectedId.ftcPose.pitch, detectedId.ftcPose.roll, detectedId.ftcPose.yaw));
        dashboardTelemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (cm, deg, deg)", detectedId.ftcPose.range, detectedId.ftcPose.bearing, detectedId.ftcPose.elevation));
    }

    /**
     * Displays the measured distance from the infrared sensor on both telemetry outputs.
     *
     * <p>This method sends formatted distance information to both the Driver Station telemetry
     * and the FTC Dashboard telemetry, allowing simultaneous monitoring of sensor readings.</p>
     *
     * @param driverStationTelemetry The telemetry object for displaying data on the Driver Station phone.
     * @param dashboardTelemetry The telemetry object for displaying data on the FTC Dashboard.
     * @param distance The distance value reported by the sensor.
     * @param unit The {@link org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit} used for the distance measurement.
     */
    public static void displayDistance(Telemetry driverStationTelemetry,
                                       Telemetry dashboardTelemetry,
                                       double distance,
                                       DistanceUnit unit) {
        driverStationTelemetry.addLine(String.format("Distance: %.2f %s", distance, unit.name()));
        dashboardTelemetry.addLine(String.format("Distance: %.2f %s", distance, unit.name()));
    }
}