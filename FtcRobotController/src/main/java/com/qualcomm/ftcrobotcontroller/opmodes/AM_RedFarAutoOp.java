package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by MRHFTC on 3/22/2016.
 */
public class AM_RedFarAutoOp extends AM_BlueAutoOp {
    public void upHill() {
        if(!resetHill) {
            resetStartTime();
            resetHill = true;
        }

        if(this.time >= 1 && this.time < 2) {
            rThrottle = -0.5;
            lThrottle = 0.5;
        }
    }
}
