package aktnf.neopleapi.apirequest;

import java.io.IOException;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

import aktnf.util.HttpRequester;

public abstract class ApiRequestDecorator {
	public abstract String getRequestURL();

	/***
	 * @return JSONObject that neople api server response from request URL
	 */
	public final JSONObject getRawData() {
		String requestURL = getRequestURL();

		try {
			HttpsURLConnection connection = (HttpsURLConnection) HttpRequester.openConnection(requestURL);

			String response = HttpRequester.getResponseData(connection);

			JSONObject jsonObject = new JSONObject(response);

			return jsonObject;
		} catch (IOException e) {
			return null;
		}
	}
}
