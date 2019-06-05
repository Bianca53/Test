package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

/**
 * Create an implementation of a Rest API client.
 * Prints out how many records exists for each gender and save this file to s3 bucket
 * API endpoint=> https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda 
 * AWS s3 bucket => interview-digiage
 *
 */
public class TASK4 {
	static int genderF = 0;
	static int genderM = 0;
	static String keyFile = "\\\\InterviewFile\\\\interview-digiage-file.txt";
	static String pathFile = "C:\\Users\\T-Gamer\\Desktop\\InterviewFile\\interview-digiage-file.txt";
	
	public static void main(String[] args) {
		String text = calcGender();
		File file;
		try {
			file = createFile(text);
			uploadFile(file.getPath(), file.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static String calcGender() {
		String json = callURL("https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda");
		System.out.println("calculating genders...");
		try {
			JSONArray jsonArray = new JSONArray(json);

			for (int i=0; i <jsonArray.length();i++) {
			    JSONObject jsonObj = jsonArray.getJSONObject(i);
			    if (jsonObj.getString("gender").equals("F")) {
			    	genderF++;
			    } else {
			    	genderM++;
			    }
			}
			System.out.println("Total of each genders :  F=" + genderF + "  M=" + genderM);
			json = json + ">>>Total of each genders :  F=" + genderF + "  M=" + genderM+"<<<";			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return json;
	}
	
	//Open the Url connection to get the informations
	public static String callURL(String myURL) {
		System.out.println("Requested URL: " + myURL);
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			System.out.println("Opening Connection...");
			URL url = new URL(myURL);
			urlConn = url.openConnection();
				
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
			in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:" + myURL, e);
		}
 
		return sb.toString();
	}
	
	
	public static void uploadFile(String key, String file) {
		AWSCredentials credentials = null;
		System.out.println("Uploading file...");
	   	try { 
	   		credentials = new BasicAWSCredentials("AKIAJ6F7IUDUMYCYRMRQ","n571xwkoQaHBFOJN8CnezZ1npI457Cho4XICFxMJ");
	        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
	                      .withCredentials(new AWSStaticCredentialsProvider(credentials))
	                      .withRegion("us-west-2")
	                      .build();
	        s3.putObject(new PutObjectRequest("interview-digiage", keyFile, new File(pathFile)));
	       		 
	   	} catch (Exception e) {
	   		 System.out.println("Error Message:	" + e.getMessage());	 
	    } finally {
	    	System.out.println("File uploaded!");
	    }
	}
	
	
	private static File createFile(String text) throws IOException {
		System.out.println("Creating file...");
		File file = new File (pathFile);
		Writer writer = new OutputStreamWriter(new FileOutputStream(file));
		writer.write(text);
		writer.close();
		return file;
	}	
	
}