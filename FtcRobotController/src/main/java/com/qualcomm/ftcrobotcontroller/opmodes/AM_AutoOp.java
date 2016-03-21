package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by MRHFTC on 2.5/18/2016.
 */

public class AM_AutoOp extends AM_AbstractOp{
    double rThrottle;
    double lThrottle;

    @Override
    public void start() {
        resetStartTime();
    }

    @Override
    public void loop() {

        rThrottle = 0.0;
        lThrottle = 0.0;

        if(this.time < 1) {
            rThrottle = 0.25;
            lThrottle = 0.25;
        }
        else if(this.time >= 1 && this.time < 1.5 ) {
            rThrottle = -0.5;
            lThrottle = 0.5;
        }
        else if(this.time >= 1.5 && this.time < 3) {
            rThrottle = 0.5;
            lThrottle = 0.5;
        }
        else if(this.time >= 3 && this.time < 5) {
            rThrottle = 0.0;
            lThrottle = 0.0;
            depoArm.setPosition(0.0);
        }
        else if(this.time >= 5 && this.time < 6) {
            rThrottle = -1.0;
            lThrottle = -1.0;
            depoArm.setPosition(1.0);
        }
        else
        {
            rThrottle = -1.0;
            lThrottle = 1.0;
            depoArm.setPosition(1.0);
        }
        motorFR.setPower(-rThrottle);
        motorBR.setPower(-rThrottle);
        motorFL.setPower(-lThrottle);
        motorBL.setPower(-lThrottle);

        telemetry.addData("Time",this.time);

    }
}
