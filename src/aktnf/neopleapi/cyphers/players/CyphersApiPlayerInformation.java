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
	/***
	 * getRawData()로부터 가공된 데이터를 가져옵니다
	 * @return playerId로 검색된 PlayerInformation
	 */
	public PlayerInformation getPlayerInformation() {
		PlayerInformation playerInformation = new PlayerInformation();

		JSONObject response = getRawData();
		
		Player player = new Player(response.getString("nickname"),response.getString("playerId"),response.getInt("grade"));
		playerInformation.setPlayer(player);
		
		// get player information
		playerInformation.setClanName(response.isNull("clanName") ? "" : response.getString("clanName"));
		
		// get Rating
		Rating rating = new Rating();
		rating.setMaxRatingPoint(response.isNull("maxRatingPoint") ? 0 : response.getInt("maxRatingPoint"));
		rating.setRatingPoint(response.isNull("ratingPoint") ? 0 : response.getInt("ratingPoint"));
		rating.setTierName(response.isNull("tierName") ? "" : response.getString("tierName"));
		playerInformation.setRating(rating);

		// get match records
		JSONArray records = response.getJSONArray("records");
		JSONObject jsonRating = records.getJSONObject(0);
		JSONObject jsonNormal = records.getJSONObject(1);

		Record ratingRecord = new Record("rating");
		ratingRecord.setWinCount(jsonRating.getInt("winCount"));
		ratingRecord.setLoseCount(jsonRating.getInt("loseCount"));
		ratingRecord.setStopCount(jsonRating.getInt("stopCount"));

		playerInformation.setRatingRecord(ratingRecord);

		Record normalRecord = new Record("normal");
		normalRecord.setWinCount(jsonNormal.getInt("winCount"));
		normalRecord.setLoseCount(jsonNormal.getInt("loseCount"));
		normalRecord.setStopCount(jsonNormal.getInt("stopCount"));

		playerInformation.setNormalRecord(normalRecord);
		
		return playerInformation;
	}
	
	
}
