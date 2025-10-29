package org.firstinspires.ftc.teamcode.systems.camera;

//==============================Robot Core=============================
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

//================================Vision===============================
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

//=============================Ftc Dashboard============================
import com.acmerobotics.dashboard.FtcDashboard;

//==============================Java utils==============================
import java.util.ArrayList;

//=============================Android utils============================
import android.util.Size;

public class AprilTagCamera {

    //=============================================================
    //===================VARIABLE INITIALIZATION==================
    //=============================================================

    //======================AprilTag Processor====================
    private AprilTagProcessor aprilTagProcesor;

    //======================Vision Portal=========================
    private VisionPortal visionPortal;

    //======================Detection list========================
    private ArrayList<AprilTagDetection> detectionTags = new ArrayList<>();

    //======================Dashboard============================
    FtcDashboard dashboard = FtcDashboard.getInstance();

    //=============================================================
    //=========================INIT METHOD=========================
    //=============================================================

    public void init(HardwareMap hardwareMap, Telemetry telemetry) {

        //====================Initialize AprilTag Processor=====================
        aprilTagProcesor = new AprilTagProcessor.Builder()
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .setDrawAxes(true)
                .setDrawCubeProjection(true)
                .setOutputUnits(DistanceUnit.CM, AngleUnit.DEGREES)
                .build();

        //====================Initialize Vision Portal==========================
        VisionPortal.Builder builder = new VisionPortal.Builder();
        builder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
        builder.setCameraResolution(new Size(640, 480));
        builder.addProcessor(aprilTagProcesor);
        visionPortal = builder.build();

        //====================Start Dashboard Stream===========================
        dashboard.startCameraStream(visionPortal, 30);
    }

    public void update() {
        //==================Get all detected AprilTags==================
        detectionTags = aprilTagProcesor.getDetections();
    }

    //=============================================================
    //=======================GETTER METHODS========================
    //=============================================================

    //==================Get all detected tags======================
    public ArrayList<AprilTagDetection> getDetectionTags() {
        return detectionTags;
    }

    //==================Get detection by specific ID================
    public AprilTagDetection getTagBySpecifiedId(int id) {
        for (AprilTagDetection detection : detectionTags) {
            if (detection.id == id) {
                return detection;
            }
        }
        return null;
    }

    public double getAngleByTag(AprilTagDetection detectedTag) {
        return detectedTag.ftcPose.yaw;
    }

    public Double getAngleByTagId(int id) {
        for (AprilTagDetection detection : detectionTags) {
            if (detection.id == id) {
                return detection.ftcPose.yaw;
            }
        }
        return null;
    }

    //=============================================================
    //=========================STOP METHOD=========================
    //=============================================================

    public void stop() {
        //====================Close Vision Portal=====================
        if (visionPortal != null) {
            visionPortal.close();
        }
    }
}
