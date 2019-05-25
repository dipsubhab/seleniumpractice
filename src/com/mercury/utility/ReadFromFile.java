package com.mercury.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFromFile {

	public void readFromFile(String properties) throws IOException{
		
		File file = new File("./Testdata/testdata.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		
		
		
	}
}
