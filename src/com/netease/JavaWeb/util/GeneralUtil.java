package com.netease.JavaWeb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

public class GeneralUtil {
	public static String generateId() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String getPropery(InputStream in,String key) {
		Properties props = new Properties();
		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = props.getProperty(key);
		return value;
	}
}
