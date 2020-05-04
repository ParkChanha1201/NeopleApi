package neopleapi.apirequest;

import org.json.JSONObject;

public abstract class ApiRequestDecorator {
	public abstract String getRequestURL();
	/***
	 * 
	 * @return JSONObject that neople api server response from request URL
	 */
	public abstract JSONObject getRawData();
}
