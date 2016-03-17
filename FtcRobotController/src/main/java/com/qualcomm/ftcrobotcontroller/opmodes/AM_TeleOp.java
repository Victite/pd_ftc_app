/* Copyright (c) 2014 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package com.qualcomm.ftcrobotcontroller.opmodes;

public class AM_TeleOp extends AM_AbstractOp {

    /*
     * This method will be called repeatedly in a loop
     *
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#run()
     */
    @Override
    public void loop() {

        //Joystick variables to be updated constantly
        float rThrottle = gamepad1.right_stick_y;
        float lThrottle = gamepad1.left_stick_y;
        float adjustAngle = gamepad1.right_trigger - gamepad1.left_trigger;

        //Wheel motors assigned to the joystick variables of their respective side
        motorFR.setPower(rThrottle);
        motorBR.setPower(rThrottle);
        motorFL.setPower(lThrottle);
        motorBL.setPower(lThrottle);

        //
        if(gamepad1.right_bumper) {
            tape1.setPower(1.0);
            tape2.setPower(1.0);
            tape3.setPower(1.0);
        }
        else if(gamepad1.left_bumper) {
            tape1.setPower(-1.0);
            tape2.setPower(-1.0);
            tape3.setPower(-1.0);
        }
        else {
            tape1.setPower(0.0);
            tape2.setPower(0.0);
            tape3.setPower(0.0);
        }
        motorAngle.setPower(adjustAngle);

        if(gamepad1.y) {
            if(frontArm.getPosition() == 1.0)
                frontArm.setPosition(0.0);
            else
                frontArm.setPosition(1.0);
            while(gamepad1.y) {

            }
        }
        if(gamepad1.x) {
            if(leftArm.getPosition() == 1.0)
                leftArm.setPosition(0.0);
            else
                leftArm.setPosition(1.0);
            while(gamepad1.x) {

            }
        }
        if(gamepad1.b) {
            if(rightArm.getPosition() == 1.0)
                rightArm.setPosition(0.0);
            else
                rightArm.setPosition(1.0);
            while(gamepad1.b) {

            }
        }

        // update the position of the arm.



		/*
		 * Send telemetry data back to driver station. Note that if we are using
		 * a legacy NXT-compatible motor controller, then the getPower() method
		 * will return a null value. The legacy NXT-compatible motor controllers
		 * are currently write only.
		 */

    }

    /*
     * Code to run when the op mode is first disabled goes here
     *
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#stop()
     */
    @Override
    public void stop() {

    }


    /*
     * This method scales the joystick input so for low joystick values, the
     * scaled value is less than linear.  This is to make it easier to drive
     * the robot more precisely at slower speeds.
     */
    double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);

        // index should be positive.
        if (index < 0) {
            index = -index;
        }

        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }

        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        // return scaled value.
        return dScale;
    }

}
