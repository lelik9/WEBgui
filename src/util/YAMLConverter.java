package util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YAMLConverter
{
	private Yaml yaml  = new Yaml();
	
	public YAMLConverter() {
		yaml = new Yaml();
	}
	
	public String deviceToNameRequest(LinkedHashMap<String, String> Data, String func){
		Map<String, String> data = new HashMap<String, String>();

		data.put("func", func);
		for (Map.Entry<String, String> entry : Data.entrySet())
		{
			data.put(entry.getKey(), entry.getValue());
		}
		System.out.println(data);
		System.out.println(data.get("func"));
		String output = yaml.dump(data);
		return output;
	}
	
	public Map<String, Object> responceToDeviceInfo(String responce){
		return (Map<String, Object>) yaml.load(responce);
	}
}
