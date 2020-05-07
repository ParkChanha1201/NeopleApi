package aktnf.neopleapi.cyphers.ranking;

import aktnf.neopleapi.apirequest.ApiRequestDecorator;
import aktnf.neopleapi.cyphers.CyphersApiRequest;


public class CyphersRankingTSJ extends ApiRequestDecorator{
	private CyphersApiRequest apiRequest;
	private String tsjType;
	private String playerId;
	private Integer offset;
	private Integer limit;
	private String apikey;
	
	public CyphersRankingTSJ(CyphersApiRequest apiRequest, TSJType tsjType, String apikey) {
		this.apiRequest = apiRequest;
		setTSJType(tsjType);
		this.apikey = apikey;
	}
	
	private void setTSJType(TSJType tsjType) {
		switch(tsjType) {
		case MELEE:
			this.tsjType = "melee";
			break;
		case RANGED:
			this.tsjType = "ranged";
			break;
		}
	}
	
	public CyphersRankingTSJ playerId(String playerId) {
		this.playerId = playerId;
		return this;
	}
	
	public CyphersRankingTSJ offset(int offset) {
		this.offset = offset;
		return this;
	}
	
	public CyphersRankingTSJ limit(int limit) {
		this.limit = limit;
		return this;
	}
	
	@Override
	public String getRequestURL() {
		StringBuilder sb = new StringBuilder(apiRequest.getRequestURL());
		
		sb.append("/tsj");
		sb.append("/" + tsjType + "?");
		
		if(playerId != null) {
			sb.append("&playerId=");
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
}
