package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by MRHFTC on 3/22/2016.
 */
public class AM_BlueFarAutoOp extends AM_BlueAutoOp {
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
