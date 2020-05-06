package aktnf.neopleapi.cyphers.players;

public class PlayerInformation {
	private Player player;
	private String clanName;
	private int ratingPoint;
	private int maxRatingPoint;
	private String tierName;
	private MatchRecord rating;
	private MatchRecord normal;

	public PlayerInformation() {
	}
	
	public PlayerInformation(Player player, String clanName, int ratingPoint, int maxRatingPoint, String tierName,
			MatchRecord rating, MatchRecord normal) {
		this.player = player;
		this.clanName = clanName;
		this.ratingPoint = ratingPoint;
		this.maxRatingPoint = maxRatingPoint;
		this.tierName = tierName;
		this.rating = rating;
		this.normal = normal;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getClanName() {
		return clanName;
	}

	public void setClanName(String clanName) {
		this.clanName = clanName;
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

	public MatchRecord getRating() {
		return rating;
	}

	public void setRating(MatchRecord rating) {
		this.rating = rating;
	}

	public MatchRecord getNormal() {
		return normal;
	}

	public void setNormal(MatchRecord normal) {
		this.normal = normal;
	}
}
