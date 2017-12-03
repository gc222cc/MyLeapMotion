package entity;
/* Bir frameden Ç?kart?lan featurelar o framede
 * anlat?lmak istenen harfin ad?, harfin id si,
 * kullan?c?n?n ad? bu s?n?fta saklan?r. datada
 * letter objeleri saklan?r.
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Letter implements Serializable {

	private String letterName;
	private ArrayList<Double> featureList = new ArrayList<>(); // feature
																// attribute
	private String personName;
	private int letterId;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getLetterId() {
		return letterId;
	}

	public void setLetterId(int letterId) {
		this.letterId = letterId;
	}

	public String getLetterName() {
		return letterName;
	}

	public void setLetterName(String letterName) {
		this.letterName = letterName;
	}

	public ArrayList<Double> getFeatureList() {
		return featureList;
	}

	public void setFeatureList(ArrayList<Double> featureList) {
		this.featureList = featureList;
	}

}
