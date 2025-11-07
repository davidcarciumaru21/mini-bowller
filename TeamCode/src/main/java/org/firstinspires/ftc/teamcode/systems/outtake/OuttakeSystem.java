package org.firstinspires.ftc.teamcode.systems.outtake;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class OuttakeSystem {
    static DcMotorEx outtake;

    // 6000 RPM motor (free speed)
    private static final double MAX_RPM = 6000.0;
    private static final double TOLERANCE = 0.15; // 10% tolerance band

    public OuttakeSystem(HardwareMap hardwareMap) {
        outtake = hardwareMap.get(DcMotorEx.class, "outtake");
        outtake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void move(double power) {
        outtake.setPower(power);
    }

    // Returns true if current motor speed is close to expected speed for the given power.
    public boolean isAtTargetSpeed(double targetPower) {
        // Read encoder velocity in ticks per second
        double velocityTicksPerSec = outtake.getVelocity();

        // Convert ticks/sec -> RPM
        double ticksPerRev = outtake.getMotorType().getTicksPerRev();
        double currentRPM = (velocityTicksPerSec / ticksPerRev) * 6000.0;

        // Expected RPM (rough approximation)
        double expectedRPM = MAX_RPM * targetPower;

        // Check if within tolerance
        return Math.abs(currentRPM - expectedRPM) <= (TOLERANCE * expectedRPM);
    }
}
