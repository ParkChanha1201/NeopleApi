package aktnf.neopleapi.cyphers.positionattributes;

import aktnf.neopleapi.cyphers.CyphersApiRequest;

public class CyphersPositionAttributesRequest extends CyphersApiRequest {
	public static final String POSITION_ATTRIBUTES = "position-attributes";

	public CyphersPositionAttributesRequest(String apikey) {
		super(apikey);
	}
	
	public CyphersPositionAttributeDetail detail(String attributeId) {
		return new CyphersPositionAttributeDetail(this, attributeId, getApikey());
	}

	@Override
	public String getRequestURL() {
		return super.getRequestURL() + POSITION_ATTRIBUTES;
	}
	
}
