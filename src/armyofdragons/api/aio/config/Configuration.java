package armyofdragons.api.aio.config;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Configuration {

	private HashMap<String, Object> configurationKey;
	
	public Configuration(File file) {
		
		this.configurationKey = new HashMap<String, Object>();
		
		if(!file.exists()) {
			try{
				file.createNewFile();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
	
	public String getString(String key) {
		return (String) configurationKey.get(key);
	}
}
