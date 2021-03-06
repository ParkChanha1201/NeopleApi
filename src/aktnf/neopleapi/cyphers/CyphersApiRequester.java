package aktnf.neopleapi.cyphers;

import aktnf.neopleapi.ApiRequester;
import aktnf.neopleapi.cyphers.battleitem.CyphersBattleitemsRequest;
import aktnf.neopleapi.cyphers.character.CyphersCharactersRequest;
import aktnf.neopleapi.cyphers.matches.CyphersMatchesRequest;
import aktnf.neopleapi.cyphers.players.CyphersPlayersRequest;
import aktnf.neopleapi.cyphers.positionattributes.CyphersPositionAttributesRequest;
import aktnf.neopleapi.cyphers.ranking.CyphersRankingRequest;

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
