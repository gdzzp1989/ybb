package ybb.java;

import java.util.HashMap;
import java.util.Map;

public class MapOut {

	public static void main(String[] args) {
		Map<String, String> tempMap = new HashMap<String, String>();
		tempMap.put("a", "aa");
		tempMap.put("b", "bb");
		tempMap.put("c", "cc");

		for (Map.Entry<String, String> entry : tempMap.entrySet()) {
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			System.out.println("key=" + key + " value=" + value);
		}

	}

}
