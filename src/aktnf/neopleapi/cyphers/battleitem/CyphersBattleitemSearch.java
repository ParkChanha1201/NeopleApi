package aktnf.neopleapi.cyphers.battleitem;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONObject;

import aktnf.neopleapi.WordType;
import aktnf.neopleapi.apirequest.ApiRequestDecorator;
import aktnf.neopleapi.cyphers.CyphersApiRequest;

public class CyphersBattleitemSearch extends ApiRequestDecorator{
	private CyphersApiRequest apiRequest;
	private String itemName;
	private Integer limit;
	private String wordType;
	//q=characterId:<characterId>;slotCode:<slotCode>,rarityCode:<rarityCode>,seasonCode:<seasonCode>
	private String characterId;
	private String slotCode;
	private String rarityCode;
	private String seasonCode;
	private boolean hasQ;
	
	private String apikey;
	
	public CyphersBattleitemSearch(CyphersApiRequest apiRequest, String itemName, String apikey) {
		this.apiRequest = apiRequest;
		this.itemName = itemName;
		this.apikey = apikey;
		this.hasQ = false;
	}
	
	public CyphersBattleitemSearch limit(int limit) {
		this.limit = limit;
		return this;
	}
	
	public CyphersBattleitemSearch wordType(WordType wordType) {
		switch(wordType) {
		case FULL:
			this.wordType = "full";
			break;
		case MATCH:
			this.wordType = "match";
			break;
		case FRONT:
			this.wordType = "front";
			break;
		}
		
		return this;
	}
	
	public CyphersBattleitemSearch characterId(String characterId) {
		this.hasQ = true;
		this.characterId = characterId;
		return this;
	}
	
	public CyphersBattleitemSearch slotCode(String slotCode) {
		this.hasQ = true;
		this.slotCode = slotCode;
		return this;
	}
	
	public CyphersBattleitemSearch rarityCode(String rarityCode) {
		this.hasQ = true;
		this.rarityCode = rarityCode;
		return this;
	}
	
	public CyphersBattleitemSearch seasonCode(String seasonCode) {
		this.hasQ = true;
		this.seasonCode = seasonCode;
		return this;
	}
	
	@Override
	public String getRequestURL() {
		StringBuilder sb = new StringBuilder(apiRequest.getRequestURL());
		
		sb.append("?");
		
		try {
			sb.append("itemName=");
			sb.append(URLEncoder.encode(itemName, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			sb.append("itemName=");
			sb.append(itemName);
		}
	
		if(limit != null) {
			sb.append("&limit=");
			sb.append(limit);
		}
		
		if(wordType != null) {
			sb.append("&wordType=");
			sb.append(wordType);
		}
		
		if(hasQ) {
			sb.append("&q=");
			
			if(characterId != null) {
				sb.append(",characterId:");
				sb.append(characterId);
			}
			
			if(slotCode != null) {
				sb.append(",slotCode:");
				sb.append(slotCode);
			}
			
			if(rarityCode != null) {
				sb.append(",rarityCode:");
				sb.append(rarityCode);
			}
			
			if(seasonCode != null) {
				sb.append(",seasonCode:");
				sb.append(seasonCode);
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
