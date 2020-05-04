package neopleapi.cyphers.matches;

import org.json.JSONObject;

import neopleapi.apirequest.ApiRequestDecorator;
import neopleapi.cyphers.CyphersApiRequest;

public class CyphersMatchDetail extends ApiRequestDecorator{
	private CyphersApiRequest apiRequest;
	private String matchId;
	private String apikey;
	
	public CyphersMatchDetail(CyphersApiRequest apiRequest, String matchId, String apikey) {
		this.apiRequest = apiRequest;
		this.matchId = matchId;
		this.apikey = apikey;
	}
	
	@Override
	public String getRequestURL() {
		StringBuilder sb = new StringBuilder(apiRequest.getRequestURL());
		
		sb.append("/" + matchId);
		
		sb.append("?&apikey=" + apikey);
		
		return sb.toString();
	}
	
	@Override
	public JSONObject getRawData() {
		//TODO: method not implements
		return null;
	}
}
