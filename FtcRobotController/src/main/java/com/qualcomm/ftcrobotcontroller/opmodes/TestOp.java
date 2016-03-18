package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by MRHFTC on 3/17/2016.
 */
public class TestOp extends AM_AbstractOp {

    // Variables for TeleOp
    Double front = 0.5;
    Double left = 0.5;
    Double right = 0.5;
    
    @Override
    public void loop() {

        if(gamepad1.y) {
            front += 0.01;
            while(gamepad1.y);
        }
        if(gamepad1.dpad_up){
            front -= 0.01;
            while(gamepad1.dpad_up);
        }

        if(gamepad1.x) {
            left += 0.01;
            while(gamepad1.x);
        }
        if(gamepad1.dpad_left) {
            left -= 0.01;
            while(gamepad1.dpad_left);
        }

        if(gamepad1.b) {
            right += 0.01;
            while(gamepad1.b);
        }
        if(gamepad1.dpad_right) {
            right -= 0.01;
            while(gamepad1.dpad_right);
        }

        frontArm.setPosition(front);
        leftArm.setPosition(left);
        rightArm.setPosition(right);

        telemetry.addData("Front Arm Position", frontArm.getPosition());
        telemetry.addData("Left Arm Position", leftArm.getPosition());
        telemetry.addData("Right Arm Position", rightArm.getPosition());



		/*
		 * Send telemetry data back to driver station. Note that if we are using
		 * a legacy NXT-compatible motor controller, then the getPower() method
		 * will return a null value. The legacy NXT-compatible motor controllers
		 * are currently write only.
		 */

    }

    /*
     * Code to run when the op mode is first disabled goes here
     *
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#stop()
     */
    @Override
    public void stop() {

    }
}
