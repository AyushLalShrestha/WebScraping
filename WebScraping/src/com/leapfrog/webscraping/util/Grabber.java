package com.leapfrog.webscraping.util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Grabber {
    public static String get(String link) {
        try {
            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder content = new StringBuilder();
            String line = "";
            while((line = reader.readLine()) != null) {
            content.append(line);
            }
            return content.toString();
            
        } catch(IOException ex) {
            return ex.getMessage();
        }
        
      }
            
    public static void downloadImage(String link, String data) {
        try {
            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            FileOutputStream os = new FileOutputStream(data+".jpg");
            InputStream is = conn.getInputStream();
            byte[] byt = new byte[1024];
            int i = 0;
            while ((i = is.read(byt)) != -1) {
                os.write(byt, 0, i);

            }
            os.close();
            is.close();
            //System.out.println("File has been downloaded");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }
    
    

}
