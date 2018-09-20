
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;


public class HardwareConfig
{
    /* Public OpMode members. */
    public DcMotor      motorA1 = null;
    public DcMotor      motorA2 = null;
    public DcMotor      motorB1 = null;
    public DcMotor      motorB2 = null;
    public DcMotor      motor_brat = null;
    public Servo        arm = null;
    public Servo        servo_brat1 = null;
    public Servo        servo_brat2 = null;
    public ColorSensor  colorSensor = null;

    public final static double initial_pos = 0.0;
    public final static double min_pos = 0.0;
    public final static double max_pos = 0.5;


    /* public final static double ARM_HOME = 0.2;
    public final static double CLAW_HOME = 0.2;
    public final static double ARM_MIN_RANGE  = 0.20;
    public final static double ARM_MAX_RANGE  = 0.90;
    public final static double CLAW_MIN_RANGE  = 0.20;
    public final static double CLAW_MAX_RANGE  = 0.7;
*/
    /* Local OpMode members. */
    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwareConfig() {
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // save reference to HW Map
        hwMap = ahwMap;

        // Define and Initialize Motors
        motorA1         = hwMap.get(DcMotor.class, "Motor_A1");
        motorA2         = hwMap.get(DcMotor.class, "Motor_A2");
        motorB1         = hwMap.get(DcMotor.class, "Motor_B1");
        motorB2         = hwMap.get(DcMotor.class, "Motor_B2");
        motor_brat      = hwMap.get(DcMotor.class, "Motor_Brat");
        colorSensor     = hwMap.get(ColorSensor.class, "sensor_color");
        servo_brat1     = hwMap.get(Servo.class, "Servo_brat1");
        servo_brat2     = hwMap.get(Servo.class, "Servo_brat2");
        arm             = hwMap.get(Servo.class, "arm");
        motorA1.setDirection(DcMotor.Direction.REVERSE);
        motorA2.setDirection(DcMotor.Direction.REVERSE);
        motorB1.setDirection(DcMotor.Direction.FORWARD);
        motorB2.setDirection(DcMotor.Direction.FORWARD);
        motor_brat.setDirection(DcMotor.Direction.REVERSE);
        // Set all motors to zero power
        motorA1.setPower(0);
        motorA2.setPower(0);
        motorB1.setPower(0);
        motorB2.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        motorA1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorA2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorB1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorB2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //-----------------------------------------------------------------------------------------

        // Define and initialize ALL installed servos.
        //arm  = hwMap.get(Servo.class, "Servo_Color");
        //claw = hwMap.get(Servo.class, "claw");
        // arm.setPosition(initial_pos);
        //claw.setPosition(CLAW_HOME);
        //color_sensor = hwMap.get(ColorSensor.class, "Senzor_Color");
    }
}
