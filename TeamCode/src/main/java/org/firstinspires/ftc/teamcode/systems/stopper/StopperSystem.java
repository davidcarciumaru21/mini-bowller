package org.firstinspires.ftc.teamcode.systems.stopper;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class StopperSystem {

    static int positionON = 90; // PLACEHOLDER
    static int positionOFF = 0; // PLACEHOLDER
    static Servo stopper;
    int state = 0;

    public StopperSystem(HardwareMap hardwareMap){
        stopper = hardwareMap.get(Servo.class, "stopper");
    }

    public void on(){
        stopper.setPosition(positionON);
        state = 1;
    }

    public void off(){
        stopper.setPosition(positionOFF);
        state = 0;
    }

    public boolean getState(){
        if(state == 0){
            return false;
        }
        else{
            return true;
        }
    }
}