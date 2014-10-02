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
		Map<String, Object> data = new HashMap<String, Object>();

		for (Map.Entry<String, String> entry : Data.entrySet())
		{
			data.put(entry.getKey(), entry.getValue());
		}
		
		data.put("func", func);

		System.out.println("data1 -- "+data);
		String output = yaml.dump(Data);
		System.out.println("data2 -- "+output);
		return output;
	}
	
	public Map<String, Object> responceToDeviceInfo(String responce){
		return (Map<String, Object>) yaml.load(responce);
	}
}
