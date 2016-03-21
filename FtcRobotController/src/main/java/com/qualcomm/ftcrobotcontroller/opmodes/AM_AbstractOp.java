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

	DcMotor motorFR;
	DcMotor motorBR;
	DcMotor motorFL;
	DcMotor motorBL;

	DcMotor tape1;
	DcMotor tape2;
	DcMotor tape3;
	DcMotor motorAngle;

	Servo frontArm;

	Servo leftArm;
	Servo rightArm;
	Servo depoArm;

	/**
	 * Constructor
	 */
	public AM_AbstractOp() {

	}

	@Override
	public void init() {

		motorFR = hardwareMap.dcMotor.get("motorFR");
		motorBR = hardwareMap.dcMotor.get("motorBR");
		motorFL = hardwareMap.dcMotor.get("motorFL");
		motorBL = hardwareMap.dcMotor.get("motorBL");

		motorFR.setDirection(DcMotor.Direction.REVERSE);
		motorBR.setDirection(DcMotor.Direction.REVERSE);

		tape1 = hardwareMap.dcMotor.get("tape1");
		tape2 = hardwareMap.dcMotor.get("tape2");
		tape3 = hardwareMap.dcMotor.get("tape3");
		motorAngle = hardwareMap.dcMotor.get("angle");

		frontArm = hardwareMap.servo.get("frontarm");
		frontArm.setPosition(0.1);

		leftArm = hardwareMap.servo.get("leftarm");
		rightArm = hardwareMap.servo.get("rightarm");
		leftArm.setPosition(0.1176);
		rightArm.setPosition(0.776);

		depoArm = hardwareMap.servo.get("depoarm");
		depoArm.setPosition(1.0);

	}

}
