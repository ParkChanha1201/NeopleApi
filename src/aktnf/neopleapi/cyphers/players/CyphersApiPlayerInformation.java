package aktnf.neopleapi.cyphers.players;

import org.json.JSONObject;

import aktnf.neopleapi.apirequest.ApiRequestDecorator;
import aktnf.neopleapi.cyphers.CyphersApiRequest;

public class CyphersApiPlayerInformation extends ApiRequestDecorator{
	private CyphersApiRequest apiRequest;
	private String playerId;
	private String apikey;
	
	public CyphersApiPlayerInformation(CyphersApiRequest apiRequest, String playerId, String apikey) {
		this.apiRequest = apiRequest;
		this.playerId = playerId;
		this.apikey = apikey;
	}
	
	@Override
	public String getRequestURL() {
		StringBuilder sb = new StringBuilder(apiRequest.getRequestURL());
		
		sb.append("/" + playerId);
		
		sb.append("?&apikey=" + apikey);
		
		return sb.toString();
	}
	
	@Override
	public JSONObject getRawData() {
		//TODO: method not implements
		return null;
	}

}
