package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public interface APIContact {
	
	static public String getDataFromAPI(String path)
	{
		try {
			URL url = new URL (path);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput (true);
			connection.setDoInput (true);
			connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");

			OutputStream os = connection.getOutputStream();
			//TODO: optionally, send something through the OutputStream to your servlet
			os.flush();
			os.close();
			   BufferedReader br = new BufferedReader(
					   new InputStreamReader(connection.getInputStream(),"UTF-8"));
				//TODO: retrieve your results.getInputStream()));
			   StringBuilder sb = new StringBuilder();
			   String line;
			   while ((line = br.readLine()) != null) {
			       sb.append(line+"\n");
			   }
			   return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
