package aktnf.neopleapi.cyphers.matches;

public class PlayInformation {
	private int level;
	private int assistCount;
	// 시야점수
	private int sightPoint;
	private int deathCount;
	private String result;
	private boolean random;
	// 받은 데미지
	private int damagePoint;
	// 가한 피해량
	private int attackPoint;
	private int killCount;
	private String characterName;
	// 전투참여점수
	private int battlePoint;
	private int playTime;
	private int partyUserCount;
	private String characterId;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAssistCount() {
		return assistCount;
	}

	public void setAssistCount(int assistCount) {
		this.assistCount = assistCount;
	}

	public int getSightPoint() {
		return sightPoint;
	}

	public void setSightPoint(int sightPoint) {
		this.sightPoint = sightPoint;
	}

	public int getDeathCount() {
		return deathCount;
	}

	public void setDeathCount(int deathCount) {
		this.deathCount = deathCount;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isRandom() {
		return random;
	}

	public void setRandom(boolean random) {
		this.random = random;
	}

	public int getDamagePoint() {
		return damagePoint;
	}

	public void setDamagePoint(int damagePoint) {
		this.damagePoint = damagePoint;
	}

	public int getAttackPoint() {
		return attackPoint;
	}

	public void setAttackPoint(int attackPoint) {
		this.attackPoint = attackPoint;
	}

	public int getKillCount() {
		return killCount;
	}

	public void setKillCount(int killCount) {
		this.killCount = killCount;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public int getBattlePoint() {
		return battlePoint;
	}

	public void setBattlePoint(int battlePoint) {
		this.battlePoint = battlePoint;
	}

	public int getPlayTime() {
		return playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

	public int getPartyUserCount() {
		return partyUserCount;
	}

	public void setPartyUserCount(int partyUserCount) {
		this.partyUserCount = partyUserCount;
	}

	public String getCharacterId() {
		return characterId;
	}

	public void setCharacterId(String characterId) {
		this.characterId = characterId;
	}
}
