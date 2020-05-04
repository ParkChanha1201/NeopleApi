package neopleapi.cyphers.players;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONObject;

import neopleapi.WordType;
import neopleapi.apirequest.ApiRequestDecorator;
import neopleapi.cyphers.CyphersApiRequest;

public class CyphersApiPlayerId extends ApiRequestDecorator{
	private CyphersApiRequest apiRequest; 
	private String nickname;
	private String wordType;
	//Use 'Integer' class instead of int. for checking null in method 'getRequestURL'
	private Integer limit;
	private String apikey;
	
	public CyphersApiPlayerId(CyphersApiRequest apiRequest, String nickname, String apiKey) {
		this.nickname = nickname;
		this.apiRequest = apiRequest;
		this.apikey = apiKey;
	}
	
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
	
	@Override
	public JSONObject getRawData(){
		//TODO: method not implements
		return null;
	}
}
