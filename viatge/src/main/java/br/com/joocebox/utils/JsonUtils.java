package br.com.joocebox.utils;

import br.com.joocebox.model.FileMeta;
import br.com.joocebox.model.ImageJson;

import com.google.gson.Gson;

public class JsonUtils {
	ImageJson pathJson = null;
	
	public void generateJson(FileMeta fileMeta) {
		pathJson = new ImageJson();
		pathJson.setJson(new Gson().toJson(fileMeta));
	}
}
