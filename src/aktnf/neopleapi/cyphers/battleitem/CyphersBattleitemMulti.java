package aktnf.neopleapi.cyphers.battleitem;

import java.util.List;

import org.json.JSONObject;

import aktnf.neopleapi.apirequest.ApiRequestDecorator;


public class CyphersBattleitemMulti extends ApiRequestDecorator{
	//private CyphersApiRequest apiRequest;
	private List<String> itemIds;
	private String apikey;

	/*
	 * 다른거는 CyphersApiRequest에서 getRequestURL해서 뒤에 파라미터를 붙이면 됐는데
	 * multi 붙은 이녀석은 URL구조가 혼자 달라서 일단은 ApiRequest를 생성자에서 받긴 했는데 사용하지 않아 주석처리해놓음.
	 * 만약 나중에 multi 붙은것들이 더 추가된다면 CyphersBattleitemMulti를 CyphersMultiRequest 하위로 옮기고 사용할 예정.
	 */
	/*
	 * public CyphersBattleitemMulti(CyphersApiRequest apiRequest, List<String>
	 * itemIds, String apikey) { this.itemIds = itemIds; this.apikey = apikey; }
	 */

	public CyphersBattleitemMulti(List<String> itemIds, String apikey) {
		this.itemIds = itemIds;
		this.apikey = apikey;
	}
	
	@Override
	public String getRequestURL() {
		StringBuilder sb = new StringBuilder("https://api.neople.co.kr/cy/multi/battleitems/");
		String seperator = "";
		sb.append("?itemIds=");
		
		for(String itemId : itemIds) {
			sb.append(seperator);
			sb.append(itemId);
			if(seperator.equals("")) {
				seperator = ",";
			}
		}
		
		sb.append("&apikey=");
		sb.append(apikey);
		
		return sb.toString();
	}

	@Override
	public JSONObject getRawData() {
		// TODO Auto-generated method stub
		return null;
	}
}
