// Joshua Biggs
// MRHS FTC 2016
// 01/10/16

package com.qualcomm.ftcrobotcontroller.opmodes;

public class AM_TeleOp extends AM_AbstractOp {
    public AM_TeleOp() {
        super();
    }
    
    boolean depotDeployed = false;
    boolean climberReleased = false;

    @Override
    public void init() {
        sv_depositArm.setPosition(0.0);
        sv_climbingArm.setPosition(1.0);
    }

    @Override
    public void loop() {
        float rightThrottle =  gamepad1.right_stick_y;
        float leftThrottle = gamepad1.left_stick_y;
        float tapeAngle = (float)0.5 * (gamepad1.right_trigger - gamepad1.left_trigger);

        if(gamepad1.a) {
            depotDeployed = !depotDeployed;
            try {
                Thread.sleep(200);
            } catch(InterruptedException e) {
            }
        }

        dc_FR.setPower(rightThrottle);
        dc_FL.setPower(leftThrottle);
        dc_BR.setPower(rightThrottle);
        dc_BL.setPower(leftThrottle);

        dc_angle.setPower(tapeAngle);

        if(gamepad1.right_bumper) {
            dc_tape1.setPower(1.0);
            dc_tape2.setPower(1.0);
            dc_tape3.setPower(1.0);
        }
        else if(gamepad1.left_bumper) {
            dc_tape1.setPower(-1.0);
            dc_tape2.setPower(-1.0);
            dc_tape3.setPower(-1.0);
        }
        else {
            dc_tape1.setPower(0.0);
            dc_tape2.setPower(0.0);
            dc_tape3.setPower(0.0);
        }

        if(depotDeployed) {
            sv_depositArm.setPosition(1.0);
        }
        else{
            sv_depositArm.setPosition(0.0);
        }
        
        if(gamepad1.y) {
            if(!climberReleased) {
                climberReleased = true;
                sv_climbingArm.setPosition(0.0);
            }
        }


    }

    @Override
    public void stop() {
        dc_tape1.setPower(0.0);
        dc_tape2.setPower(0.0);
        dc_tape3.setPower(0.0);
    }
}