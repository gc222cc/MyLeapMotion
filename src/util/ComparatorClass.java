package util;

import entity.Neighbour;

import java.util.Comparator;


public class ComparatorClass implements Comparator <Neighbour>{

	@Override
	public int compare(Neighbour n1, Neighbour n2) {

		if (n1.getDistance() <= n2.getDistance()) {
			return -1;
		}
		if (n1.getDistance() > n2.getDistance()) {
			return 1;
		}
		return 0;
	}

}
