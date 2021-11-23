package nativeCamp.nativeCamp;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpSendUtil {

    public static void main(String[] args) {

    }

    public  String sendPOST(String url,String cookie,String searchCondition,String userAgent) throws IOException {

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", userAgent);
//            con.setRequestProperty("accept", "*/*");
//            con.setRequestProperty("connection", "keep-alive");

            con.setRequestProperty("Cookie",cookie);

            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");


            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write((searchCondition).getBytes());
            os.flush();
            os.close();


            int responseCode = con.getResponseCode();


            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

              return response.toString();

            } else {

                System.out.println("POST request not worked");
            }
            return null;

    }
}

