package org.firstinspires.ftc.teamcode.systems.camera.tests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.systems.camera.AprilTagCamera;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

import org.firstinspires.ftc.teamcode.utils.TelemetryMethods;

@Autonomous(name = "AprilTagDetectionTest", group = "Tests")
public class AprilTagDetectionTest extends OpMode {

    AprilTagCamera aprilTagCamera = new AprilTagCamera();
    FtcDashboard dashboard = FtcDashboard.getInstance();
    Telemetry dashboardTelemetry = dashboard.getTelemetry();

    @Override
    public void init() {
        aprilTagCamera.init(hardwareMap, telemetry);
    }

    @Override
    public void loop() {
        aprilTagCamera.update();
        AprilTagDetection id21 = aprilTagCamera.getTagBySpecifiedId(21);
        TelemetryMethods.displayAprilTag(telemetry, dashboardTelemetry, id21);
    }
}
