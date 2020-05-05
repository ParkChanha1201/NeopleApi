package aktnf.neopleapi.cyphers;

import aktnf.neopleapi.apirequest.ApiRequest;

public class CyphersApiRequest extends ApiRequest {
	public final String CYPHERS_BASE_URL = "cy/";
	private String apiKey;
	
	public CyphersApiRequest(String apikey) {
		this.apiKey = apikey;
	}
	
	@Override
	public String getRequestURL() {
		return super.getRequestURL() + CYPHERS_BASE_URL;
	}

	protected String getApikey() {
		return apiKey;
	}
	
}
