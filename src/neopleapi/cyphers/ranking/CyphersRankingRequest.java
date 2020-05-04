package neopleapi.cyphers.ranking;

import neopleapi.cyphers.CyphersApiRequest;
import neopleapi.cyphers.character.CyphersCharacterName;

public class CyphersRankingRequest extends CyphersApiRequest{
	public final String RANKING = "ranking";
	
	public CyphersRankingRequest(String apikey) {
		super(apikey);
	}

	public CyphersRankingRatingPoint ratingPoint(String playerId) {
		return new CyphersRankingRatingPoint(this, playerId, getApikey());
	}
	
	public CyphersRankingCharacter characters(CyphersCharacterName characterName, RankingType rankingType) {
		return new CyphersRankingCharacter(this, characterName, rankingType, getApikey());
	}
	/***
	 * TSJ is initial character of '투신전'.
	 * it has two types melee and ranged.
	 */
	public CyphersRankingTSJ tsj(TSJType tsjType) {
		return new CyphersRankingTSJ(this, tsjType, getApikey());
	}
	
	@Override
	public String getRequestURL() {
		return super.getRequestURL() + RANKING;
	}
}
