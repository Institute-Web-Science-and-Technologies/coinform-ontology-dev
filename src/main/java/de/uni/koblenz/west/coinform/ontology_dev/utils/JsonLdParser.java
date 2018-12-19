package de.uni.koblenz.west.coinform.ontology_dev.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonLdParser {

	public static List<Map> parse(String jsonldStr) {
		List<Map> jsonMapList = (List<Map>) new ArrayList();
		JSONArray jsonarray = new JSONArray(jsonldStr);
		for (int i = 0; i < jsonarray.length(); i++) {
			JSONObject jsonObj = jsonarray.getJSONObject(i);
			jsonMapList.add(jsonObj.toMap());
		}

		return jsonMapList;
	}

}
