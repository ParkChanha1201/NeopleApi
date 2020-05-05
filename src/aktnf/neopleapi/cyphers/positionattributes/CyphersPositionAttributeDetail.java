package aktnf.neopleapi.cyphers.positionattributes;

import org.json.JSONObject;

import aktnf.neopleapi.apirequest.ApiRequestDecorator;
import aktnf.neopleapi.cyphers.CyphersApiRequest;


public class CyphersPositionAttributeDetail extends ApiRequestDecorator {
	private CyphersApiRequest apiRequest;
	private String attributeId;
	private String apikey;
	
	public CyphersPositionAttributeDetail(CyphersApiRequest apiRequest, String attributeId, String apikey) {
		this.apiRequest = apiRequest;
		this.attributeId = attributeId;
		this.apikey = apikey;
	}

	@Override
	public String getRequestURL() {
		StringBuilder sb = new StringBuilder(apiRequest.getRequestURL());
		
		sb.append("/" + attributeId);
		sb.append("?apikey=");
		sb.append(apikey);
		
		return sb.toString();
	}

	@Override
	public JSONObject getRawData() {
		// TODO Auto-generated method stub
		return null;
	}
}
