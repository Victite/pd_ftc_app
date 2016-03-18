package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by MRHFTC on 3/17/2016.
 */
public class AM_BlueTeleOp extends AM_TeleOp {
    public void swingers() {
        if (gamepad1.x) {
            if (leftArm.getPosition() > 0.6)
                leftArm.setPosition(0.75);
            else if (leftArm.getPosition() < 0.6 && leftArm.getPosition() > 0.8)
                leftArm.setPosition(0.878);
            else
                leftArm.setPosition(0.137);
            while (gamepad1.x);
        }
    }
}
