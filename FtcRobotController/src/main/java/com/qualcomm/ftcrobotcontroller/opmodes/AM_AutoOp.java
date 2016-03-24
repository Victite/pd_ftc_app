// Joshua Biggs
// 3/14/2016

package com.qualcomm.ftcrobotcontroller.opmodes;


public abstract class AM_AutoOp extends AM_AbstractOp{
    double rThrottle;
    double lThrottle;
    boolean resetDeployed;
    boolean resetHill;
    boolean endDeploy;

    abstract void toDeploy();

    abstract void upHill();

    @Override
    public void start() {
        rThrottle = 0.0;
        lThrottle = 0.0;
        resetDeployed = false;
        resetHill = false;
        endDeploy = false;
    }


    @Override
    public void loop() {
        if(!endDeploy)
            this.toDeploy();
        else
            this.upHill();

        motorFR.setPower(-rThrottle);
        motorBR.setPower(-rThrottle);
        motorFL.setPower(-lThrottle);
        motorBL.setPower(-lThrottle);

        telemetry.addData("Time",this.time);
        telemetry.addData("Right", rThrottle);
        telemetry.addData("Left", lThrottle);

    }
}