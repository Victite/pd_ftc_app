package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by MRHFTC on 3/17/2016.
 */
public class AM_RedTeleOp extends AM_TeleOp{
    public void swingers() {
        if (gamepad1.x) {
            if (leftArm.getPosition() < 0.6)
                leftArm.setPosition(0.647);
            else if (leftArm.getPosition() > 0.6 && leftArm.getPosition() < 0.8)
                leftArm.setPosition(0.85);
            else
                leftArm.setPosition(0.08627451);
            while (gamepad1.x) {

            }
        }
    }
}
