package neopleapi.cyphers.matches;

import neopleapi.cyphers.CyphersApiRequest;

public class CyphersMatchesRequest extends CyphersApiRequest{
	public final String MATCHES = "matches";
	
	public CyphersMatchesRequest(String apikey) {
		super(apikey);
	}

	public CyphersMatchDetail detail(String matchId) {
		return new CyphersMatchDetail(this, matchId, getApikey());
	}
	
	@Override
	public String getRequestURL() {
		return super.getRequestURL() + MATCHES;
	}
	
}
