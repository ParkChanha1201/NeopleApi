package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import aktnf.neopleapi.WordType;
import aktnf.neopleapi.cyphers.CyphersApiRequester;
import aktnf.neopleapi.cyphers.GameTypeId;
import aktnf.neopleapi.cyphers.character.CyphersCharacterIds;
import aktnf.neopleapi.cyphers.character.CyphersCharacterName;
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

		String requestURL = cy.players().playerId("시계").wordType(WordType.MATCH).getRequestURL();
		System.out.println(requestURL);

		requestURL = cy.players().information("aabb1b8abd435a707aec8c995e6cfcb4").getRequestURL();
		System.out.println(requestURL);
		
		requestURL = cy.players().matchRecords("aabb1b8abd435a707aec8c995e6cfcb4").gameTypeId(GameTypeId.NORMAL)
				.next("6a48416bd03e7ec11f4b00fddce03b4bd383cc72a40cc52818f168f89897ffa566603d485d0161f1e8e86e14dddc9f7bb6a5ebaa7994822cd5777dcee5ae9ab2134f902a36a666401a9e7f5665d452aa")
				.getRequestURL();
		System.out.println(requestURL);
		
		requestURL = cy.matches().detail("7163c320af1276ad3bd7e0dbb0c9e848ae701389d61563ae4a761bad0f80e0e9")
				.getRequestURL();
		System.out.println(requestURL);

		requestURL = cy.ranking().ratingPoint("aabb1b8abd435a707aec8c995e6cfcb4")
				.limit(3)
				.offset(3)
				.getRequestURL();
		System.out.println(requestURL);

		System.out.println(CyphersCharacterName.로라스);
		String result = CyphersCharacterIds.getCharacterId(CyphersCharacterName.로라스);
		System.out.println(result);
		
		requestURL = cy.ranking().characters(CyphersCharacterName.미쉘, RankingType.EXP).getRequestURL();
		System.out.println(requestURL);
		
		requestURL = cy.ranking().tsj(TSJType.MELEE).getRequestURL();
		System.out.println(requestURL);
		
		requestURL = cy.battleitems().search("E").limit(30).wordType(WordType.FRONT).getRequestURL();
		System.out.println(requestURL);

		requestURL = cy.battleitems().detail("f8f751896a49b9ed96c0ed5ebd3ec417").getRequestURL();
		System.out.println(requestURL);

		requestURL = cy.characters().informations().getRequestURL();
		System.out.println(requestURL);

		requestURL = cy.positionAttributes().detail("cf0980305bec0524dede68b8160a6b45").getRequestURL();
		System.out.println(requestURL);

		
	}
}
