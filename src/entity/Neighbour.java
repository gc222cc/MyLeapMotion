package entity;/* Bu s?n?f Verimizdeki entity.Letter s?n?f?na ait
 * objeleri i\u015eleyerek, o s?rada kullan?c?n?n
 * leap Motion a g�sterdi\u011ei el hareketinden
 * t�retilen diziye ne kadar uzakl?kta
 * kom\u015eular oldu\u011eunu ifade eder
 */

public class Neighbour {

	private double distance;

	private String letterVote;

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getLetterVote() {
		return letterVote;
	}

	public void setLetterVote(String letterVote) {
		this.letterVote = letterVote;
	}

}
