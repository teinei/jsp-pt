package br.com.translateita.result;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class Traducoes {

	private JSONObject jsonObj;

	private String jsonPath;

	public String retornaPalavraEmIngles(String palavaraEmPortugues) throws Exception {

		try {

			jsonObj = new JSONObject(configuraJson(jsonPath));

			if (jsonObj.has(palavaraEmPortugues)) {
				return jsonObj.getString(palavaraEmPortugues);
			} else {
				return "";
			}
		} catch (JSONException e) {
			return "";
		}
	}

	public String configuraJson(String file) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
		String line;

		try {
			while ((line = br.readLine()) != null) {
				sb = sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		br.close();
		return sb.toString();
	}

	public String getJsonPath() {
		return jsonPath;
	}

	public void setJsonPath(String jsonPath) {
		this.jsonPath = jsonPath;
	}
	
}
