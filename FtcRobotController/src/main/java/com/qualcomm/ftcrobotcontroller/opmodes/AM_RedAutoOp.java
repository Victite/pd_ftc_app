package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by MRHFTC on 3/22/2016.
 */
public class AM_RedAutoOp extends AM_AutoOp{
    public void toDeploy() {
        if(!resetDeployed) {
            resetStartTime();
            resetDeployed = true;
        }

        if(this.time <= 1.0) {
            rThrottle = 0.2;
            lThrottle = 0.2;
        }
        else if(this.time <= 2.0) {
            rThrottle = 0.5;
            lThrottle = -0.5;
        }
        else if(this.time <= 3.85) {
            rThrottle = 0.5;
            lThrottle = 0.5;
        }
        else if(this.time <= 5.6) {
            rThrottle = 0.0;
            lThrottle = 0.0;
            depoArm.setPosition(0.0);
        }
        else if(this.time <= 6.45) {
            rThrottle = -0.5;
            lThrottle = -0.5;
            depoArm.setPosition(1.0);
        }
        else if(this.time <= 10) {
            endDeploy = true;
        }
    }
    public void upHill() {
        if(!resetHill) {
            resetStartTime();
            resetHill = true;
        }

        if(this.time <= 1.4) {
            rThrottle = 0.5;
            lThrottle = -0.5;
        } else if(this.time <= 5) {
            rThrottle = 1.0;
            lThrottle = 1.0;
        } else if(this.time <= 10) {
            rThrottle = 0.0;
            lThrottle = 0.0;
        }
    }
}
