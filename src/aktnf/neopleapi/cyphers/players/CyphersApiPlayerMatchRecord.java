package aktnf.neopleapi.cyphers.players;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

import aktnf.neopleapi.apirequest.ApiRequestDecorator;
import aktnf.neopleapi.cyphers.CyphersApiRequest;
import aktnf.neopleapi.cyphers.GameTypeId;

public class CyphersApiPlayerMatchRecord extends ApiRequestDecorator {
	private CyphersApiRequest apiRequest;
	private String playerId;
	private String apikey;
	private String gameTypeId;
	private SimpleDateFormat dateFormat;
	private Date startDate;
	private Date endDate;
	//Use 'Integer' class instead of int. for checking null in method 'getRequestURL'
	private Integer limit;
	private String next;
	
	public CyphersApiPlayerMatchRecord(CyphersApiRequest apiRequest, String playerId, String apikey) {
		this.apiRequest = apiRequest;
		this.playerId = playerId;
		this.apikey = apikey;
		this.dateFormat = new SimpleDateFormat("YYYYMMdd'T'HHmm");
	}
	
	public CyphersApiPlayerMatchRecord gameTypeId(GameTypeId gameTypeId) {
		switch(gameTypeId) {
		case RATING:
			this.gameTypeId = "rating";
			break;
		case NORMAL:
			this.gameTypeId = "normal";
			break;
		}
		
		return this;
	}
	
	public CyphersApiPlayerMatchRecord startDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}
	
	public CyphersApiPlayerMatchRecord endDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}
	
	public CyphersApiPlayerMatchRecord limit(int limit) {
		this.limit = limit;
		return this;
	}
	
	public CyphersApiPlayerMatchRecord next(String next) {
		this.next = next;
		return this;
	}
	
	@Override
	public String getRequestURL() {
		StringBuilder sb = new StringBuilder(apiRequest.getRequestURL());
		
		sb.append("/" + playerId);
		sb.append("/" + "matches?");
		
		if(gameTypeId != null) {
			sb.append("&gameTypeId=");
			sb.append(gameTypeId);
		}
		
		//if both of Date is not exist, can't search
		//so it checks startDate and endDate
		if(startDate != null && endDate != null) {
			sb.append("&startDate=");
			sb.append(dateFormat.format(startDate));
			
			sb.append("&endDate=");
			sb.append(dateFormat.format(endDate));
		} 
		
		if(limit != null) {
			sb.append("&limit=");
			sb.append(limit);
		}
		
		if(next != null) {
			sb.append("&next=");
			sb.append(next);
		}
		
		sb.append("&apikey=" + apikey);
		
		return sb.toString();
	}

	@Override
	public JSONObject getRawData() {
		//TODO: method not implements
		return null;
	}
	
}
