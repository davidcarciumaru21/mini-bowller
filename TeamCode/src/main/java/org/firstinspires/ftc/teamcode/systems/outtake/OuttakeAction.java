package org.firstinspires.ftc.teamcode.systems.outtake;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class OuttakeAction {
    static DcMotorEx outtake;

    // 6000 RPM motor (free speed)
    private static final double MAX_RPM = 6000.0;
    private static final double TOLERANCE = 0.1; // 10% tolerance band

    public OuttakeAction(HardwareMap hardwareMap) {
        outtake = hardwareMap.get(DcMotorEx.class, "outtake");
        outtake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public boolean isAtTargetSpeed(double targetPower) {
        // Read encoder velocity in ticks per second
        double velocityTicksPerSec = outtake.getVelocity();

        // Convert ticks/sec -> RPM
        double ticksPerRev = outtake.getMotorType().getTicksPerRev();
        double currentRPM = (velocityTicksPerSec / ticksPerRev) * 60.0;

        // Expected RPM (rough approximation)
        double expectedRPM = MAX_RPM * targetPower;

        // Check if within tolerance
        return Math.abs(currentRPM - expectedRPM) <= (TOLERANCE * expectedRPM);
    }

    public Action moveAction(double power) {
        return new Action() {
            @Override
            public boolean run(TelemetryPacket packet) {
                outtake.setPower(power);

                // Keep running while spinning up
                return !isAtTargetSpeed(power);
            }
        };
    }
}
