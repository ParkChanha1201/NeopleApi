package aktnf.neopleapi.cyphers.players;

public class Rating {
	private int ratingPoint;
	private int maxRatingPoint;
	private String tierName;

	public Rating() {
	}
	
	public Rating(int ratingPoint, int maxRatingPoint, String tierName) {
		this.ratingPoint = ratingPoint;
		this.maxRatingPoint = maxRatingPoint;
		this.tierName = tierName;
	}
	
	public int getRatingPoint() {
		return ratingPoint;
	}

	public void setRatingPoint(int ratingPoint) {
		this.ratingPoint = ratingPoint;
	}

	public int getMaxRatingPoint() {
		return maxRatingPoint;
	}

	public void setMaxRatingPoint(int maxRatingPoint) {
		this.maxRatingPoint = maxRatingPoint;
	}

	public String getTierName() {
		return tierName;
	}

	public void setTierName(String tierName) {
		this.tierName = tierName;
	}

}
