package org.firstinspires.ftc.teamcode.systems.camera.tests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.systems.camera.AprilTagCamera;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.teamcode.utils.TelemetryMethods;

@Autonomous(name = "AprilTagDetectionTest", group = "Tests")
public class AprilTagDetectionTest extends LinearOpMode {

    private AprilTagCamera aprilTagCamera;
    private FtcDashboard dashboard;
    private Telemetry dashboardTelemetry;

    @Override
    public void runOpMode() throws InterruptedException {

        aprilTagCamera = new AprilTagCamera();
        dashboard = FtcDashboard.getInstance();
        dashboardTelemetry = dashboard.getTelemetry();

        telemetry.addLine("Initializing AprilTag camera...");
        telemetry.update();

        aprilTagCamera.init(hardwareMap, telemetry);

        telemetry.addLine("Initialization complete. Waiting for start...");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            aprilTagCamera.update();

            AprilTagDetection id21 = aprilTagCamera.getTagBySpecifiedId(21);

            TelemetryMethods.displayAprilTag(telemetry, dashboardTelemetry, id21);

            telemetry.update();
            dashboardTelemetry.update();

        }

        aprilTagCamera.stop();
    }
}
