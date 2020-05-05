package aktnf.neopleapi.cyphers.battleitem;

import aktnf.neopleapi.apirequest.ApiRequestDecorator;
import aktnf.neopleapi.cyphers.CyphersApiRequest;

public class CyphersBattleitemDetail extends ApiRequestDecorator{
	private CyphersApiRequest apiRequest;
	private String itemId;
	private String apikey;
	
	public CyphersBattleitemDetail(CyphersApiRequest apiRequest, String itemId, String apikey) {
		this.apiRequest = apiRequest;
		this.itemId = itemId;
		this.apikey = apikey;
	}

	@Override
	public String getRequestURL() {
		StringBuilder sb = new StringBuilder(apiRequest.getRequestURL());
		
		sb.append("/" + itemId);
		sb.append("?apikey=");
		sb.append(apikey);
		
		return sb.toString();
	}
}
