package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by MRHFTC on 3/17/2016.
 */
public class AM_RedTeleOp extends AM_TeleOp{
    public void swingers() {
        if (gamepad1.x) {
            if (rightArm.getPosition() > 0.6)
                rightArm.setPosition(0.2);
            else if (rightArm.getPosition() < 0.6 && rightArm.getPosition() > 0.1)
                rightArm.setPosition(0.0);
            else
                rightArm.setPosition(0.7764706);
            while (gamepad1.x);
        }
    }
}
