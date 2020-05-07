package aktnf.neopleapi.cyphers.players;

public class PlayerInformation {
	private Player player;
	private String clanName;
	private Rating rating;
	private Record ratingRecord;
	private Record normalRecord;

	public PlayerInformation() {
	}

	public PlayerInformation(Player player, String clanName, Rating rating, Record ratingRecord, Record normalRecord) {
		this.player = player;
		this.clanName = clanName;
		this.rating = rating;
		this.ratingRecord = ratingRecord;
		this.normalRecord = normalRecord;
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

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Record getRatingRecord() {
		return ratingRecord;
	}

	public void setRatingRecord(Record ratingRecord) {
		this.ratingRecord = ratingRecord;
	}

	public Record getNormalRecord() {
		return normalRecord;
	}

	public void setNormalRecord(Record normalRecord) {
		this.normalRecord = normalRecord;
	}
}
