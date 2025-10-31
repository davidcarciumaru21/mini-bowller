package org.firstinspires.ftc.teamcode.systems.infraredSensor;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class InfraredSensor {

    public DistanceSensor distanceSensor;

    public InfraredSensor(HardwareMap hardwareMap) {
        distanceSensor = hardwareMap.get(DistanceSensor.class, "infraredSensor");
    }

    public double getDistanceInCm() {
        return distanceSensor.getDistance(DistanceUnit.CM);
    }

    public double getDistanceInInch() {
        return distanceSensor.getDistance(DistanceUnit.INCH);
    }
}
