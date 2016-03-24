package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by MRHFTC on 3/22/2016.
 */
public class AM_BlueAutoOp extends AM_AutoOp {
    public void toDeploy() {
        if(this.time < 1) {
            rThrottle = 0.25;
            lThrottle = 0.25;
        }
        else if(this.time >= 1 && this.time < 1.6 ) {
            rThrottle = -0.5;
            lThrottle = 0.5;
        }
        else if(this.time >= 1.6 && this.time < 3.6) {
            rThrottle = 0.5;
            lThrottle = 0.5;
        }
        else if(this.time >= 3.6 && this.time < 5.6) {
            rThrottle = 0.0;
            lThrottle = 0.0;
            depoArm.setPosition(0.0);
        }
        else if(this.time >= 5.6 && this.time < 7) {
            rThrottle = -0.5;
            lThrottle = -0.5;
            depoArm.setPosition(1.0);
        }
    }
    public void upHill() {
        if(this.time >= 7 && this.time < 8) {
            rThrottle = -0.5;
            lThrottle = 0.5;
        }
        else if(this.time >= 8 && this.time < 10) {
            rThrottle = 0.5;
            lThrottle = 0.5;
        }
        else
        {
            rThrottle = 0.0;
            lThrottle = 0.0;
        }
    }
}
