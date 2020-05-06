package aktnf.neopleapi.cyphers.players;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import aktnf.neopleapi.WordType;
import aktnf.neopleapi.apirequest.ApiRequestDecorator;
import aktnf.neopleapi.cyphers.CyphersApiRequest;

public class CyphersApiPlayerId extends ApiRequestDecorator{
	private CyphersApiRequest apiRequest; 
	private String nickname;
	private String wordType;
	//Use 'Integer' class instead of int. for checking null in method 'getRequestURL'
	private Integer limit;
	private String apikey;
	
	CyphersApiPlayerId(CyphersApiRequest apiRequest, String nickname, String apiKey) {
		this.nickname = nickname;
		this.apiRequest = apiRequest;
		this.apikey = apiKey;
	}
	
	/***
	 * playerId API에서는 WordType이 MATCH와 FULL만 제공됩니다.
	 * @param wordType
	 */
	public CyphersApiPlayerId wordType(WordType wordType) {
		switch(wordType) {
		case MATCH:
			this.wordType = "match";
			break;
		case FULL:
			this.wordType = "full";
			break;
		default:
			break;
		}
		
		return this;
	}
	
	/***
	 * limit의 default값은 10이고 최대 200까지 입력할 수 있습니다.
	 * @param limit
	 */
	public CyphersApiPlayerId limit(int limit) {
		this.limit = limit;
		
		return this;
	}
	
	@Override
	public String getRequestURL() {
		StringBuilder sb = new StringBuilder(apiRequest.getRequestURL());
		
		try {
			sb.append("?nickname=");
			sb.append(URLEncoder.encode(nickname, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			sb.append("?nickname=");
			sb.append(nickname);
		}
		
		if(wordType != null) {
			sb.append("&wordType=");
			sb.append(wordType);
		}

		if(limit != null) {
			sb.append("&limit=");
			sb.append(limit);
		}
		
		sb.append("&apikey=" + apikey);
		
		return sb.toString();
	}
	/***
	 * getRawData()로부터 가공된 데이터를 가져옵니다
	 * @return nickname으로 검색된 player의 리스트
	 */
	public List<Player> getPlayerList() {
		List<Player> players = new ArrayList<Player>();
		
		JSONObject response = getRawData();
		
		JSONArray rows = response.getJSONArray("rows");

		int length = rows.length();
		
		for(int i = 0; i < length; i++) {
			JSONObject player = rows.getJSONObject(i);
			
			int grade = player.getInt("grade");
			String nickname = player.getString("nickname");
			String playerId = player.getString("playerId");
			
			players.add(new Player(nickname, playerId, grade));
		}
		
		return players; 
	}
}
