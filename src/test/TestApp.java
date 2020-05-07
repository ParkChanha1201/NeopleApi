package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONObject;

import aktnf.neopleapi.WordType;
import aktnf.neopleapi.apirequest.ApiRequestDecorator;
import aktnf.neopleapi.cyphers.CyphersApiRequester;
import aktnf.neopleapi.cyphers.character.CyphersCharacterName;
import aktnf.neopleapi.cyphers.players.GameTypeId;
import aktnf.neopleapi.cyphers.players.Player;
import aktnf.neopleapi.cyphers.players.PlayerInformation;
import aktnf.neopleapi.cyphers.ranking.RankingType;
import aktnf.neopleapi.cyphers.ranking.TSJType;

public class TestApp {
	public static void main(String[] args) {
		String apikey;
		
		try {
			// read Apikey from file
			apikey = Files.readAllLines(Paths.get("E:\\\\syaro-dev\\cyphersApiKey")).get(0);
		} catch (IOException e) {
			// if file not exist
			apikey = "";
		}

		CyphersApiRequester cy = new CyphersApiRequester(apikey);

		String requestURL;
		ApiRequestDecorator request;
		
		request = cy.players().playerId("블레이즈킥").wordType(WordType.MATCH);
		requestURL = request.getRequestURL();
		JSONObject rawData = request.getRawData();
		System.out.println(rawData.toString());

		List<Player> players = cy.players().playerId("aaa").wordType(WordType.FULL).getPlayerList();
		for(Player player : players) {
			System.out.println(player.getGrade() + "\n" + player.getNickname()  + "\n" + player.getPlayerId() + "\n");
		}
		
		request = cy.players().information("d8b89beb4cc1cdff3f0dbd04fae1c74c");
		requestURL = request.getRequestURL();
		rawData = request.getRawData();
		System.out.println(rawData);

		PlayerInformation playerInformation = cy.players().information("aabb1b8abd435a707aec8c995e6cfcb4").getPlayerInformation();
		System.out.println(playerInformation);

		request = cy.players().matchRecords("2ce6f3c16ac508ee26284e421e57fef3").gameTypeId(GameTypeId.RATING);
		requestURL = request.getRequestURL();
		rawData = request.getRawData();
		System.out.println(rawData);
		
		request = cy.matches().detail("7163c320af1276ad3bd7e0dbb0c9e848ae701389d61563ae4a761bad0f80e0e9");
		requestURL = request.getRequestURL();
		rawData = request.getRawData();
		System.out.println(rawData);

		request = cy.ranking().ratingPoint("d8b89beb4cc1cdff3f0dbd04fae1c74c")
				.limit(3)
				.offset(3);
		requestURL = request.getRequestURL();
		rawData = request.getRawData();
		System.out.println(requestURL);
		
		request = cy.ranking().characters(CyphersCharacterName.미쉘, RankingType.EXP);
		requestURL = request.getRequestURL();
		rawData = request.getRawData();
		System.out.println(rawData);
		
		request = cy.ranking().tsj(TSJType.MELEE);
		requestURL = request.getRequestURL();
		rawData = request.getRawData();
		System.out.println(rawData);
		
		request = cy.battleitems().search("E").limit(30).wordType(WordType.FRONT);
		requestURL = request.getRequestURL();
		rawData = request.getRawData();
		System.out.println(rawData);

		request = cy.battleitems().detail("f8f751896a49b9ed96c0ed5ebd3ec417");
		requestURL = request.getRequestURL();
		rawData = request.getRawData();
		System.out.println(rawData);

		request = cy.characters().informations();
		requestURL = request.getRequestURL();
		rawData = request.getRawData();
		System.out.println(rawData);

		request = cy.positionAttributes().detail("cf0980305bec0524dede68b8160a6b45");
		requestURL = request.getRequestURL();
		rawData = request.getRawData();
		System.out.println(rawData);
	}
}
