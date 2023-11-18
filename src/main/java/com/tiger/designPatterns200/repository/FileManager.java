package com.tiger.designPatterns200.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author OMISTAJA
 *
 */
public class FileManager {
	/**
	 * @param inputStream
	 * @return
	 */
	public String streamToString(InputStream inputStream) {
		StringBuilder stringBuilder = new StringBuilder();
		try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
			String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error creating json "+inputStream.toString());
		}
		return stringBuilder.toString();
	}
	
	
}
