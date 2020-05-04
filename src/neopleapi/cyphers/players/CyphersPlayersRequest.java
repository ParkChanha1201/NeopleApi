package neopleapi.cyphers.players;

import neopleapi.cyphers.CyphersApiRequest;

public class CyphersPlayersRequest extends CyphersApiRequest {
	public final String PLAYERS = "players";

	public CyphersPlayersRequest(String apikey) {
		super(apikey);
	}
	/***
	 * in other class's methods, playerId() require real playerId.
	 * but this method uses nickname to request playerId.
	 * @param nickname
	 * @return PlayerId request chain
	 */
	public CyphersApiPlayerId playerId(String nickname) {
		return new CyphersApiPlayerId(this, nickname, getApikey());
	}
	
	public CyphersApiPlayerInformation information(String playerId) {
		return new CyphersApiPlayerInformation(this, playerId, getApikey());
	}

	public CyphersApiPlayerMatchRecord matchRecords(String playerId) {
		return new CyphersApiPlayerMatchRecord(this, playerId, getApikey());
	}

	@Override
	public String getRequestURL() {
		return super.getRequestURL() + PLAYERS;
	}
}
