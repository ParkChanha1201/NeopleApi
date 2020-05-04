package neopleapi.cyphers.character;

import org.json.JSONObject;

import neopleapi.apirequest.ApiRequestDecorator;
import neopleapi.cyphers.CyphersApiRequest;

/***
 * 이친구는 resources에 미리 저장해놓아서 CyphersCharacterIds 에서 가져올 수 있지만
 * 일단 Api가 존재하니까 만들어놓음.
 */
public class CyphersCharacterInformation extends ApiRequestDecorator{
	private CyphersApiRequest apiRequest;
	private String apikey;
	
	public CyphersCharacterInformation(CyphersApiRequest apiRequest, String apikey) {
		this.apiRequest = apiRequest;
		this.apikey = apikey;
	}

	@Override
	public String getRequestURL() {
		StringBuilder sb = new StringBuilder(apiRequest.getRequestURL());
		
		sb.append("/?apikey=");
		sb.append(apikey);
		
		return sb.toString();
	}

	@Override
	public JSONObject getRawData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
