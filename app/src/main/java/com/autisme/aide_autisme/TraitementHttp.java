package com.autisme.aide_autisme;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class TraitementHttp {
    private String url;

    public TraitementHttp(String url){
        this.url = url;
    }
    public String execute(){
        String result = "";
        try {
            URL url;
            HttpsURLConnection urlConnection = null;
            try {
                url = new URL(this.url);
                urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.setConnectTimeout(3500);
                urlConnection.setReadTimeout(3500);
                try{
                    InputStream in = urlConnection.getInputStream();
                    InputStreamReader isw = new InputStreamReader(in);
                    int data =  isw.read();
                    while (data != -1){
                        result+=(char) data;
                        data = isw.read();
                    }
                    return result;
                }catch (Exception SocketTimeoutException){
                    result = "timeout";
                }

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(urlConnection!=null){
                    urlConnection.disconnect();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return "Exception:"+e.getMessage();
        }
        return result;
    }
}
