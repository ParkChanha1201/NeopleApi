package aktnf.neopleapi.cyphers.players;

public class MatchRecord {
	private String gameType;
	private int winCount;
	private int loseCount;
	private int stopCount;
	
	public MatchRecord(String gameType) {
		this.gameType = gameType;
	}
	
	public MatchRecord(String gameType, int winCount, int loseCount, int stopCount) {
		this.gameType = gameType;
		this.winCount = winCount;
		this.loseCount = loseCount;
		this.stopCount = stopCount;
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public int getWinCount() {
		return winCount;
	}
	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}
	public int getLoseCount() {
		return loseCount;
	}
	public void setLoseCount(int loseCount) {
		this.loseCount = loseCount;
	}
	public int getStopCount() {
		return stopCount;
	}
	public void setStopCount(int stopCount) {
		this.stopCount = stopCount;
	}
}
