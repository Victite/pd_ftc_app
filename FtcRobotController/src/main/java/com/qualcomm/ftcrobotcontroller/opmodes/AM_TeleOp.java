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

public abstract class AM_TeleOp extends AM_AbstractOp {

    // Variables for TeleOp
    boolean rooted = false;

    abstract void swingers();

    @Override
    public void loop() {

        // Joystick variables to be updated constantly
        float rThrottle = gamepad1.right_stick_y;
        float lThrottle = gamepad1.left_stick_y;
        float adjustAngle = gamepad1.right_trigger - gamepad1.left_trigger;

        // Wheel motors assigned to the joystick variables of their respective side
        if (!rooted) {
            motorFR.setPower(rThrottle);
            motorBR.setPower(rThrottle);
            motorFL.setPower(lThrottle);
            motorBL.setPower(lThrottle);
        }

        // Tape Mech Motors
        if (gamepad1.right_bumper) {
            tape1.setPower(1.0);
            tape2.setPower(1.0);
            tape3.setPower(1.0);
            rooted = true;
        } else if (gamepad1.left_bumper) {
            tape1.setPower(-1.0);
            tape2.setPower(-1.0);
            tape3.setPower(-1.0);
        } else {
            tape1.setPower(0.0);
            tape2.setPower(0.0);
            tape3.setPower(0.0);
            rooted = false;
        }
        motorAngle.setPower(adjustAngle);

        if (gamepad1.y) {
            if (frontArm.getPosition() == 0.2)
                frontArm.setPosition(1.0);
            else
                frontArm.setPosition(0.2);
            while (gamepad1.y) {

            }
        }
        this.swingers();
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

}