package org.example;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        System.out.println("Testing REST POST...");
        //Make REST API CALL WITH OkHTTP
        //String url = "http://localhost:8080/AddStock?id=1&ticker=MSFT&price=100&EPS=10&FCF=10&dividendPerShare=10&dividendRatio=10";

        //Make POST Call with HTTPClient Apache
        String url = "http://localhost:8080/AddStock";
        String urlParameters = "id=4&ticker=APPL&price=100&EPS=10&FCF=10&dividendPerShare=10&dividendRatio=10";
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        String request = url;
        URL URL = new URL(request);
        HttpURLConnection conn= (HttpURLConnection) URL.openConnection();
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        conn.setUseCaches(false);
        try(DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.write(postData);
        }
        System.out.println("Response Code: " + conn.getResponseCode());
        System.out.println("Response Message: " + conn.getResponseMessage());
        conn.disconnect();


    }
}
