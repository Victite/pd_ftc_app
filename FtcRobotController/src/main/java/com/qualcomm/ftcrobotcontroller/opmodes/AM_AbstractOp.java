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

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public abstract class AM_AbstractOp extends OpMode {
	/*
		This is an abstract class for all of our OpModes to extend off of.  It defines all of our motors and servos, as well as some sensors and variables used across all of our OpModes.
		By treating each of our OpModes as subclasses of this abstract class, we are able to change all of our
	 */

	//Wheel Motors
	DcMotor dc_FR;
	DcMotor dc_FL;
	DcMotor dc_BR;
	DcMotor dc_BL;

	//Tape Mechanism Motors
	DcMotor dc_tape1;
	DcMotor dc_tape2;
	DcMotor dc_tape3;
	DcMotor dc_angle;

	Servo sv_depositArm;
	Servo sv_climbingArm;

	public AM_AbstractOp() {
		dc_FR = hardwareMap.dcMotor.get("fr");
		dc_FL = hardwareMap.dcMotor.get("fl");
		dc_BR = hardwareMap.dcMotor.get("br");
		dc_BL = hardwareMap.dcMotor.get("bl");

		dc_FL.setDirection(DcMotor.Direction.REVERSE);
		dc_BL.setDirection(DcMotor.Direction.REVERSE);

		dc_tape1 = hardwareMap.dcMotor.get("tape1");
		dc_tape2 = hardwareMap.dcMotor.get("tape2");
		dc_tape3 = hardwareMap.dcMotor.get("tape3");
		dc_angle = hardwareMap.dcMotor.get("angle");

		sv_depositArm = hardwareMap.servo.get("depo arm");
		sv_climbingArm = hardwareMap.servo.get("climb arm");
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
