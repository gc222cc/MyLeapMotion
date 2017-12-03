package util;

import java.lang.Math;

public class CalculateAngle {

	// palm angle feature 1 (20 units)
	// finger angle feature 2 (20 units)
	// distance between fingers feature 3 (20 units)

	// finger tip or end coordinate (x1,y1,z1) // palm (x2,y2,z2) 
	public static double distance(double x_1, double x_2, double y_1, double y_2, double z_1, double z_2) // length fingers 
																											 
	{
		double result, temp;

		temp = Math.pow((x_1 - x_2), 2) + Math.pow((y_1 - y_2), 2) + Math.pow((z_1 - z_2), 2);

		// System.out.println("temp =>" + temp);

		result = Math.sqrt(temp);

		return result;

	}

	// finger tip or end coordinate (x1,y1,z1) // palm or finger start coordinate (x2,y2,z2)  // another finger tip or end coordinate (x3,y3,z3)

	public static double multi(double x_1, double x_2, double x_3, double y_1, double y_2, double y_3, double z_1,
			double z_2, double z_3) {
		double tmp;

		tmp = (x_1 - x_2) * (x_3 - x_2) + (y_1 - y_2) * (y_3 - y_2) + (z_1 - z_2) * (z_3 - z_2);

		// System.out.println("multi => " + tmp);

		return tmp;

	}
	
	//for find angle between fingers
	public static double arcCosTeta(double multi, double distance1, double distance2) {

		double result, angle;

		if (distance1 * distance2 <= 0 )
			return 0;
		else {
			result = multi / (distance1 * distance2);

			if(result>1.0)
			{
				result=1.0;
			}
			
			if(result<-1.0)
			{
				result=-1.0;
			}
			
		//	System.out.println("result => " + result);

			double cos=Math.acos(result);
			
			angle = Math.toDegrees(cos);
			
			return angle;
		}
	}
	

}
