package aktnf.neopleapi.cyphers.ranking;

import org.json.JSONObject;

import aktnf.neopleapi.apirequest.ApiRequestDecorator;
import aktnf.neopleapi.cyphers.CyphersApiRequest;
import aktnf.neopleapi.cyphers.character.CyphersCharacterIds;
import aktnf.neopleapi.cyphers.character.CyphersCharacterName;


public class CyphersRankingCharacter extends ApiRequestDecorator{
	private CyphersApiRequest apiRequest;
	private String characterId;
	private String rankingType;
	private String playerId;
	private Integer offset;
	private Integer limit;
	private String apikey;
	
	public CyphersRankingCharacter(CyphersApiRequest apiRequest, 
			CyphersCharacterName characterName,RankingType rankingType , String apikey) {
		this.apiRequest = apiRequest;
		this.characterId = CyphersCharacterIds.getCharacterId(characterName);
		setRankingType(rankingType);
		this.apikey = apikey;
	}
	
	private void setRankingType(RankingType rankingType) {
		switch(rankingType) {
		case ASSIST_COUNT:
			this.rankingType = "assistCount";
			break;
		case EXP:
			this.rankingType = "exp";
			break;
		case KILL_COUNT:
			this.rankingType = "killCount";
			break;
		case WIN_COUNT:
			this.rankingType = "winCount";
			break;
		case WIN_RATE:
			this.rankingType = "winRate";
			break;
		}
	}
	
	public CyphersRankingCharacter playerId(String playerId) {
		this.playerId = playerId;
		return this;
	}
	
	public CyphersRankingCharacter offset(int offset) {
		this.offset = offset;
		return this;
	}
	
	public CyphersRankingCharacter limit(int limit) {
		this.limit = limit;
		return this;
	}
	
	@Override
	public String getRequestURL() {
		StringBuilder sb = new StringBuilder(apiRequest.getRequestURL());
		
		sb.append("/characters");
		sb.append("/" + characterId);
		sb.append("/" + rankingType + "?");
		
		if(playerId != null) {
			sb.append("playerId=");
			sb.append(playerId);
		}
		
		if(offset != null) {
			sb.append("&offset=");
			sb.append(offset);
		}
		
		if(limit != null) {
			sb.append("&limit=");
			sb.append(limit);
		}
		
		sb.append("&apikey=");
		sb.append(apikey);
		
		return sb.toString();
	}

	@Override
	public JSONObject getRawData() {
		// TODO Auto-generated method stub
		return null;
	}
}
