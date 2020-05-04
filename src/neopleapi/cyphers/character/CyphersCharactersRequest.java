package neopleapi.cyphers.character;

import neopleapi.cyphers.CyphersApiRequest;

public class CyphersCharactersRequest extends CyphersApiRequest{
	public final String CHARACTERS = "characters";
	
	public CyphersCharactersRequest(String apikey) {
		super(apikey);
	}
	
	public CyphersCharacterInformation informations() {
		return new CyphersCharacterInformation(this, getApikey());
	}

	@Override
	public String getRequestURL() {
		return super.getRequestURL() + CHARACTERS;
	}
	
}
