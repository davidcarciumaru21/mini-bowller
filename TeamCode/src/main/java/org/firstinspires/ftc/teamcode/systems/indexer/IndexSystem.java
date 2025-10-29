package org.firstinspires.ftc.teamcode.systems.indexer;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IndexSystem {
    static CRServo rightIndexerServo;
    static CRServo leftIndexerServo;

    public IndexSystem(HardwareMap hardwareMap) {
        rightIndexerServo = hardwareMap.get(CRServo.class, "rightIndexerServo");
        leftIndexerServo = hardwareMap.get(CRServo.class, "leftIndexerServo");
    }

    public void start() {
        rightIndexerServo.setPower(1.0);
        leftIndexerServo.setPower(1.0);
    }

    public void stop() {
        rightIndexerServo.setPower(0.0);
        leftIndexerServo.setPower(0.0);
    }
}