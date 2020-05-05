package aktnf.neopleapi;

public abstract class ApiRequester {
	private String apikey;
	
	public ApiRequester(String apiKey) {
		this.apikey = apiKey;
	}
	
	protected String getApikey() {
		return apikey;
	}
}
