# NeopleApi
[![NeopleOpenApi](/resources/logo_t1.png)](http://developers.neople.co.kr)

## 다운로드
http://blogattach.naver.net/881d9420360302b49272132d16f78af35708fd72/20200508_243_blogfile/chanhacraft_1588869805271_t7820y_jar/neopleApi-1.0.0.jar

## 필수 라이브러리
https://repo1.maven.org/maven2/org/json/json/20190722/json-20190722.jar

## 기능
1. Neople Developers에서 제공하는 Open Api를 이용하실 수 있습니다.
1. Open Api에서 제공하는 데이터를 JSONObject로 반환합니다. 현재는 JSONObject를 직접 파싱하셔서 사용하셔야 합니다.
1. 현재 사이퍼즈의 OpenApi만 사용가능합니다.

## 추가 예정 기능
1. Open Api에서 제공하는 데이터를 직접 JSON 파싱하지 않고도 사용하실 수 있게 구현할 예정입니다.
1. 이미지를 가져오는 Api 메서드를 구현할 예정입니다.

## 사용방법
1. CyphersApiRequester 객체를 생성합니다.
```Java
  CyphersApiRequester cy = new CyphersApiRequester(apikey);
```
  이 때 https://developers.neople.co.kr/main 에서 발급받은 apikey를 매개변수로 넘겨주셔야 합니다.

2. CyphersApiRequester를 사용해 원하는 ApiRequestDecorator를 생성합니다.

각 메서드들은 ApiRequestDecorator를 반환합니다.</br>
첫 줄까지는 필수 파라미터이므로 반드시 입력해야하고 그 아랫 줄은 선택 사항입니다.</br>
파라미터에 대한 설명은 https://developers.neople.co.kr/contents/apiDocs/cyphers 에서 확인해주세요
* players
  * playerId
    ```Java
      cy.players().playerId("NICKNAME")
      .wordType(WordType).limit(1);
    ```
  * information
    ```Java
      cy.players().information("PLAYER_ID");
    ```
  * matchRecords
    ```Java
      cy.players().matchRecords("PLAYER_ID")
      .gameTypeId(GameTypeId).startDate(Date).endDate(Date).limit(1).next("NEXT_CODE");
    ```
* matches
  * detail
    ```Java
      cy.matches().detail("MATCH_ID");
    ```
* ranking
    * ratingPoint
    ```Java
      cy.ranking().ratingPoint("PLAYER_ID")
      .offset(1).limit(1);
    ```
    * characters
    ```Java
      cy.ranking().characters(CyphersCharacterName, RankingType)
      .playerId("PLAYER_ID").offset(1).limit(1);
    ```
    * tsj
    ```Java
      cy.ranking().tsj(TSJType)
      .playerId("PLAYER_ID").offset(1).limit(1);
    ```
* battleitems
  * search
    ```Java
      cy.battleitems().search("ITEM_NAME")
      .limit(1).wordType(WordType)
      .characterId("CHARACTER_ID").slotCode("SLOTCODE").rarityCode("RARITYCODE").seasonCode("SEASONCODE");
    ```
  * detail
    ```Java
      cy.battleitems().detail("ITEM_ID");
    ```
  * multi
    ```Java
      cy.battleitems().multi(List<String> ITEM_IDS)
    ```
* characters
    * information
    ```Java
      cy.characters().information();
    ```
* positionAttributes
    * detail
    ```Java
      cy.positionAttributes().detail("ATTRIBUTE_ID");
    ```

3. 반환받은 ApiRequestDecorator를 이용해 데이터를 요청합니다.

ApiRequestDecorator는 다음과 같은 메서드를 가지고 있습니다.
```Java
public abstract class ApiRequestDecorator {
	public abstract String getRequestURL();
	public final JSONObject getRawData();	
}
```
getRequestURL()은 Api요청을 보내는 URL을 반환합니다.</br>
getRawData()는 getRequestURL()로 부터 얻은 URL으로 요청을 보내 응답을 JSONObject로 반환합니다.

* Example
```Java
  ApiRequestDecorator request;
  
  request = cy.ranking().characters(CyphersCharacterName.미쉘, RankingType.EXP);
  String requestURL = request.getRequestURL();
  JSONObject rawData = request.getRawData();
```
* 실행 결과
```
requestURL: https://api.neople.co.kr/cy/ranking/characters/47a1b002f3c601f37cdca060b94a0141/exp?&apikey=XXXXXXXXXXXXXXXXXXXXXX

rawData:
{
"rows":[
{"nickname":"야미쉘","rank":1,"exp":2178230,"playerId":"8d5c79357fa69be6f4927deba781b194"},
{"nickname":"가리워진꿈","rank":2,"exp":1964450,"playerId":"33658f99124fe3e8d09a2c1ec7f7b746"},
{"nickname":"다다모","rank":3,"exp":1783647,"playerId":"d297c373990235db83e0d459006fc037"},
{"nickname":"ㅿ루펠루스ㅿ","rank":4,"exp":1724254,"playerId":"3c0b374e9ce31d05e309dbb48cdf6909"},
{"nickname":"개졑","rank":5,"exp":1703679,"playerId":"d93ffcab7435e2d1a4914cb534d06759"},
{"nickname":"비요소","rank":6,"exp":1366944,"playerId":"ac51e04ad61bb4f8926fe99289ab95a2"},
{"nickname":"유리테","rank":7,"exp":1212854,"playerId":"cc4c9df58e3547dbc0a848960180519f"},
{"nickname":"리운댕","rank":8,"exp":1157131,"playerId":"2798f66defd3d34ba0e61803ac8aed35"},
{"nickname":"레몬라임맛미쉘","rank":9,"exp":1112988,"playerId":"22e64ab00840a384d1c85d751898b447"},
{"nickname":"미나즈키루이","rank":10,"exp":1095983,"playerId":"64ee26875e9142e6ac1642fc2f8f66e0"}
]
}
```
## 궁금한 점 및 버그
궁금한 점 있으시거나 버그를 발견하시면
aktnf1201@naver.com으로 이메일 보내주세요
