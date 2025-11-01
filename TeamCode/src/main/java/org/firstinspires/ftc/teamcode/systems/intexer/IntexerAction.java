package org.firstinspires.ftc.teamcode.systems.intexer;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntexerAction {
    static DcMotor intake;
    public IntexerAction(HardwareMap hardwareMap){
        intake = hardwareMap.get(DcMotorEx.class, "intake");
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public Action moveAction(double power) {
        return new Action() {

            @Override
            public boolean run(TelemetryPacket packet) {
                intake.setPower(power);

                if (intake.isBusy()) {
                    return true;
                }
                else{
                    return false;
                }
            }
        };
    }
}
