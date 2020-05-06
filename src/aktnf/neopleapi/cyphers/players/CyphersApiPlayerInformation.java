package aktnf.neopleapi.cyphers.players;

import org.json.JSONArray;
import org.json.JSONObject;

import aktnf.neopleapi.apirequest.ApiRequestDecorator;
import aktnf.neopleapi.cyphers.CyphersApiRequest;

public class CyphersApiPlayerInformation extends ApiRequestDecorator {
	private CyphersApiRequest apiRequest;
	private String playerId;
	private String apikey;

	public CyphersApiPlayerInformation(CyphersApiRequest apiRequest, String playerId, String apikey) {
		this.apiRequest = apiRequest;
		this.playerId = playerId;
		this.apikey = apikey;
	}

	@Override
	public String getRequestURL() {
		StringBuilder sb = new StringBuilder(apiRequest.getRequestURL());

		sb.append("/" + playerId);

		sb.append("?&apikey=" + apikey);

		return sb.toString();
	}
	
	public PlayerInformation getPlayerInformation() {
		PlayerInformation playerInformation = new PlayerInformation();

		JSONObject response = getRawData();
		
		Player player = new Player(response.getString("nickname"),response.getString("playerId"),response.getInt("grade"));
		playerInformation.setPlayer(player);
		
		// get player information
		playerInformation.setClanName(response.isNull("clanName") ? "" : response.getString("clanName"));
		playerInformation.setRatingPoint(response.isNull("ratingPoint") ? 0 : response.getInt("ratingPoint"));
		playerInformation.setMaxRatingPoint(response.isNull("maxRatingPoint") ? 0 : response.getInt("maxRatingPoint"));
		playerInformation.setTierName(response.isNull("tierName") ? "" : response.getString("tierName"));

		// get match records
		JSONArray records = response.getJSONArray("records");
		JSONObject rating = records.getJSONObject(0);
		JSONObject normal = records.getJSONObject(1);

		MatchRecord ratingRecord = new MatchRecord("rating");
		ratingRecord.setWinCount(rating.getInt("winCount"));
		ratingRecord.setLoseCount(rating.getInt("loseCount"));
		ratingRecord.setStopCount(rating.getInt("stopCount"));

		playerInformation.setRating(ratingRecord);

		MatchRecord normalRecord = new MatchRecord("normal");
		normalRecord.setWinCount(normal.getInt("winCount"));
		normalRecord.setLoseCount(normal.getInt("loseCount"));
		normalRecord.setStopCount(normal.getInt("stopCount"));

		playerInformation.setNormal(normalRecord);
		
		return playerInformation;
	}
	
	
}
