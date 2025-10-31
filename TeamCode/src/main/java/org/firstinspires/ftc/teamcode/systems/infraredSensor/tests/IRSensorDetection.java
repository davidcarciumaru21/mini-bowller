package org.firstinspires.ftc.teamcode.systems.infraredSensor.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.utils.TelemetryMethods;
import org.firstinspires.ftc.teamcode.systems.infraredSensor.InfraredSensor;
import com.acmerobotics.dashboard.FtcDashboard;

@Autonomous(name = "IRSensorDetection", group = "Tests")
public class IRSensorDetection extends LinearOpMode {

    @Override
    public void runOpMode() {

        InfraredSensor distanceSensor = new InfraredSensor(hardwareMap);
        FtcDashboard dashboard = FtcDashboard.getInstance();
        Telemetry dashboardTelemetry = dashboard.getTelemetry();

        waitForStart();

        while (opModeIsActive()) {
            TelemetryMethods.displayDistance(telemetry, dashboardTelemetry, distanceSensor.getDistanceInCm(), DistanceUnit.CM);
            TelemetryMethods.displayDistance(telemetry, dashboardTelemetry, distanceSensor.getDistanceInCm(), DistanceUnit.INCH);
            telemetry.update();
            dashboardTelemetry.update();
        }
    }
}
