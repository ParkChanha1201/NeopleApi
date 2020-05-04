package neopleapi.cyphers.character;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class CyphersCharacterIds {
	private static Map<String, String> characterIds;
	
	static {
		characterIds = new HashMap<String, String>();
		
		File cyphersCharacters = new File("./resources/cyphersCharacters.json");
		BufferedReader in;
		
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(cyphersCharacters),"UTF-8"));
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = in.readLine()) != null) {
				sb.append(line);
			}

			in.close();
			
			JSONObject jsonObject = new JSONObject(sb.toString());
			JSONArray rows = jsonObject.getJSONArray("rows");
			
			int length = rows.length();
			
			for(int i = 0; i < length; i++) {
				JSONObject character = rows.getJSONObject(i);
				String characterId = character.getString("characterId");
				String characterName = character.getString("characterName");
				
				characterIds.put(characterName, characterId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getCharacterId(CyphersCharacterName characterName) {
		return characterIds.get(characterName.toString());
	}
}
