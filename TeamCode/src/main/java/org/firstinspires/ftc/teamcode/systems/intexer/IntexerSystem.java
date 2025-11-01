package org.firstinspires.ftc.teamcode.systems.intexer;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntexerSystem { // intake + indexer

    static DcMotor intake;

    public IntexerSystem(HardwareMap hardwareMap){
        intake = hardwareMap.get(DcMotorEx.class, "intake");
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void move(double power){
        intake.setPower(power);
    }

}
