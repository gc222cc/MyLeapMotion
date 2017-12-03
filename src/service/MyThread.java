package service;
/* Bu threadde bir frame i\u015elenerek feature «?karmas? yap?l?r
 * ve feature array olu\u015eturulur. Feature array, letter tipi,
 * letter id ve giren ki\u015einin ismi kullan?larak entity.Letter
 * s?n?f?ndan bir obje burada ¸retilir
 */

import com.leapmotion.leap.Bone;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Finger.Type;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import entity.Letter;
import gui.FrameSaveData;
import util.CalculateAngle;

import java.util.ArrayList;

public class MyThread implements Runnable {

	private Frame frame;
	private Callback callback;

	public MyThread(Object frame, Callback callback) {
		this.frame = (Frame) frame;
		this.callback = callback;
		// store parameter for later user
		// TODO gˆksele sor
		// TODO entity.Letter id yi nas?l kullan?ca\u011e?z
		// TODO feature ekleme => metakarpal a«? eklenebilir.
	}

	public void run() {

		ArrayList<Double> featureArray = new ArrayList<>();

		double leftPalmX = 0, leftPalmY = 0, leftPalmZ = 0;
		double rightPalmX = 0, rightPalmY = 0, rightPalmZ = 0;

		double rightThumbTipPositionX = 0, rightThumbTipPositionY = 0, rightThumbTipPositionZ = 0;
		double rightThumbStartPointX = 0, rightThumbStartPointY = 0, rightThumbStartPointZ = 0;
		double rightThumbEndPointX = 0, rightThumbEndPointY = 0, rightThumbEndPointZ = 0;

		double leftThumbTipPositionX = 0, leftThumbTipPositionY = 0, leftThumbTipPositionZ = 0;
		double leftThumbStartPointX = 0, leftThumbStartPointY = 0, leftThumbStartPointZ = 0;
		double leftThumbEndPointX = 0, leftThumbEndPointY = 0, leftThumbEndPointZ = 0;

		double rightIndexTipPositionX = 0, rightIndexTipPositionY = 0, rightIndexTipPositionZ = 0;
		double rightIndexStartPointX = 0, rightIndexStartPointY = 0, rightIndexStartPointZ = 0;
		double rightIndexEndPointX = 0, rightIndexEndPointY = 0, rightIndexEndPointZ = 0;

		double leftIndexTipPositionX = 0, leftIndexTipPositionY = 0, leftIndexTipPositionZ = 0;
		double leftIndexStartPointX = 0, leftIndexStartPointY = 0, leftIndexStartPointZ = 0;
		double leftIndexEndPointX = 0, leftIndexEndPointY = 0, leftIndexEndPointZ = 0;

		double rightMiddleTipPositionX = 0, rightMiddleTipPositionY = 0, rightMiddleTipPositionZ = 0;
		double rightMiddleStartPointX = 0, rightMiddleStartPointY = 0, rightMiddleStartPointZ = 0;
		double rightMiddleEndPointX = 0, rightMiddleEndPointY = 0, rightMiddleEndPointZ = 0;

		double leftMiddleTipPositionX = 0, leftMiddleTipPositionY = 0, leftMiddleTipPositionZ = 0;
		double leftMiddleStartPointX = 0, leftMiddleStartPointY = 0, leftMiddleStartPointZ = 0;
		double leftMiddleEndPointX = 0, leftMiddleEndPointY = 0, leftMiddleEndPointZ = 0;

		double rightRingTipPositionX = 0, rightRingTipPositionY = 0, rightRingTipPositionZ = 0;
		double rightRingStartPointX = 0, rightRingStartPointY = 0, rightRingStartPointZ = 0;
		double rightRingEndPointX = 0, rightRingEndPointY = 0, rightRingEndPointZ = 0;

		double leftRingTipPositionX = 0, leftRingTipPositionY = 0, leftRingTipPositionZ = 0;
		double leftRingStartPointX = 0, leftRingStartPointY = 0, leftRingStartPointZ = 0;
		double leftRingEndPointX = 0, leftRingEndPointY = 0, leftRingEndPointZ = 0;

		double rightPinkyTipPositionX = 0, rightPinkyTipPositionY = 0, rightPinkyTipPositionZ = 0;
		double rightPinkyStartPointX = 0, rightPinkyStartPointY = 0, rightPinkyStartPointZ = 0;
		double rightPinkyEndPointX = 0, rightPinkyEndPointY = 0, rightPinkyEndPointZ = 0;

		double leftPinkyTipPositionX = 0, leftPinkyTipPositionY = 0, leftPinkyTipPositionZ = 0;
		double leftPinkyStartPointX = 0, leftPinkyStartPointY = 0, leftPinkyStartPointZ = 0;
		double leftPinkyEndPointX = 0, leftPinkyEndPointY = 0, leftPinkyEndPointZ = 0;

		double distanceLeftThumb = 0, distanceLeftIndex = 0, distanceLeftMiddle = 0, distanceLeftRing = 0,
				distanceLeftPinky = 0;
		double distanceRightThumb = 0, distanceRightIndex = 0, distanceRightMiddle = 0, distanceRightRing = 0,
				distanceRightPinky = 0;

		double multi_Left_Thumb_Index = 0, multi_Left_Thumb_Middle = 0, multi_Left_Thumb_Ring = 0,
				multi_Left_Thumb_Pinky = 0;
		double multi_Right_Thumb_Index = 0, multi_Right_Thumb_Middle = 0, multi_Right_Thumb_Ring = 0,
				multi_Right_Thumb_Pinky = 0;

		double multi_Left_Index_Middle = 0, multi_Left_Index_Ring = 0, multi_Left_Index_Pinky = 0;
		double multi_Right_Index_Middle = 0, multi_Right_Index_Ring = 0, multi_Right_Index_Pinky = 0;

		double multi_Left_Middle_Ring = 0, multi_Left_Middle_Pinky = 0;
		double multi_Right_Middle_Ring = 0, multi_Right_Middle_Pinky = 0;

		double multi_Left_Ring_Pinky = 0;
		double multi_Right_Ring_Pinky = 0;

		double distanceLeftThumbForAngle = 0, distanceLeftIndexForAngle = 0, distanceLeftMiddleForAngle = 0,
				distanceLeftRingForAngle = 0, distanceLeftPinkyForAngle = 0;
		double distanceRightThumbForAngle = 0, distanceRightIndexForAngle = 0, distanceRightMiddleForAngle = 0,
				distanceRightRingForAngle = 0, distanceRightPinkyForAngle = 0;

		double multi_Left_Thumb_Index_ForAngle = 0, multi_Left_Thumb_Middle_ForAngle = 0,
				multi_Left_Thumb_Ring_ForAngle = 0, multi_Left_Thumb_Pinky_ForAngle = 0;
		double multi_Right_Thumb_Index_ForAngle = 0, multi_Right_Thumb_Middle_ForAngle = 0,
				multi_Right_Thumb_Ring_ForAngle = 0, multi_Right_Thumb_Pinky_ForAngle = 0;

		double multi_Left_Index_Middle_ForAngle = 0, multi_Left_Index_Ring_ForAngle = 0,
				multi_Left_Index_Pinky_ForAngle = 0;
		double multi_Right_Index_Middle_ForAngle = 0, multi_Right_Index_Ring_ForAngle = 0,
				multi_Right_Index_Pinky_ForAngle = 0;

		double multi_Left_Middle_Ring_ForAngle = 0, multi_Left_Middle_Pinky_ForAngle = 0;
		double multi_Right_Middle_Ring_ForAngle = 0, multi_Right_Middle_Pinky_ForAngle = 0;

		double multi_Left_Ring_Pinky_ForAngle = 0;
		double multi_Right_Ring_Pinky_ForAngle = 0;

		double leftIndexCornerPointX = 0, leftIndexCornerPointY = 0, leftIndexCornerPointZ = 0;
		double leftMiddleCornerPointX = 0, leftMiddleCornerPointY = 0, leftMiddleCornerPointZ = 0;
		double leftRingCornerPointX = 0, leftRingCornerPointY = 0, leftRingCornerPointZ = 0;
		double leftPinkyCornerPointX = 0, leftPinkyCornerPointY = 0, leftPinkyCornerPointZ = 0;

		double rightIndexCornerPointX = 0, rightIndexCornerPointY = 0, rightIndexCornerPointZ = 0;
		double rightMiddleCornerPointX = 0, rightMiddleCornerPointY = 0, rightMiddleCornerPointZ = 0;
		double rightRingCornerPointX = 0, rightRingCornerPointY = 0, rightRingCornerPointZ = 0;
		double rightPinkyCornerPointX = 0, rightPinkyCornerPointY = 0, rightPinkyCornerPointZ = 0;

		double distanceLeftIndexCornerProx = 0, distanceLeftMiddleCornerProx = 0, distanceLeftRingCornerProx = 0,
				distanceLeftPinkyCornerProx = 0;
		double distanceLeftIndexCornerDistal = 0, distanceLeftMiddleCornerDistal = 0, distanceLeftRingCornerDistal = 0,
				distanceLeftPinkyCornerDistal = 0;

		double distanceRightIndexCornerProx = 0, distanceRightMiddleCornerProx = 0, distanceRightRingCornerProx = 0,
				distanceRightPinkyCornerProx = 0;
		double distanceRightIndexCornerDistal = 0, distanceRightMiddleCornerDistal = 0,
				distanceRightRingCornerDistal = 0, distanceRightPinkyCornerDistal = 0;

		double multiLeftIndexCorner = 0, multiLeftMiddleCorner = 0, multiLeftRingCorner = 0, multiLeftPinkyCorner = 0;

		double multiRightIndexCorner = 0, multiRightMiddleCorner = 0, multiRightRingCorner = 0,
				multiRightPinkyCorner = 0;

		double subPalmsX=0, subPalmsY=0, subPalmsZ=0;
		double angleBetweenPalms=0;
		double distancePalms=0;
		double multiPalmsAngleZ=0;
		double leftPalmNormalX=0,  leftPalmNormalY=0, leftPalmNormalZ=0;
		double rightPalmNormalX=0,   rightPalmNormalY=0,  rightPalmNormalZ=0;
		// float instantaneousFrameRate = frame.currentFramesPerSecond();

	

		/*
		 * System.out.println("Frame id:" + frame.id() + ", Timestamp: " +
		 * frame.timestamp() + ", Hands: " + frame.hands().count() +
		 * ", Fingers:" + frame.fingers().count());
		 */

		for (Hand hand : frame.hands()) {
			String handType = hand.isLeft() ? "Left Hand" : "Right Hand";

			// System.out.println(handType + " " + "id :" + hand.id() + ", Palm
			// Position: " + hand.palmPosition());

			if (hand.isLeft() == true) {
				leftPalmX = (double) hand.palmPosition().getX(); // KONTROL
																	// GEREK?YOR
				leftPalmY = (double) hand.palmPosition().getY();
				leftPalmZ = (double) hand.palmPosition().getZ();
				leftPalmNormalX =  (double)hand.palmNormal().getX();
				leftPalmNormalY =  (double)hand.palmNormal().getY();
				leftPalmNormalZ =  (double)hand.palmNormal().getZ();
				
				
				
			}

			if (hand.isRight() == true) {
				rightPalmX = (double) hand.palmPosition().getX();
				rightPalmY = (double) hand.palmPosition().getY();
				rightPalmZ = (double) hand.palmPosition().getZ();
				
				rightPalmNormalX =  (double)hand.palmNormal().getX();
				rightPalmNormalY =  (double)hand.palmNormal().getY();
				rightPalmNormalZ =  (double)hand.palmNormal().getZ();

			}

		}

		for (Finger finger : frame.fingers()) {
			/*
			 * System.out.println("Finger Type : " + finger.type() + "   ID " +
			 * finger.id() + "   Finger Length(mm) " + finger.length() +
			 * " Tip positon" + finger.tipPosition());
			 */

			for (Bone.Type boneType : Bone.Type.values()) {

				Bone bone = finger.bone(boneType);

				/*
				 * System.out.println("BoneType : " + bone.type() +
				 * "Start Bone :" + bone.prevJoint() + "End Bone : " +
				 * bone.nextJoint() + "Direction : " + bone.direction());
				 */

				if (finger.hand().isLeft()) {

					if (finger.type() == Type.TYPE_THUMB) {
						// finger.hand().isRight()

						leftThumbTipPositionX = (double) finger.tipPosition().getX();
						leftThumbTipPositionY = (double) finger.tipPosition().getY();
						leftThumbTipPositionZ = (double) finger.tipPosition().getZ();

						if (bone.type() == bone.type().TYPE_INTERMEDIATE) {
							leftThumbStartPointX = (double) bone.prevJoint().getX();
							leftThumbStartPointY = (double) bone.prevJoint().getY();
							leftThumbStartPointZ = (double) bone.prevJoint().getZ();
						}

						if (bone.type() == bone.type().TYPE_DISTAL) {
							leftThumbEndPointX = (double) bone.nextJoint().getX();
							leftThumbEndPointY = (double) bone.nextJoint().getY();
							leftThumbEndPointZ = (double) bone.nextJoint().getZ();
						}
					}

					if (finger.type() == Type.TYPE_INDEX) {
						leftIndexTipPositionX = (double) finger.tipPosition().getX();
						leftIndexTipPositionY = (double) finger.tipPosition().getY();
						leftIndexTipPositionZ = (double) finger.tipPosition().getZ();

						if (bone.type() == bone.type().TYPE_PROXIMAL) {
							leftIndexStartPointX = (double) bone.prevJoint().getX();
							leftIndexStartPointY = (double) bone.prevJoint().getY();
							leftIndexStartPointZ = (double) bone.prevJoint().getZ();

							leftIndexCornerPointX = (double) bone.nextJoint().getX();
							leftIndexCornerPointY = (double) bone.nextJoint().getY();
							leftIndexCornerPointZ = (double) bone.nextJoint().getZ();
						}

						if (bone.type() == bone.type().TYPE_DISTAL) {
							leftIndexEndPointX = (double) bone.nextJoint().getX();
							leftIndexEndPointY = (double) bone.nextJoint().getY();
							leftIndexEndPointZ = (double) bone.nextJoint().getZ();
						}
					}

					if (finger.type() == Type.TYPE_MIDDLE) {
						leftMiddleTipPositionX = (double) finger.tipPosition().getX();
						leftMiddleTipPositionY = (double) finger.tipPosition().getY();
						leftMiddleTipPositionZ = (double) finger.tipPosition().getZ();

						if (bone.type() == bone.type().TYPE_PROXIMAL) {
							leftMiddleStartPointX = (double) bone.prevJoint().getX();
							leftMiddleStartPointY = (double) bone.prevJoint().getY();
							leftMiddleStartPointZ = (double) bone.prevJoint().getZ();

							leftMiddleCornerPointX = (double) bone.nextJoint().getX();
							leftMiddleCornerPointY = (double) bone.nextJoint().getY();
							leftMiddleCornerPointZ = (double) bone.nextJoint().getZ();
						}

						if (bone.type() == bone.type().TYPE_DISTAL) {
							leftMiddleEndPointX = (double) bone.nextJoint().getX();
							leftMiddleEndPointY = (double) bone.nextJoint().getY();
							leftMiddleEndPointZ = (double) bone.nextJoint().getZ();
						}
					}

					if (finger.type() == Type.TYPE_RING) {
						leftRingTipPositionX = (double) finger.tipPosition().getX();
						leftRingTipPositionY = (double) finger.tipPosition().getY();
						leftRingTipPositionZ = (double) finger.tipPosition().getZ();

						if (bone.type() == bone.type().TYPE_PROXIMAL) {
							leftRingStartPointX = (double) bone.prevJoint().getX();
							leftRingStartPointY = (double) bone.prevJoint().getY();
							leftRingStartPointZ = (double) bone.prevJoint().getZ();

							leftRingCornerPointX = (double) bone.nextJoint().getX();
							leftRingCornerPointY = (double) bone.nextJoint().getY();
							leftRingCornerPointZ = (double) bone.nextJoint().getZ();
						}

						if (bone.type() == bone.type().TYPE_DISTAL) {
							leftRingEndPointX = (double) bone.nextJoint().getX();
							leftRingEndPointY = (double) bone.nextJoint().getY();
							leftRingEndPointZ = (double) bone.nextJoint().getZ();
						}
					}

					if (finger.type() == Type.TYPE_PINKY) {
						leftPinkyTipPositionX = (double) finger.tipPosition().getX();
						leftPinkyTipPositionY = (double) finger.tipPosition().getY();
						leftPinkyTipPositionZ = (double) finger.tipPosition().getZ();

						if (bone.type() == bone.type().TYPE_PROXIMAL) {
							leftPinkyStartPointX = (double) bone.prevJoint().getX();
							leftPinkyStartPointY = (double) bone.prevJoint().getY();
							leftPinkyStartPointZ = (double) bone.prevJoint().getZ();

							leftPinkyCornerPointX = (double) bone.nextJoint().getX();
							leftPinkyCornerPointY = (double) bone.nextJoint().getY();
							leftPinkyCornerPointZ = (double) bone.nextJoint().getZ();
						}

						if (bone.type() == bone.type().TYPE_DISTAL) {
							leftPinkyEndPointX = (double) bone.nextJoint().getX();
							leftPinkyEndPointY = (double) bone.nextJoint().getY();
							leftPinkyEndPointZ = (double) bone.nextJoint().getZ();

						}
					}

				} // left hand end

				if (finger.hand().isRight()) {

					if (finger.type() == Type.TYPE_THUMB) {
						// finger.hand().isRight()

						rightThumbTipPositionX = (double) finger.tipPosition().getX();
						rightThumbTipPositionY = (double) finger.tipPosition().getY();
						rightThumbTipPositionZ = (double) finger.tipPosition().getZ();

						if (bone.type() == bone.type().TYPE_INTERMEDIATE) {
							rightThumbStartPointX = (double) bone.prevJoint().getX();
							rightThumbStartPointY = (double) bone.prevJoint().getY();
							rightThumbStartPointZ = (double) bone.prevJoint().getZ();
						}

						if (bone.type() == bone.type().TYPE_DISTAL) {
							rightThumbEndPointX = (double) bone.nextJoint().getX();
							rightThumbEndPointY = (double) bone.nextJoint().getY();
							rightThumbEndPointZ = (double) bone.nextJoint().getZ();
						}
					}

					if (finger.type() == Type.TYPE_INDEX) {
						rightIndexTipPositionX = (double) finger.tipPosition().getX();
						rightIndexTipPositionY = (double) finger.tipPosition().getY();
						rightIndexTipPositionZ = (double) finger.tipPosition().getZ();

						if (bone.type() == bone.type().TYPE_PROXIMAL) {
							rightIndexStartPointX = (double) bone.prevJoint().getX();
							rightIndexStartPointY = (double) bone.prevJoint().getY();
							rightIndexStartPointZ = (double) bone.prevJoint().getZ();

							rightIndexCornerPointX = (double) bone.nextJoint().getX();
							rightIndexCornerPointY = (double) bone.nextJoint().getY();
							rightIndexCornerPointZ = (double) bone.nextJoint().getZ();
						}

						if (bone.type() == bone.type().TYPE_DISTAL) {
							rightIndexEndPointX = (double) bone.nextJoint().getX();
							rightIndexEndPointY = (double) bone.nextJoint().getY();
							rightIndexEndPointZ = (double) bone.nextJoint().getZ();
						}
					}

					if (finger.type() == Type.TYPE_MIDDLE) {
						rightMiddleTipPositionX = (double) finger.tipPosition().getX();
						rightMiddleTipPositionY = (double) finger.tipPosition().getY();
						rightMiddleTipPositionZ = (double) finger.tipPosition().getZ();

						if (bone.type() == bone.type().TYPE_PROXIMAL) {
							rightMiddleStartPointX = (double) bone.prevJoint().getX();
							rightMiddleStartPointY = (double) bone.prevJoint().getY();
							rightMiddleStartPointZ = (double) bone.prevJoint().getZ();

							rightMiddleCornerPointX = (double) bone.nextJoint().getX();
							rightMiddleCornerPointY = (double) bone.nextJoint().getY();
							rightMiddleCornerPointZ = (double) bone.nextJoint().getZ();
						}

						if (bone.type() == bone.type().TYPE_DISTAL) {
							rightMiddleEndPointX = (double) bone.nextJoint().getX();
							rightMiddleEndPointY = (double) bone.nextJoint().getY();
							rightMiddleEndPointZ = (double) bone.nextJoint().getZ();
						}
					}

					if (finger.type() == Type.TYPE_RING) {
						rightRingTipPositionX = (double) finger.tipPosition().getX();
						rightRingTipPositionY = (double) finger.tipPosition().getY();
						rightRingTipPositionZ = (double) finger.tipPosition().getZ();

						if (bone.type() == bone.type().TYPE_PROXIMAL) {
							rightRingStartPointX = (double) bone.prevJoint().getX();
							rightRingStartPointY = (double) bone.prevJoint().getY();
							rightRingStartPointZ = (double) bone.prevJoint().getZ();

							rightRingCornerPointX = (double) bone.nextJoint().getX();
							rightRingCornerPointY = (double) bone.nextJoint().getY();
							rightRingCornerPointZ = (double) bone.nextJoint().getZ();
						}

						if (bone.type() == bone.type().TYPE_DISTAL) {
							rightRingEndPointX = (double) bone.nextJoint().getX();
							rightRingEndPointY = (double) bone.nextJoint().getY();
							rightRingEndPointZ = (double) bone.nextJoint().getZ();
						}
					}

					if (finger.type() == Type.TYPE_PINKY) {
						rightPinkyTipPositionX = (double) finger.tipPosition().getX();
						rightPinkyTipPositionY = (double) finger.tipPosition().getY();
						rightPinkyTipPositionZ = (double) finger.tipPosition().getZ();

						if (bone.type() == bone.type().TYPE_PROXIMAL) {
							rightPinkyStartPointX = (double) bone.prevJoint().getX();
							rightPinkyStartPointY = (double) bone.prevJoint().getY();
							rightPinkyStartPointZ = (double) bone.prevJoint().getZ();

							rightPinkyCornerPointX = (double) bone.nextJoint().getX();
							rightPinkyCornerPointY = (double) bone.nextJoint().getY();
							rightPinkyCornerPointZ = (double) bone.nextJoint().getZ();
						}

						if (bone.type() == bone.type().TYPE_DISTAL) {
							rightPinkyEndPointX = (double) bone.nextJoint().getX();
							rightPinkyEndPointY = (double) bone.nextJoint().getY();
							rightPinkyEndPointZ = (double) bone.nextJoint().getZ();

						}
					}

				} // right hand end

			} // 1.FOR

		} // 2.FOR

		// Palm Hesaplama finger position

		distanceLeftThumb = CalculateAngle.distance(leftThumbTipPositionX, leftPalmX, leftThumbTipPositionY, leftPalmY,
				leftThumbTipPositionZ, leftPalmZ);
		distanceLeftIndex = CalculateAngle.distance(leftIndexTipPositionX, leftPalmX, leftIndexTipPositionY, leftPalmY,
				leftIndexTipPositionZ, leftPalmZ);
		distanceLeftMiddle = CalculateAngle.distance(leftMiddleTipPositionX, leftPalmX, leftMiddleTipPositionY,
				leftPalmY, leftMiddleTipPositionZ, leftPalmZ);
		distanceLeftRing = CalculateAngle.distance(leftRingTipPositionX, leftPalmX, leftRingTipPositionY, leftPalmY,
				leftRingTipPositionZ, leftPalmZ);
		distanceLeftPinky = CalculateAngle.distance(leftPinkyTipPositionX, leftPalmX, leftPinkyTipPositionY, leftPalmY,
				leftPinkyTipPositionZ, leftPalmZ);

		distanceRightThumb = CalculateAngle.distance(rightThumbTipPositionX, rightPalmX, rightThumbTipPositionY,
				rightPalmY, rightThumbTipPositionZ, rightPalmZ);
		distanceRightIndex = CalculateAngle.distance(rightIndexTipPositionX, rightPalmX, rightIndexTipPositionY,
				rightPalmY, rightIndexTipPositionZ, rightPalmZ);
		distanceRightMiddle = CalculateAngle.distance(rightMiddleTipPositionX, rightPalmX, rightMiddleTipPositionY,
				rightPalmY, rightMiddleTipPositionZ, rightPalmZ);
		distanceRightRing = CalculateAngle.distance(rightRingTipPositionX, rightPalmX, rightRingTipPositionY,
				rightPalmY, rightRingTipPositionZ, rightPalmZ);
		distanceRightPinky = CalculateAngle.distance(rightPinkyTipPositionX, rightPalmX, rightPinkyTipPositionY,
				rightPalmY, rightPinkyTipPositionZ, rightPalmZ);

		multi_Left_Thumb_Index = CalculateAngle.multi(leftThumbTipPositionX, leftPalmX, leftIndexTipPositionX,
				leftThumbTipPositionY, leftPalmY, leftIndexTipPositionY, leftThumbTipPositionZ, leftPalmZ,
				leftIndexTipPositionZ);
		multi_Left_Thumb_Middle = CalculateAngle.multi(leftThumbTipPositionX, leftPalmX, leftMiddleTipPositionX,
				leftThumbTipPositionY, leftPalmY, leftMiddleTipPositionY, leftThumbTipPositionZ, leftPalmZ,
				leftMiddleTipPositionZ);
		multi_Left_Thumb_Ring = CalculateAngle.multi(leftThumbTipPositionX, leftPalmX, leftRingTipPositionX,
				leftThumbTipPositionY, leftPalmY, leftRingTipPositionY, leftThumbTipPositionZ, leftPalmZ,
				leftRingTipPositionZ);
		multi_Left_Thumb_Pinky = CalculateAngle.multi(leftThumbTipPositionX, leftPalmX, leftPinkyTipPositionX,
				leftThumbTipPositionY, leftPalmY, leftPinkyTipPositionY, leftThumbTipPositionZ, leftPalmZ,
				leftPinkyTipPositionZ);

		multi_Left_Index_Middle = CalculateAngle.multi(leftIndexTipPositionX, leftPalmX, leftMiddleTipPositionX,
				leftIndexTipPositionY, leftPalmY, leftMiddleTipPositionY, leftIndexTipPositionZ, leftPalmZ,
				leftMiddleTipPositionZ);
		multi_Left_Index_Ring = CalculateAngle.multi(leftIndexTipPositionX, leftPalmX, leftRingTipPositionX,
				leftIndexTipPositionY, leftPalmY, leftRingTipPositionY, leftIndexTipPositionZ, leftPalmZ,
				leftRingTipPositionZ);
		multi_Left_Index_Pinky = CalculateAngle.multi(leftIndexTipPositionX, leftPalmX, leftPinkyTipPositionX,
				leftIndexTipPositionY, leftPalmY, leftPinkyTipPositionY, leftIndexTipPositionZ, leftPalmZ,
				leftPinkyTipPositionZ);

		multi_Left_Middle_Ring = CalculateAngle.multi(leftMiddleTipPositionX, leftPalmX, leftRingTipPositionX,
				leftMiddleTipPositionY, leftPalmY, leftRingTipPositionY, leftMiddleTipPositionZ, leftPalmZ,
				leftRingTipPositionZ);
		multi_Left_Middle_Pinky = CalculateAngle.multi(leftMiddleTipPositionX, leftPalmX, leftPinkyTipPositionX,
				leftMiddleTipPositionY, leftPalmY, leftPinkyTipPositionY, leftMiddleTipPositionZ, leftPalmZ,
				leftPinkyTipPositionZ);

		multi_Left_Ring_Pinky = CalculateAngle.multi(leftRingTipPositionX, leftPalmX, leftPinkyTipPositionX,
				leftRingTipPositionY, leftPalmY, leftPinkyTipPositionY, leftRingTipPositionZ, leftPalmZ,
				leftPinkyTipPositionZ);

		multi_Right_Thumb_Index = CalculateAngle.multi(rightThumbTipPositionX, rightPalmX, rightIndexTipPositionX,
				rightThumbTipPositionY, rightPalmY, rightIndexTipPositionY, rightThumbTipPositionZ, rightPalmZ,
				rightIndexTipPositionZ);
		multi_Right_Thumb_Middle = CalculateAngle.multi(rightThumbTipPositionX, rightPalmX, rightMiddleTipPositionX,
				rightThumbTipPositionY, rightPalmY, rightMiddleTipPositionY, rightThumbTipPositionZ, rightPalmZ,
				rightMiddleTipPositionZ);
		multi_Right_Thumb_Ring = CalculateAngle.multi(rightThumbTipPositionX, rightPalmX, rightRingTipPositionX,
				rightThumbTipPositionY, rightPalmY, rightRingTipPositionY, rightThumbTipPositionZ, rightPalmZ,
				rightRingTipPositionZ);
		multi_Right_Thumb_Pinky = CalculateAngle.multi(rightThumbTipPositionX, rightPalmX, rightPinkyTipPositionX,
				rightThumbTipPositionY, rightPalmY, rightPinkyTipPositionY, rightThumbTipPositionZ, rightPalmZ,
				rightPinkyTipPositionZ);

		multi_Right_Index_Middle = CalculateAngle.multi(rightIndexTipPositionX, rightPalmX, rightMiddleTipPositionX,
				rightIndexTipPositionY, rightPalmY, rightMiddleTipPositionY, rightIndexTipPositionZ, rightPalmZ,
				rightMiddleTipPositionZ);
		multi_Right_Index_Ring = CalculateAngle.multi(rightIndexTipPositionX, rightPalmX, rightRingTipPositionX,
				rightIndexTipPositionY, rightPalmY, rightRingTipPositionY, rightIndexTipPositionZ, rightPalmZ,
				rightRingTipPositionZ);
		multi_Right_Index_Pinky = CalculateAngle.multi(rightIndexTipPositionX, rightPalmX, rightPinkyTipPositionX,
				rightIndexTipPositionY, rightPalmY, rightPinkyTipPositionY, rightIndexTipPositionZ, rightPalmZ,
				rightPinkyTipPositionZ);

		multi_Right_Middle_Ring = CalculateAngle.multi(rightMiddleTipPositionX, rightPalmX, rightRingTipPositionX,
				rightMiddleTipPositionY, rightPalmY, rightRingTipPositionY, rightMiddleTipPositionZ, rightPalmZ,
				rightRingTipPositionZ);
		multi_Right_Middle_Pinky = CalculateAngle.multi(rightMiddleTipPositionX, rightPalmX, rightPinkyTipPositionX,
				rightMiddleTipPositionY, rightPalmY, rightPinkyTipPositionY, rightMiddleTipPositionZ, rightPalmZ,
				rightPinkyTipPositionZ);

		multi_Right_Ring_Pinky = CalculateAngle.multi(rightRingTipPositionX, rightPalmX, rightPinkyTipPositionX,
				rightRingTipPositionY, rightPalmY, rightPinkyTipPositionY, rightRingTipPositionZ, rightPalmZ,
				rightPinkyTipPositionZ);

		// Feature array ilk 10 eleman sol el 10 tane palm a«?s?
		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Thumb_Index, distanceLeftThumb, distanceLeftIndex));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Thumb_Middle, distanceLeftThumb, distanceLeftMiddle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Thumb_Ring, distanceLeftThumb, distanceLeftRing));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Thumb_Pinky, distanceLeftThumb, distanceLeftPinky));

		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Index_Middle, distanceLeftIndex, distanceLeftMiddle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Index_Ring, distanceLeftIndex, distanceLeftRing));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Index_Pinky, distanceLeftIndex, distanceLeftPinky));

		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Middle_Ring, distanceLeftMiddle, distanceLeftRing));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Middle_Pinky, distanceLeftMiddle, distanceLeftPinky));

		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Ring_Pinky, distanceLeftRing, distanceLeftPinky));

		// Feature array ikinci 10 eleman sa\u011e el 10 tane palm a«?s?
		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Thumb_Index, distanceRightThumb, distanceRightIndex));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Thumb_Middle, distanceRightThumb, distanceRightMiddle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Thumb_Ring, distanceRightThumb, distanceRightRing));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Thumb_Pinky, distanceRightThumb, distanceRightPinky));

		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Index_Middle, distanceRightIndex, distanceRightMiddle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Index_Ring, distanceRightIndex, distanceRightRing));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Index_Pinky, distanceRightIndex, distanceRightPinky));

		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Middle_Ring, distanceRightMiddle, distanceRightRing));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Middle_Pinky, distanceRightMiddle, distanceRightPinky));

		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Ring_Pinky, distanceRightRing, distanceRightPinky));

		

		// parmaklar aras? a«?lar? hesaplama

		distanceLeftThumbForAngle = CalculateAngle.distance(leftThumbEndPointX, leftThumbStartPointX,
				leftThumbEndPointY, leftThumbStartPointY, leftThumbEndPointZ, leftThumbStartPointZ);
		distanceLeftIndexForAngle = CalculateAngle.distance(leftIndexEndPointX, leftIndexStartPointX,
				leftIndexEndPointY, leftIndexStartPointY, leftIndexEndPointZ, leftIndexStartPointZ);
		distanceLeftMiddleForAngle = CalculateAngle.distance(leftMiddleEndPointX, leftMiddleStartPointX,
				leftMiddleEndPointY, leftMiddleStartPointY, leftMiddleEndPointZ, leftMiddleStartPointZ);
		distanceLeftRingForAngle = CalculateAngle.distance(leftRingEndPointX, leftRingStartPointX, leftRingEndPointY,
				leftRingStartPointY, leftRingEndPointZ, leftRingStartPointZ);
		distanceLeftPinkyForAngle = CalculateAngle.distance(leftPinkyEndPointX, leftPinkyStartPointX,
				leftPinkyEndPointY, leftPinkyStartPointY, leftPinkyEndPointZ, leftPinkyStartPointZ);

		distanceRightThumbForAngle = CalculateAngle.distance(rightThumbEndPointX, rightThumbStartPointX,
				rightThumbEndPointY, rightThumbStartPointY, rightThumbEndPointZ, rightThumbStartPointZ);
		distanceRightIndexForAngle = CalculateAngle.distance(rightIndexEndPointX, rightIndexStartPointX,
				rightIndexEndPointY, rightIndexStartPointY, rightIndexEndPointZ, rightIndexStartPointZ);
		distanceRightMiddleForAngle = CalculateAngle.distance(rightMiddleEndPointX, rightMiddleStartPointX,
				rightMiddleEndPointY, rightMiddleStartPointY, rightMiddleEndPointZ, rightMiddleStartPointZ);
		distanceRightRingForAngle = CalculateAngle.distance(rightRingEndPointX, rightRingStartPointX,
				rightRingEndPointY, rightRingStartPointY, rightRingEndPointZ, rightRingStartPointZ);
		distanceRightPinkyForAngle = CalculateAngle.distance(rightPinkyEndPointX, rightPinkyStartPointX,
				rightPinkyEndPointY, rightPinkyStartPointY, rightPinkyEndPointZ, rightPinkyStartPointZ);

		multi_Left_Thumb_Index_ForAngle = CalculateAngle.multi(leftThumbEndPointX, leftThumbStartPointX,
				leftIndexEndPointX, leftThumbEndPointY, leftThumbStartPointY, leftIndexEndPointY, leftThumbEndPointZ,
				leftThumbStartPointZ, leftIndexEndPointZ);
		multi_Left_Thumb_Middle_ForAngle = CalculateAngle.multi(leftThumbEndPointX, leftThumbStartPointX,
				leftMiddleEndPointX, leftThumbEndPointY, leftThumbStartPointY, leftMiddleEndPointY, leftThumbEndPointZ,
				leftThumbStartPointZ, leftMiddleEndPointZ);
		multi_Left_Thumb_Ring_ForAngle = CalculateAngle.multi(leftThumbEndPointX, leftThumbStartPointX,
				leftRingEndPointX, leftThumbEndPointY, leftThumbStartPointY, leftRingEndPointY, leftThumbEndPointZ,
				leftThumbStartPointZ, leftRingEndPointZ);
		multi_Left_Thumb_Pinky_ForAngle = CalculateAngle.multi(leftThumbEndPointX, leftThumbStartPointX,
				leftPinkyEndPointX, leftThumbEndPointY, leftThumbStartPointY, leftPinkyEndPointY, leftThumbEndPointZ,
				leftThumbStartPointZ, leftPinkyEndPointZ);

		multi_Left_Index_Middle_ForAngle = CalculateAngle.multi(leftIndexEndPointX, leftIndexStartPointX,
				leftMiddleEndPointX, leftIndexEndPointY, leftIndexStartPointY, leftMiddleEndPointY, leftIndexEndPointZ,
				leftIndexStartPointZ, leftMiddleEndPointZ);
		multi_Left_Index_Ring_ForAngle = CalculateAngle.multi(leftIndexEndPointX, leftIndexStartPointX,
				leftRingEndPointX, leftIndexEndPointY, leftIndexStartPointY, leftRingEndPointY, leftIndexEndPointZ,
				leftIndexStartPointZ, leftRingEndPointZ);
		multi_Left_Index_Pinky_ForAngle = CalculateAngle.multi(leftIndexEndPointX, leftIndexStartPointX,
				leftPinkyEndPointX, leftIndexEndPointY, leftIndexStartPointY, leftPinkyEndPointY, leftIndexEndPointZ,
				leftIndexStartPointZ, leftPinkyEndPointZ);

		multi_Left_Middle_Ring_ForAngle = CalculateAngle.multi(leftMiddleEndPointX, leftMiddleStartPointX,
				leftRingEndPointX, leftMiddleEndPointY, leftMiddleStartPointY, leftRingEndPointY, leftMiddleEndPointZ,
				leftMiddleStartPointZ, leftRingEndPointZ);
		multi_Left_Middle_Pinky_ForAngle = CalculateAngle.multi(leftMiddleEndPointX, leftMiddleStartPointX,
				leftPinkyEndPointX, leftMiddleEndPointY, leftMiddleStartPointY, leftPinkyEndPointY, leftMiddleEndPointZ,
				leftMiddleStartPointZ, leftPinkyEndPointZ);

		multi_Left_Ring_Pinky_ForAngle = CalculateAngle.multi(leftRingEndPointX, leftRingStartPointX,
				leftPinkyEndPointX, leftRingEndPointY, leftRingStartPointY, leftPinkyEndPointY, leftRingEndPointZ,
				leftRingStartPointZ, leftPinkyEndPointZ);

		multi_Right_Thumb_Index_ForAngle = CalculateAngle.multi(rightThumbEndPointX, rightThumbStartPointX,
				rightIndexEndPointX, rightThumbEndPointY, rightThumbStartPointY, rightIndexEndPointY,
				rightThumbEndPointZ, rightThumbStartPointZ, rightIndexEndPointZ);
		multi_Right_Thumb_Middle_ForAngle = CalculateAngle.multi(rightThumbEndPointX, rightThumbStartPointX,
				rightMiddleEndPointX, rightThumbEndPointY, rightThumbStartPointY, rightMiddleEndPointY,
				rightThumbEndPointZ, rightThumbStartPointZ, rightMiddleEndPointZ);
		multi_Right_Thumb_Ring_ForAngle = CalculateAngle.multi(rightThumbEndPointX, rightThumbStartPointX,
				rightRingEndPointX, rightThumbEndPointY, rightThumbStartPointY, rightRingEndPointY, rightThumbEndPointZ,
				rightThumbStartPointZ, rightRingEndPointZ);
		multi_Right_Thumb_Pinky_ForAngle = CalculateAngle.multi(rightThumbEndPointX, rightThumbStartPointX,
				rightPinkyEndPointX, rightThumbEndPointY, rightThumbStartPointY, rightPinkyEndPointY,
				rightThumbEndPointZ, rightThumbStartPointZ, rightPinkyEndPointZ);

		multi_Right_Index_Middle_ForAngle = CalculateAngle.multi(rightIndexEndPointX, rightIndexStartPointX,
				rightMiddleEndPointX, rightIndexEndPointY, rightIndexStartPointY, rightMiddleEndPointY,
				rightIndexEndPointZ, rightIndexStartPointZ, rightMiddleEndPointZ);
		multi_Right_Index_Ring_ForAngle = CalculateAngle.multi(rightIndexEndPointX, rightIndexStartPointX,
				rightRingEndPointX, rightIndexEndPointY, rightIndexStartPointY, rightRingEndPointY, rightIndexEndPointZ,
				rightIndexStartPointZ, rightRingEndPointZ);
		multi_Right_Index_Pinky_ForAngle = CalculateAngle.multi(rightIndexEndPointX, rightIndexStartPointX,
				rightPinkyEndPointX, rightIndexEndPointY, rightIndexStartPointY, rightPinkyEndPointY,
				rightIndexEndPointZ, rightIndexStartPointZ, rightPinkyEndPointZ);

		multi_Right_Middle_Ring_ForAngle = CalculateAngle.multi(rightMiddleEndPointX, rightMiddleStartPointX,
				rightRingEndPointX, rightMiddleEndPointY, rightMiddleStartPointY, rightRingEndPointY,
				rightMiddleEndPointZ, rightMiddleStartPointZ, rightRingEndPointZ);
		multi_Right_Middle_Pinky_ForAngle = CalculateAngle.multi(rightMiddleEndPointX, rightMiddleStartPointX,
				rightPinkyEndPointX, rightMiddleEndPointY, rightMiddleStartPointY, rightPinkyEndPointY,
				rightMiddleEndPointZ, rightMiddleStartPointZ, rightPinkyEndPointZ);

		multi_Right_Ring_Pinky_ForAngle = CalculateAngle.multi(rightRingEndPointX, rightRingStartPointX,
				rightPinkyEndPointX, rightRingEndPointY, rightRingStartPointY, rightPinkyEndPointY, rightRingEndPointZ,
				rightRingStartPointZ, rightPinkyEndPointZ);

		// Feature array ¸«¸nc¸ 10 eleman sol el 10 tane parmak a«?s?
		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Thumb_Index_ForAngle, distanceLeftThumbForAngle,
				distanceLeftIndexForAngle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Thumb_Middle_ForAngle, distanceLeftThumbForAngle,
				distanceLeftMiddleForAngle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Thumb_Ring_ForAngle, distanceLeftThumbForAngle,
				distanceLeftRingForAngle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Thumb_Pinky_ForAngle, distanceLeftThumbForAngle,
				distanceLeftPinkyForAngle));

		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Index_Middle_ForAngle, distanceLeftIndexForAngle,
				distanceLeftMiddleForAngle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Index_Ring_ForAngle, distanceLeftIndexForAngle,
				distanceLeftRingForAngle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Index_Pinky_ForAngle, distanceLeftIndexForAngle,
				distanceLeftPinkyForAngle));

		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Middle_Ring_ForAngle, distanceLeftMiddleForAngle,
				distanceLeftRingForAngle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Middle_Pinky_ForAngle, distanceLeftMiddleForAngle,
				distanceLeftPinkyForAngle));

		featureArray.add(CalculateAngle.arcCosTeta(multi_Left_Ring_Pinky_ForAngle, distanceLeftRingForAngle,
				distanceLeftPinkyForAngle));

		// Feature array dˆrd¸nc¸ 10 eleman sa\u011e el 10 tane parmak a«?s?
		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Thumb_Index_ForAngle, distanceRightThumbForAngle,
				distanceRightIndexForAngle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Thumb_Middle_ForAngle, distanceRightThumbForAngle,
				distanceRightMiddleForAngle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Thumb_Ring_ForAngle, distanceRightThumbForAngle,
				distanceRightRingForAngle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Thumb_Pinky_ForAngle, distanceRightThumbForAngle,
				distanceRightPinkyForAngle));

		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Index_Middle_ForAngle, distanceRightIndexForAngle,
				distanceRightMiddleForAngle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Index_Ring_ForAngle, distanceRightIndexForAngle,
				distanceRightRingForAngle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Index_Pinky_ForAngle, distanceRightIndexForAngle,
				distanceRightPinkyForAngle));

		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Middle_Ring_ForAngle, distanceRightMiddleForAngle,
				distanceRightRingForAngle));
		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Middle_Pinky_ForAngle, distanceRightMiddleForAngle,
				distanceRightPinkyForAngle));

		featureArray.add(CalculateAngle.arcCosTeta(multi_Right_Ring_Pinky_ForAngle, distanceRightRingForAngle,
				distanceRightPinkyForAngle));

		// parmaklar?n birbirlerine uzakl?klar?

		// Feature array be\u015einci 10 eleman sol el 10 tane parmak uzakl?\u011e?

		featureArray.add(CalculateAngle.distance(leftThumbEndPointX, leftIndexEndPointX, leftThumbEndPointY,
				leftIndexEndPointY, leftThumbEndPointZ, leftIndexEndPointZ));
		featureArray.add(CalculateAngle.distance(leftThumbEndPointX, leftMiddleEndPointX, leftThumbEndPointY,
				leftMiddleEndPointY, leftThumbEndPointZ, leftMiddleEndPointZ));
		featureArray.add(CalculateAngle.distance(leftThumbEndPointX, leftRingEndPointX, leftThumbEndPointY,
				leftRingEndPointY, leftThumbEndPointZ, leftRingEndPointZ));
		featureArray.add(CalculateAngle.distance(leftThumbEndPointX, leftPinkyEndPointX, leftThumbEndPointY,
				leftPinkyEndPointY, leftThumbEndPointZ, leftPinkyEndPointZ));

		featureArray.add(CalculateAngle.distance(leftIndexEndPointX, leftMiddleEndPointX, leftIndexEndPointY,
				leftMiddleEndPointY, leftIndexEndPointZ, leftMiddleEndPointZ));
		featureArray.add(CalculateAngle.distance(leftIndexEndPointX, leftRingEndPointX, leftIndexEndPointY,
				leftRingEndPointY, leftIndexEndPointZ, leftRingEndPointZ));
		featureArray.add(CalculateAngle.distance(leftIndexEndPointX, leftPinkyEndPointZ, leftIndexEndPointY,
				leftPinkyEndPointY, leftIndexEndPointZ, leftPinkyEndPointZ));

		featureArray.add(CalculateAngle.distance(leftMiddleEndPointX, leftRingEndPointX, leftMiddleEndPointY,
				leftRingEndPointY, leftMiddleEndPointZ, leftRingEndPointZ));
		featureArray.add(CalculateAngle.distance(leftMiddleEndPointX, leftPinkyEndPointX, leftMiddleEndPointY,
				leftPinkyEndPointY, leftMiddleEndPointZ, leftPinkyEndPointZ));

		featureArray.add(CalculateAngle.distance(leftRingEndPointX, leftPinkyEndPointX, leftRingEndPointY,
				leftPinkyEndPointY, leftRingEndPointZ, leftPinkyEndPointZ));

		// Feature array alt?nc? 10 eleman sa\u011e el 10 tane parmak uzakl?\u011e?

		featureArray.add(CalculateAngle.distance(rightThumbEndPointX, rightIndexEndPointX, rightThumbEndPointY,
				rightIndexEndPointY, rightThumbEndPointZ, rightIndexEndPointZ));
		featureArray.add(CalculateAngle.distance(rightThumbEndPointX, rightMiddleEndPointX, rightThumbEndPointY,
				rightMiddleEndPointY, rightThumbEndPointZ, rightMiddleEndPointZ));
		featureArray.add(CalculateAngle.distance(rightThumbEndPointX, rightRingEndPointX, rightThumbEndPointY,
				rightRingEndPointY, rightThumbEndPointZ, rightRingEndPointZ));
		featureArray.add(CalculateAngle.distance(rightThumbEndPointX, rightPinkyEndPointX, rightThumbEndPointY,
				rightPinkyEndPointY, rightThumbEndPointZ, rightPinkyEndPointZ));

		featureArray.add(CalculateAngle.distance(rightIndexEndPointX, rightMiddleEndPointX, rightIndexEndPointY,
				rightMiddleEndPointY, rightIndexEndPointZ, rightMiddleEndPointZ));
		featureArray.add(CalculateAngle.distance(rightIndexEndPointX, rightRingEndPointX, rightIndexEndPointY,
				rightRingEndPointY, rightIndexEndPointZ, rightRingEndPointZ));
		featureArray.add(CalculateAngle.distance(rightIndexEndPointX, rightPinkyEndPointZ, rightIndexEndPointY,
				rightPinkyEndPointY, rightIndexEndPointZ, rightPinkyEndPointZ));

		featureArray.add(CalculateAngle.distance(rightMiddleEndPointX, rightRingEndPointX, rightMiddleEndPointY,
				rightRingEndPointY, rightMiddleEndPointZ, rightRingEndPointZ));
		featureArray.add(CalculateAngle.distance(rightMiddleEndPointX, rightPinkyEndPointX, rightMiddleEndPointY,
				rightPinkyEndPointY, rightMiddleEndPointZ, rightPinkyEndPointZ));

		featureArray.add(CalculateAngle.distance(rightRingEndPointX, rightPinkyEndPointX, rightRingEndPointY,
				rightPinkyEndPointY, rightRingEndPointZ, rightPinkyEndPointZ));

		// Corner Result

		distanceLeftIndexCornerProx = (CalculateAngle.distance(leftIndexStartPointX, leftIndexCornerPointX,
				leftIndexStartPointY, leftIndexCornerPointY, leftIndexStartPointZ, leftIndexCornerPointZ));
		distanceLeftMiddleCornerProx = (CalculateAngle.distance(leftMiddleStartPointX, leftMiddleCornerPointX,
				leftMiddleStartPointY, leftMiddleCornerPointY, leftMiddleStartPointZ, leftMiddleCornerPointZ));
		distanceLeftRingCornerProx = (CalculateAngle.distance(leftRingStartPointX, leftRingCornerPointX,
				leftRingStartPointY, leftRingCornerPointY, leftRingStartPointZ, leftRingCornerPointZ));
		distanceLeftPinkyCornerProx = (CalculateAngle.distance(leftPinkyStartPointX, leftPinkyCornerPointX,
				leftPinkyStartPointY, leftPinkyCornerPointY, leftPinkyStartPointZ, leftPinkyCornerPointZ));

		distanceLeftIndexCornerDistal = (CalculateAngle.distance(leftIndexEndPointX, leftIndexCornerPointX,
				leftIndexEndPointY, leftIndexCornerPointY, leftIndexEndPointZ, leftIndexCornerPointZ));
		distanceLeftMiddleCornerDistal = (CalculateAngle.distance(leftMiddleEndPointX, leftMiddleCornerPointX,
				leftMiddleEndPointY, leftMiddleCornerPointY, leftMiddleEndPointZ, leftMiddleCornerPointZ));
		distanceLeftRingCornerDistal = (CalculateAngle.distance(leftRingEndPointX, leftRingCornerPointX,
				leftRingEndPointY, leftRingCornerPointY, leftRingEndPointZ, leftRingCornerPointZ));
		distanceLeftPinkyCornerDistal = (CalculateAngle.distance(leftPinkyEndPointX, leftPinkyCornerPointX,
				leftPinkyEndPointY, leftPinkyCornerPointY, leftPinkyEndPointZ, leftPinkyCornerPointZ));

		distanceRightIndexCornerProx = (CalculateAngle.distance(rightIndexStartPointX, rightIndexCornerPointX,
				rightIndexStartPointY, rightIndexCornerPointY, rightIndexStartPointZ, rightIndexCornerPointZ));
		distanceRightMiddleCornerProx = (CalculateAngle.distance(rightMiddleStartPointX, rightMiddleCornerPointX,
				rightMiddleStartPointY, rightMiddleCornerPointY, rightMiddleStartPointZ, rightMiddleCornerPointZ));
		distanceRightRingCornerProx = (CalculateAngle.distance(rightRingStartPointX, rightRingCornerPointX,
				rightRingStartPointY, rightRingCornerPointY, rightRingStartPointZ, rightRingCornerPointZ));
		distanceRightPinkyCornerProx = (CalculateAngle.distance(rightPinkyStartPointX, rightPinkyCornerPointX,
				rightPinkyStartPointY, rightPinkyCornerPointY, rightPinkyStartPointZ, rightPinkyCornerPointZ));

		distanceRightIndexCornerDistal = (CalculateAngle.distance(rightIndexEndPointX, rightIndexCornerPointX,
				rightIndexEndPointY, rightIndexCornerPointY, rightIndexEndPointZ, rightIndexCornerPointZ));
		distanceRightMiddleCornerDistal = (CalculateAngle.distance(rightMiddleEndPointX, rightMiddleCornerPointX,
				rightMiddleEndPointY, rightMiddleCornerPointY, rightMiddleEndPointZ, rightMiddleCornerPointZ));
		distanceRightRingCornerDistal = (CalculateAngle.distance(rightRingEndPointX, rightRingCornerPointX,
				rightRingEndPointY, rightRingCornerPointY, rightRingEndPointZ, rightRingCornerPointZ));
		distanceRightPinkyCornerDistal = (CalculateAngle.distance(rightPinkyEndPointX, rightPinkyCornerPointX,
				rightPinkyEndPointY, rightPinkyCornerPointY, rightPinkyEndPointZ, rightPinkyCornerPointZ));

		multiLeftIndexCorner = (CalculateAngle.multi(leftIndexEndPointX, leftIndexCornerPointX, leftIndexStartPointX,
				leftIndexEndPointY, leftIndexCornerPointY, leftIndexStartPointY, leftIndexEndPointZ,
				leftIndexCornerPointZ, leftIndexStartPointZ));
		multiLeftMiddleCorner = (CalculateAngle.multi(leftMiddleEndPointX, leftMiddleCornerPointX,
				leftMiddleStartPointX, leftMiddleEndPointY, leftMiddleCornerPointY, leftMiddleStartPointY,
				leftMiddleEndPointZ, leftMiddleCornerPointZ, leftMiddleStartPointZ));
		multiLeftRingCorner = (CalculateAngle.multi(leftRingEndPointX, leftRingCornerPointX, leftRingStartPointX,
				leftRingEndPointY, leftRingCornerPointY, leftRingStartPointY, leftRingEndPointZ, leftRingCornerPointZ,
				leftRingStartPointZ));
		multiLeftPinkyCorner = (CalculateAngle.multi(leftPinkyEndPointX, leftPinkyCornerPointX, leftPinkyStartPointX,
				leftPinkyEndPointY, leftPinkyCornerPointY, leftPinkyStartPointY, leftPinkyEndPointZ,
				leftPinkyCornerPointZ, leftPinkyStartPointZ));

		multiRightIndexCorner = (CalculateAngle.multi(rightIndexEndPointX, rightIndexCornerPointX,
				rightIndexStartPointX, rightIndexEndPointY, rightIndexCornerPointY, rightIndexStartPointY,
				rightIndexEndPointZ, rightIndexCornerPointZ, rightIndexStartPointZ));
		multiRightMiddleCorner = (CalculateAngle.multi(rightMiddleEndPointX, rightMiddleCornerPointX,
				rightMiddleStartPointX, rightMiddleEndPointY, rightMiddleCornerPointY, rightMiddleStartPointY,
				rightMiddleEndPointZ, rightMiddleCornerPointZ, rightMiddleStartPointZ));
		multiRightRingCorner = (CalculateAngle.multi(rightRingEndPointX, rightRingCornerPointX, rightRingStartPointX,
				rightRingEndPointY, rightRingCornerPointY, rightRingStartPointY, rightRingEndPointZ,
				rightRingCornerPointZ, rightRingStartPointZ));
		multiRightPinkyCorner = (CalculateAngle.multi(rightPinkyEndPointX, rightPinkyCornerPointX,
				rightPinkyStartPointX, rightPinkyEndPointY, rightPinkyCornerPointY, rightPinkyStartPointY,
				rightPinkyEndPointZ, rightPinkyCornerPointZ, rightPinkyStartPointZ));

		featureArray.add(CalculateAngle.arcCosTeta(multiLeftIndexCorner, distanceLeftIndexCornerProx,
				distanceLeftIndexCornerDistal));
		featureArray.add(CalculateAngle.arcCosTeta(multiLeftMiddleCorner, distanceLeftMiddleCornerProx,
				distanceLeftMiddleCornerDistal));
		featureArray.add(CalculateAngle.arcCosTeta(multiLeftRingCorner, distanceLeftRingCornerProx,
				distanceLeftRingCornerDistal));
		featureArray.add(CalculateAngle.arcCosTeta(multiLeftPinkyCorner, distanceLeftPinkyCornerProx,
				distanceLeftPinkyCornerDistal));

		featureArray.add(CalculateAngle.arcCosTeta(multiRightIndexCorner, distanceRightIndexCornerProx,
				distanceRightIndexCornerDistal));
		featureArray.add(CalculateAngle.arcCosTeta(multiRightMiddleCorner, distanceRightMiddleCornerProx,
				distanceRightMiddleCornerDistal));
		featureArray.add(CalculateAngle.arcCosTeta(multiRightRingCorner, distanceRightRingCornerProx,
				distanceRightRingCornerDistal));
		featureArray.add(CalculateAngle.arcCosTeta(multiRightPinkyCorner, distanceRightPinkyCornerProx,
				distanceRightPinkyCornerDistal));

		// palm distance vector
		subPalmsX=rightPalmX-leftPalmX;
		subPalmsY=rightPalmY-leftPalmY;
		subPalmsZ=rightPalmZ-leftPalmZ;
		

		multiPalmsAngleZ= CalculateAngle.multi(subPalmsX, 0, 0, subPalmsY, 0, 0, subPalmsZ, 0, 1);
		distancePalms=CalculateAngle.distance(rightPalmX, leftPalmX, rightPalmY, leftPalmY, rightPalmZ, leftPalmZ);
		angleBetweenPalms= CalculateAngle.arcCosTeta(multiPalmsAngleZ, distancePalms, 1);
		
				
		
		if (frame.hands().count() > 1) {
			featureArray.add(1000.0);
			featureArray.add(angleBetweenPalms);
			featureArray.add(leftPalmNormalX*90);
			featureArray.add(leftPalmNormalY*90);
			featureArray.add(leftPalmNormalZ*90);
			featureArray.add(rightPalmNormalX*90);
			featureArray.add(rightPalmNormalY*90);
			featureArray.add(rightPalmNormalZ*90);
		}
		else if (frame.hands().count() == 1) {
			featureArray.add(0.0);
			featureArray.add(0.0);
			featureArray.add(leftPalmNormalX*90);
			featureArray.add(leftPalmNormalY*90);
			featureArray.add(leftPalmNormalZ*90);
			featureArray.add(rightPalmNormalX*90);
			featureArray.add(rightPalmNormalY*90);
			featureArray.add(rightPalmNormalZ*90);
		}
		else
		{
			featureArray.add(0.0);
			featureArray.add(0.0);
			featureArray.add(0.0);
			featureArray.add(0.0);
			featureArray.add(0.0);
			featureArray.add(0.0);
			featureArray.add(0.0);
			featureArray.add(0.0);
			
		}
		
		Letter letter = new Letter();
		
		if(LeapListener.isSaveLetter)
		{
		letter.setLetterName(FrameSaveData.letterType); // GUIDEN VER? «EK?L?YOR
		letter.setPersonName(FrameSaveData.userName);
		letter.setLetterId(FrameSaveData.letterIdNumber);
		letter.setFeatureList(featureArray);
		}
		else
		{
			letter.setLetterName("GUESS LETTER"); // GUIDEN VER? «EK?L?YOR
			letter.setPersonName("KULLANICI");
			letter.setLetterId(1);
			letter.setFeatureList(featureArray);
		}
		// System.err.println("frame id **" + frame.id());

		callback.getLetterInfo(letter);

	}
}