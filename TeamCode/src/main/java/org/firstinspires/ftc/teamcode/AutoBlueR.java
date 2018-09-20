package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.ClassFactory;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;


@Autonomous(name="A_Blue - Right", group="Pushbot")
public class AutoBlueR extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareConfig robot        = new HardwareConfig();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();
    ColorSensor colorSensor     = null;

    VuforiaLocalizer vuforia;

    @Override
    public void runOpMode() {

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = "AeEX3c//////AAAAmbpcMvaRlkLItBHUSRuTH8oD9HGIyP1hAJOA1OLQncbl5AVq29yavay2TmNbYPHtM59q8YD87RZ1PHogpyMISzi9a/o8YvUWSkFtrU36njXr/tqSJ2CkOUNF1n87kzKsyN+ttusx2l9d2V3BzvY7T5yKjJ8teWRZrbE7HZQvOqwX7AnDWdapylIPyopb3TSW9aqnihTvPPGhyT7VnALVbbo54xvBuvznM1M743yZGGjRUcmzTdb10yP5Dq0RNGLwAbKJjNfocFU4AA0JiNaRK7udJRiEpvwK/00YqtpHl/xz1Pu5Rw8LQvN6QjK1JQEUaxrTvtERTWn7w34AqoKbNTIdh1ZcF6wrftdvvsUs76F8";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);

        float hsvValues[] = {0F, 0F, 0F};
        final float values[] = hsvValues;

        robot.init(hardwareMap);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        relicTrackables.activate();

        while (opModeIsActive()) {

            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);

            if (vuMark != RelicRecoveryVuMark.UNKNOWN) {

                if (vuMark == RelicRecoveryVuMark.RIGHT) {
                    telemetry.addData("VuMark", "%s visible", "centru");
                    telemetry.update();


                    robot.arm.setPosition(1);
                    robot.servo_brat1.setPosition(0);
                    robot.servo_brat2.setPosition(1);
                    sleep(3000);
                    robot.servo_brat1.setPosition(1);
                    robot.servo_brat2.setPosition(0);
                    sleep(1000);
                    robot.motor_brat.setPower(0.25);
                    sleep(900);
                    robot.motor_brat.setPower(0.1);

                    if (robot.colorSensor.red() < robot.colorSensor.blue()) {
                        robot.motorA1.setPower(0.05);
                        robot.motorA2.setPower(0.05);
                        robot.motorB1.setPower(-0.05);
                        robot.motorB2.setPower(-0.05);
                        sleep(1500);
                        robot.motorA1.setPower(0);
                        robot.motorA2.setPower(0);
                        robot.motorB1.setPower(0);
                        robot.motorB2.setPower(0);
                        sleep(1500);
                        robot.motorA1.setPower(-0.05);
                        robot.motorA2.setPower(-0.05);
                        robot.motorB1.setPower(0.05);
                        robot.motorB2.setPower(0.05);
                        sleep(350);

                    } else if (robot.colorSensor.red() > robot.colorSensor.blue()) {
                        robot.motorA1.setPower(-0.05);
                        robot.motorA2.setPower(-0.05);
                        robot.motorB1.setPower(0.05);
                        robot.motorB2.setPower(0.05);
                        sleep(1500);
                        robot.motorA1.setPower(0);
                        robot.motorA2.setPower(0);
                        robot.motorB1.setPower(0);
                        robot.motorB2.setPower(0);
                        sleep(1500);
                        robot.motorA1.setPower(0.05);
                        robot.motorA2.setPower(0.05);
                        robot.motorB1.setPower(-0.05);
                        robot.motorB2.setPower(-0.05);
                        sleep(350);

                    }
                    //Servo come back
                    robot.arm.setPosition(0.1);
                    sleep(1000);


                    //MERGERE FATA
                    robot.motorA1.setPower(0.25);
                    robot.motorA2.setPower(-0.25);
                    robot.motorB1.setPower(-0.25);
                    robot.motorB2.setPower(0.25);
                    sleep(1650);


                    //ROTIRE
                    robot.motorA1.setPower(0.25);
                    robot.motorA2.setPower(0.25);
                    robot.motorB1.setPower(-0.25);
                    robot.motorB2.setPower(-0.25);
                    sleep(660);

                    robot.motorA1.setPower(-0.25);
                    robot.motorA2.setPower(0.25);
                    robot.motorB1.setPower(0.25);
                    robot.motorB2.setPower(-0.25);
                    sleep(800);

                    robot.servo_brat1.setPosition(0);
                    robot.servo_brat2.setPosition(1);

                    robot.motorA1.setPower(0.25);
                    robot.motorA2.setPower(-0.25);
                    robot.motorB1.setPower(-0.25);
                    robot.motorB2.setPower(0.25);
                    sleep(500);

                    robot.servo_brat1.setPosition(1);
                    robot.servo_brat2.setPosition(0);

                    robot.motor_brat.setPower(-0.25);
                    sleep(300);
                    robot.motor_brat.setPower(0);

                    robot.motorA1.setPower(-0.25);
                    robot.motorA2.setPower(0.25);
                    robot.motorB1.setPower(0.25);
                    robot.motorB2.setPower(-0.25);
                    sleep(1500);
                    /*
                    robot.servo_brat1.setPosition(0);
                    robot.servo_brat2.setPosition(1);
                    */
                    robot.motorA1.setPower(0.25);
                    robot.motorA2.setPower(-0.25);
                    robot.motorB1.setPower(-0.25);
                    robot.motorB2.setPower(0.25);
                    sleep(200);
                    /*
                    robot.servo_brat1.setPosition(0);
                    robot.servo_brat2.setPosition(1);
   s                 */

                    //Stop the motors
                    robot.motorA1.setPower(0);
                    robot.motorA2.setPower(0);
                    robot.motorB1.setPower(0);
                    robot.motorB2.setPower(0);

                    telemetry.addData("Path", "Complete");
                    telemetry.update();
                    sleep(1000);
                }

                if (vuMark == RelicRecoveryVuMark.CENTER) {
                    telemetry.addData("VuMark", "%s visible", "dreapta");
                    telemetry.update();

                    robot.arm.setPosition(1);
                    robot.servo_brat1.setPosition(0);
                    robot.servo_brat2.setPosition(1);
                    sleep(3000);
                    robot.servo_brat1.setPosition(1);
                    robot.servo_brat2.setPosition(0);
                    sleep(1000);
                    robot.motor_brat.setPower(0.25);
                    sleep(900);
                    robot.motor_brat.setPower(0.1);


                    if (robot.colorSensor.red() < robot.colorSensor.blue()) {
                        robot.motorA1.setPower(0.05);
                        robot.motorA2.setPower(0.05);
                        robot.motorB1.setPower(-0.05);
                        robot.motorB2.setPower(-0.05);
                        sleep(1500);
                        robot.motorA1.setPower(0);
                        robot.motorA2.setPower(0);
                        robot.motorB1.setPower(0);
                        robot.motorB2.setPower(0);
                        sleep(1500);
                        robot.motorA1.setPower(-0.05);
                        robot.motorA2.setPower(-0.05);
                        robot.motorB1.setPower(0.05);
                        robot.motorB2.setPower(0.05);
                        sleep(350);

                    } else if (robot.colorSensor.red() > robot.colorSensor.blue()) {
                        robot.motorA1.setPower(-0.05);
                        robot.motorA2.setPower(-0.05);
                        robot.motorB1.setPower(0.05);
                        robot.motorB2.setPower(0.05);
                        sleep(1500);
                        robot.motorA1.setPower(0);
                        robot.motorA2.setPower(0);
                        robot.motorB1.setPower(0);
                        robot.motorB2.setPower(0);
                        sleep(1500);
                        robot.motorA1.setPower(0.05);
                        robot.motorA2.setPower(0.05);
                        robot.motorB1.setPower(-0.05);
                        robot.motorB2.setPower(-0.05);
                        sleep(350);

                    }
                    //Servo come back
                    robot.arm.setPosition(0.1);
                    sleep(1000);

                    //MERGERE INAINTE
                    robot.motorA1.setPower(0.25);
                    robot.motorA2.setPower(-0.25);
                    robot.motorB1.setPower(-0.25);
                    robot.motorB2.setPower(0.25);
                    sleep(1450);//stay here for 1 second,don't move to next instructions

                    //ROTIRE SPRE COLOANE
                    robot.motorA1.setPower(0.25);
                    robot.motorA2.setPower(0.25);
                    robot.motorB1.setPower(-0.25);
                    robot.motorB2.setPower(-0.25);
                    sleep(700);

                    //MERGERE INAINTE SPRE COLOANE
                    robot.motorA1.setPower(-0.25);
                    robot.motorA2.setPower(0.25);
                    robot.motorB1.setPower(0.25);
                    robot.motorB2.setPower(-0.25);
                    sleep(500);

                    robot.servo_brat1.setPosition(0);
                    robot.servo_brat2.setPosition(1);
                    sleep(800);

                    //MERGERE INAPOIT DE LA COLOANE
                    robot.motorA1.setPower(0.25);
                    robot.motorA2.setPower(-0.25);
                    robot.motorB1.setPower(-0.25);
                    robot.motorB2.setPower(0.25);
                    sleep(400);

                    robot.servo_brat1.setPosition(1);
                    robot.servo_brat2.setPosition(0);

                    robot.motor_brat.setPower(-0.25);
                    sleep(300);
                    robot.motor_brat.setPower(0);

                    //MERGERE INAINTE PENTRU A IMPINGE CUBUL
                    robot.motorA1.setPower(-0.25);
                    robot.motorA2.setPower(0.25);
                    robot.motorB1.setPower(0.25);
                    robot.motorB2.setPower(-0.25);
                    sleep(800);
                    /**/
                    //MERGERE INAPOI PENTRU PARCARE
                    robot.motorA1.setPower(0.25);
                    robot.motorA2.setPower(-0.25);
                    robot.motorB1.setPower(-0.25);
                    robot.motorB2.setPower(0.25);
                    sleep(200);
                    /*
                    robot.servo_brat1.setPosition(0);
                    robot.servo_brat2.setPosition(1);
                    */

                    //Stop the motors
                    robot.motorA1.setPower(0);
                    robot.motorA2.setPower(0);
                    robot.motorB1.setPower(0);
                    robot.motorB2.setPower(0);

                    telemetry.addData("Path", "Complete");
                    telemetry.update();
                    sleep(1000);
                }

                if (vuMark == RelicRecoveryVuMark.LEFT) {
                    telemetry.addData("VuMark", "%s visible", "stanga");
                    telemetry.update();

                    robot.arm.setPosition(1);

                    robot.servo_brat1.setPosition(0);
                    robot.servo_brat2.setPosition(1);
                    sleep(3000);
                    robot.servo_brat1.setPosition(1);
                    robot.servo_brat2.setPosition(0);
                    sleep(1000);
                    robot.motor_brat.setPower(0.25);
                    sleep(900);
                    robot.motor_brat.setPower(0.1);

                    if (robot.colorSensor.red() < robot.colorSensor.blue()) {
                        robot.motorA1.setPower(0.05);
                        robot.motorA2.setPower(0.05);
                        robot.motorB1.setPower(-0.05);
                        robot.motorB2.setPower(-0.05);
                        sleep(1500);
                        robot.motorA1.setPower(0);
                        robot.motorA2.setPower(0);
                        robot.motorB1.setPower(0);
                        robot.motorB2.setPower(0);
                        sleep(1500);
                        robot.motorA1.setPower(-0.05);
                        robot.motorA2.setPower(-0.05);
                        robot.motorB1.setPower(0.05);
                        robot.motorB2.setPower(0.05);
                        sleep(350);

                    } else if (robot.colorSensor.red() > robot.colorSensor.blue()) {
                        robot.motorA1.setPower(-0.05);
                        robot.motorA2.setPower(-0.05);
                        robot.motorB1.setPower(0.05);
                        robot.motorB2.setPower(0.05);
                        sleep(1500);
                        robot.motorA1.setPower(0);
                        robot.motorA2.setPower(0);
                        robot.motorB1.setPower(0);
                        robot.motorB2.setPower(0);
                        sleep(1500);
                        robot.motorA1.setPower(0.05);
                        robot.motorA2.setPower(0.05);
                        robot.motorB1.setPower(-0.05);
                        robot.motorB2.setPower(-0.05);
                        sleep(350);

                    }
                    //Servo come back
                    robot.arm.setPosition(0.1);
                    sleep(1000);


                    //Drive the robot forward
                    robot.motorA1.setPower(0.25);
                    robot.motorA2.setPower(-0.25);
                    robot.motorB1.setPower(-0.25);
                    robot.motorB2.setPower(0.25);
                    sleep(1150);//stay here for 1 second,don't move to next instructions


                    //Rotatie
                    robot.motorA1.setPower(0.25);
                    robot.motorA2.setPower(0.25);
                    robot.motorB1.setPower(-0.25);
                    robot.motorB2.setPower(-0.25);
                    sleep(700);

                    //FATA
                    robot.motorA1.setPower(-0.25);
                    robot.motorA2.setPower(0.25);
                    robot.motorB1.setPower(0.25);
                    robot.motorB2.setPower(-0.25);
                    sleep(800);
                    robot.motorA1.setPower(0);
                    robot.motorA2.setPower(0);
                    robot.motorB1.setPower(0);
                    robot.motorB2.setPower(0);
                    sleep(200);
                    robot.servo_brat1.setPosition(0);
                    robot.servo_brat2.setPosition(1);
                    sleep(500);
                    //parcare-spate
                    robot.motorA1.setPower(0.25);
                    robot.motorA2.setPower(-0.25);
                    robot.motorB1.setPower(-0.25);
                    robot.motorB2.setPower(0.25);
                    sleep(300);

                    robot.servo_brat1.setPosition(1);
                    robot.servo_brat2.setPosition(0);
                    sleep(100);

                    robot.motor_brat.setPower(-0.25);
                    sleep(300);

                    robot.motor_brat.setPower(0);
                    //merge in fata
                    robot.motorA1.setPower(-0.25);
                    robot.motorA2.setPower(0.25);
                    robot.motorB1.setPower(0.25);
                    robot.motorB2.setPower(-0.25);
                    sleep(800);

                    robot.motorA1.setPower(0.25);
                    robot.motorA2.setPower(-0.25);
                    robot.motorB1.setPower(-0.25);
                    robot.motorB2.setPower(0.25);
                    sleep(200);

                    /*
                    robot.servo_brat1.setPosition(0);
                    robot.servo_brat2.setPosition(1);

                    robot.motorA1.setPower(0.25);
                    robot.motorA2.setPower(-0.25);
                    robot.motorB1.setPower(-0.25);
                    robot.motorB2.setPower(0.25);
                    sleep(200);

                    robot.servo_brat1.setPosition(0);
                    robot.servo_brat2.setPosition(1);
                    sleep(1000);
                    robot.servo_brat1.setPosition(1);
                    robot.servo_brat2.setPosition(0);
                    sleep(500);
                    */
                    //Stop the motors
                    robot.motorA1.setPower(0);
                    robot.motorA2.setPower(0);
                    robot.motorB1.setPower(0);
                    robot.motorB2.setPower(0);

                    telemetry.addData("Path", "Complete");
                    telemetry.update();
                    sleep(1000);
                }
                sleep (40000);
            }
        }
    }
}


