package aktnf.neopleapi.cyphers.players;

public class Player {
	private String nickname;
	private String playerId;
	private int grade;
	
	public Player(String nickname, String playerId, int grade) {
		this.nickname = nickname;
		this.playerId = playerId;
		this.grade = grade;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
