package neopleapi.cyphers;

import neopleapi.ApiRequester;
import neopleapi.cyphers.battleitem.CyphersBattleitemsRequest;
import neopleapi.cyphers.character.CyphersCharactersRequest;
import neopleapi.cyphers.matches.CyphersMatchesRequest;
import neopleapi.cyphers.players.CyphersPlayersRequest;
import neopleapi.cyphers.positionattributes.CyphersPositionAttributesRequest;
import neopleapi.cyphers.ranking.CyphersRankingRequest;

public class CyphersApiRequester extends ApiRequester {
	public CyphersApiRequester(String apikey) {
		super(apikey);
	}

	public CyphersPlayersRequest players() {
		return new CyphersPlayersRequest(getApikey());
	}
	
	public CyphersMatchesRequest matches() {
		return new CyphersMatchesRequest(getApikey());
	}
	
	public CyphersRankingRequest ranking() {
		return new CyphersRankingRequest(getApikey());
	}
	
	public CyphersBattleitemsRequest battleitems() {
		return new CyphersBattleitemsRequest(getApikey());
	}
	
	public CyphersCharactersRequest characters() {
		return new CyphersCharactersRequest(getApikey());
	}
	
	public CyphersPositionAttributesRequest positionAttributes() {
		return new CyphersPositionAttributesRequest(getApikey());
	}
}
