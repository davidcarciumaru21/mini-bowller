package org.firstinspires.ftc.teamcode.systems.stopper;

import static java.lang.Math.abs;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class StopperSystem {
    static double positionON = 1.0;
    static double positionOFF = 0.3;
    static Servo stopper;
    boolean state;

    public StopperSystem(HardwareMap hardwareMap){
        stopper = hardwareMap.get(Servo.class, "stopper");
    }

    public void on(){
        stopper.setPosition(positionON);
        state = (abs(stopper.getPosition() - positionON) < 3);
    }

    public void off(){
        stopper.setPosition(positionOFF);
        state = (abs(stopper.getPosition() - positionOFF) < 3);
    }

    public boolean getState(){
        return state;
    }
}