# NeopleApi
[![NeopleOpenApi](/resources/logo_t1.png)](http://developers.neople.co.kr)

## 기능
1. Neople Developers에서 제공하는 Open Api를 이용하실 수 있습니다.
1. Open Api에서 제공하는 데이터를 JSONObject로 반환합니다. 현재는 JSONObject를 직접 파싱하셔서 사용하셔야 합니다.
1. 현재 사이퍼즈의 OpenApi만 사용가능합니다.

## 추가 예정 기능
Open Api에서 제공하는 데이터를 직접 JSON 파싱하지 않고도 사용하실 수 있게 만들 예정입니다.

## 사용방법
1. CyphersApiRequester 객체를 생성합니다.
```Java
  CyphersApiRequester cy = new CyphersApiRequester(apikey);
```
이 때 https://developers.neople.co.kr/main 에서 발급받은 apikey를 매개변수로 넘겨주셔야 합니다.

1. CyphersApiRequester를 사용해 원하는 Request를 생성합니다.
첫 줄까지는 필수 파라미터이므로 반드시 입력해야하고 그 아랫 줄은 선택 사항입니다.
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







