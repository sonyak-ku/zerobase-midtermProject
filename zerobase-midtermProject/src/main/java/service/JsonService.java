package service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dto.WifiDTO;

import java.util.ArrayList;
import java.util.List;

import org.json.*;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JsonService {
	
	public List<WifiDTO> parseJsonTOWifiDTO(String target) {
		JSONObject jsonObject = new JSONObject(target);
		JSONArray jArray = ((JSONObject) jsonObject.get("TbPublicWifiInfo")).getJSONArray("row");
		Gson gson = new GsonBuilder().create();
		List<WifiDTO> list = new ArrayList<>();
		
		for (int i = 0; i < jArray.length(); i++) {
			WifiDTO wifiDTO = gson.fromJson(jArray.getJSONObject(i).toString(), WifiDTO.class);
			list.add(wifiDTO);
		}
		return list;
	}
	
	public int getTotalCount(String target) {
		JSONObject jsonObject = new JSONObject(target);
		return (int)((JSONObject)jsonObject.get("TbPublicWifiInfo")).get("list_total_count");
	}
}



