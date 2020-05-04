package neopleapi.cyphers.ranking;

import org.json.JSONObject;

import neopleapi.apirequest.ApiRequestDecorator;
import neopleapi.cyphers.CyphersApiRequest;

public class CyphersRankingRatingPoint extends ApiRequestDecorator {
	private CyphersApiRequest apiRequest;
	private String playerId;
	private Integer offset;
	private Integer limit;
	private String apikey;
	
	public CyphersRankingRatingPoint(CyphersApiRequest apiRequest, String playerId, String apikey) {
		this.apiRequest = apiRequest;
		this.playerId = playerId;
		this.apikey = apikey;
	}
	
	public CyphersRankingRatingPoint offset(int offset) {
		this.offset = offset;

		return this;
	}
	
	public CyphersRankingRatingPoint limit(int limit) {
		this.limit = limit;
		
		return this;
	}
	
	@Override
	public String getRequestURL() {
		StringBuilder sb = new StringBuilder(apiRequest.getRequestURL());

		sb.append("/ratingpoint?");
		
		sb.append("playerId=");
		sb.append(playerId);
		
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
