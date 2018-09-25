package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

// PROGRAM PRINCIPAL
@TeleOp(name="Bucuresti_v2", group="Linear OpMode")

public class Bucuresti extends LinearOpMode {

    private DcMotor Motor_A1;
    private DcMotor Motor_A2;
    private DcMotor Motor_B1;
    private DcMotor Motor_B2;
    private DcMotor Motor_Brat;

    private Servo Servo_R;

    private Servo Servo_brat1;
    private Servo Servo_brat2;

    private Servo Servo_Color;
    @Override
    public void runOpMode() {

        Motor_A1        = hardwareMap.dcMotor.get("Motor_A1");
        Motor_A2        = hardwareMap.dcMotor.get("Motor_A2");
        Motor_B1        = hardwareMap.dcMotor.get("Motor_B1");
        Motor_B2        = hardwareMap.dcMotor.get("Motor_B2");
        Motor_Brat = hardwareMap.dcMotor.get("Motor_Brat");
        Servo_brat1         = hardwareMap.servo.get("Servo_brat1");
        Servo_brat2         = hardwareMap.servo.get("Servo_brat2");

        Servo_Color         = hardwareMap.servo.get("arm");


        final double adauga = 0.01;
        double set_positionR = 1;
        double set_position_brat = 0;
        double set_positionL = 0;


       // Servo_R.setPosition(set_positionR);
        Servo_brat1.setPosition(set_positionL);
        Servo_brat2.setPosition(set_positionR);
       // Servo_Relic.setPosition(set_position_brat);
       // Servo_Brelic.setPosition(set_position_brat);
        Servo_Color.setPosition(0.2);
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            Servo_Color.setPosition(0.2);
            Motor_A1.setDirection(DcMotor.Direction.REVERSE);
            Motor_A2.setDirection(DcMotor.Direction.REVERSE);
            Motor_B1.setDirection(DcMotor.Direction.REVERSE);
            Motor_B2.setDirection(DcMotor.Direction.REVERSE);
            Motor_Brat.setDirection(DcMotor.Direction.REVERSE);


            //--------------------------------------------------------------------------------------
            if (gamepad1.left_stick_y != 0 || gamepad1.right_stick_y != 0) {
                Motor_A1.setPower(gamepad1.left_stick_y / 3);
                Motor_A2.setPower(-gamepad1.left_stick_y / 3);
                Motor_B1.setPower(gamepad1.right_stick_y / 3);
                Motor_B2.setPower(-gamepad1.right_stick_y / 3);
            }
            else

            if (gamepad1.left_stick_x != 0 || gamepad1.right_stick_x != 0) {
                Motor_A1.setPower(gamepad1.left_stick_x / 3);
                Motor_A2.setPower(gamepad1.left_stick_x / 3);
                Motor_B1.setPower(gamepad1.right_stick_x / 3);
                Motor_B2.setPower(gamepad1.right_stick_x / 3);
            }
            else
            {
                Motor_B1.setPower(0);
                Motor_B2.setPower(0);
                Motor_A1.setPower(0);
                Motor_A2.setPower(0);
            }
            //--------------------------------------------------------------------------------------
            if (gamepad2.right_stick_y != 0) {
                Motor_Brat.setPower(-gamepad2.right_stick_y / 80);
            }
            if(gamepad2.left_stick_y !=0){
                Motor_Brat.setPower(-gamepad2.left_stick_y/3);
            }

            if(gamepad2.left_stick_y ==0 && gamepad2.right_stick_y == 0)
            Motor_Brat.setPower(0.15);
            //--------------------------------------------------------------------------------------
            if (gamepad2.x) {
                Servo_brat1.setPosition(1);
                Servo_brat2.setPosition(0);
            }
            if (gamepad2.y) {
                Servo_brat1.setPosition(0);
                Servo_brat2.setPosition(1);
            }
        }
    }
}



