package aktnf.neopleapi.cyphers.battleitem;

import java.util.List;

import aktnf.neopleapi.cyphers.CyphersApiRequest;

public class CyphersBattleitemsRequest extends CyphersApiRequest{
	public final String BATTLEITEMS = "battleitems";
	
	public CyphersBattleitemsRequest(String apikey) {
		super(apikey);
	}
	
	public CyphersBattleitemSearch search(String itemName) {
		return new CyphersBattleitemSearch(this, itemName, getApikey());
	}

	public CyphersBattleitemDetail detail(String itemId) {
		return new CyphersBattleitemDetail(this, itemId, getApikey());
	}
	
	public CyphersBattleitemMulti multi(List<String> itemIds) {
		return new CyphersBattleitemMulti(itemIds, getApikey());
	}
	
	@Override
	public String getRequestURL() {
		return super.getRequestURL() + BATTLEITEMS;
	}
	
}
