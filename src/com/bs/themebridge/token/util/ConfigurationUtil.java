package com.bs.themebridge.token.util;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.adapter.BridgepropertiesAdapter;
import com.bs.themebridge.entity.model.Bridgeproperties;

public class ConfigurationUtil {

	private final static Logger logger = Logger.getLogger(ConfigurationUtil.class);

	public static String getValueFromKey(String key) {

		// logger.debug("Bridge Property : Key : " + key);
		String result = "";
		LinkedHashMap<String, String> configMap = new LinkedHashMap<String, String>();
		BridgepropertiesAdapter aBridgepropertiesAdapter = new BridgepropertiesAdapter();
		List<Bridgeproperties> aPropertyList = aBridgepropertiesAdapter.getAllProperties();

		for (Bridgeproperties aBridgeproperties : aPropertyList) {
			configMap.put(aBridgeproperties.getKey(), aBridgeproperties.getValue());
		}

		result = configMap.get(key);
		// logger.debug("Bridge Property key : " + key + " >>> Value : " +
		// result);
		return result;
	}

	public static void main(String args[]) {

//		 logger.debug(getValueFromKey("BootstrapUrl"));
		//logger.debug(ThemeBridgeLookupUtil.getKeyNameValueFromProperty("BootstrapUrl"));
		logger.debug(getValueFromKey("TibcoTreasuryHttpClientUrl"));
	}

}
