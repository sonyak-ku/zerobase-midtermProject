/* Java 1.8 샘플 코드 */
package service;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.IOException;


public class ApiExplorer {
	private static final String KEY = "48636d6f676b63683437774856534a";
	private static final String URL = "http://openapi.seoul.go.kr:8088";
	private static final String SERVICE = "TbPublicWifiInfo"; 
	public String type = "json";
	
	public ApiExplorer() {}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getApi(int f, int t){
		StringBuilder urlBuilder = new StringBuilder(URL); /*URL*/
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader rd = null;
		String apiString = "";
		String from = String.valueOf(f);
		String to = String.valueOf(t);
		
		try {
			urlBuilder.append("/" +  URLEncoder.encode(KEY,"UTF-8") );
			urlBuilder.append("/" +  URLEncoder.encode(type,"UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
			urlBuilder.append("/" + URLEncoder.encode(SERVICE,"UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
			urlBuilder.append("/" + URLEncoder.encode(from,"UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
			urlBuilder.append("/" + URLEncoder.encode(to,"UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
			
			url = new URL(urlBuilder.toString());
			conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/" + type);
			System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
			

			// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
					rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
					rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			apiString = rd.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				rd.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn.disconnect();
		}
		
		
		return apiString;
	}
	
}