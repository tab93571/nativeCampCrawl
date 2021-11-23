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

public class HttpUrlConnectionTest {


    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36";


    private static final String POST_URL = "https://nativecamp.net/user/api/getTeacherStatus";



//     private static final int[] POST_PARAMS = {39784,39063};

    private static final int statusBusy = 2;

    private static final String teacherURL = "https://nativecamp.net/zh-tw/waiting/detail/";

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static   Map<Integer,Integer> teacherStatusMap = new HashMap();

    private static final long durationTime = 5000l;

    /**
     * 1.將老師資訊放入enum中
     * 2.只通知一次
     * 3.做成api，並放在雲端，藉此操控該功能之開關
     * 4.做一個後台頁面來控制老師資訊、迴圈時間等等
     * 5.找出上課頁面(https://nativecamp.net/zh-tw/class/index/40185/40185-1625095185-681e43)後面一串加密東西的api
     *
     *
     * 用python模擬瀏覽器行為
     *
     * @param args
     * @throws IOException
     * @throws TelegramApiException
     * @throws InterruptedException
     */


    public static void main(String[] args) throws IOException, TelegramApiException, InterruptedException {

        Map<Integer,String> teacherMap = TeacherInformation.getTeacherMap();

        while (true) {

            try {
                sendPOST(teacherMap);
                Thread.sleep(durationTime);
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void setTG(String message) throws TelegramApiException, IOException {

        TgBotLNNAUtil tgBotLNNAUtil = new TgBotLNNAUtil();
        SendMessage sendMessage = new SendMessage(tgBotLNNAUtil.getChatId(), message);
        tgBotLNNAUtil.execute(sendMessage);
    }


    private static void sendPOST(Map<Integer,String> teacherMap) throws IOException, TelegramApiException {
        Set<Integer> idSet = teacherMap.keySet();
        for (int one : idSet) {
            URL obj = new URL(POST_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);

            con.setRequestProperty("Cookie", "_ga=GA1.2.1518765863.1622295376; _gid=GA1.2.368324697.1622295376; _ts_yjad=1622295375837; __lt__cid=81f0e5cc-0ab3-44ca-8798-f71a0d19b24a; _gcl_au=1.1.1244101971.1622337117; _fbc=fb.1.1622337117638.IwAR32LrZ0BJmCbG0vtbU5KpHQ-QyDaGSCximIBGXFq2HQP2jm3oXFlddH96A; _fbp=fb.1.1622337117640.1245245735; userInstagramModalAfterLesson_730511=no; change_filter=0; previous_filter=reserved; CakeCookie[em]=Q2FrZQ==.XkfXaprKdWQ70vbEbYjzcMrX9MJ+Ux8t+sofIssa/cc=; rmStore5987=tmid:5987; 14649.vst={\"s\":\"76d9a57d-a407-458d-bd7b-68c64653c186\",\"t\":\"new\",\"lu\":1624881018169,\"lv\":1624881018169,\"lp\":0}; searchTeacherForm[searchData]={\"keywordText\":\"\",\"teacheNameText\":\"\",\"statusRadio\":\"possible\",\"genderRadio\":\"0\",\"ageRadio\":\"0\",\"sortRadio\":\"evaluation_points\",\"moreData\":\"\",\"limitData\":\"2\",\"limitHistory\":\"\",\"limitCount\":\"\",\"badgeIds\":\"0\",\"textbookRadioVal\":\"0\",\"lesson5minRadio\":\"show\",\"coinSelectStart\":\"0\",\"coinSelectEnd\":\"1000\",\"localizeDir\":\"zh-tw\"}; timezone_dialog_show=off; viewMode=pc; CakeCookie[localizeDir]=Q2FrZQ==.TGSLXYU=; UUNID=bj32kdqgko872gdg891v82g6r1; stc116386=env:1625705423|20210808005023|20210708020838|35|1059099:20220708013838|uid:1622337117410.161233026.69100332.116386.970109828.:20220708013838|srchist:1059100:1624362613:20210723115013|1059099:1624362622:20210723115022|1059100:1624873361:20210729094241|1059099:1624881307:20210729115507|1059100:1625022303:20210731030503|1059099:1625022310:20210731030510|1059100:1625470098:20210805072818|1059099:1625470110:20210805072830|1059100:1625705408:20210808005008|1059099:1625705423:20210808005023:20220708013838|nsc:1:20220530012039|tsa:0:20210708020838");

            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");


            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(("teacherId=" + one).getBytes());
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

                // print result
                Map<String, String> responseMap = objectMapper.readValue(response.toString(), HashMap.class);

                String status = responseMap.get("status");
                System.out.println("id=" + one + " , status=" + status);

                if (Integer.valueOf(status).equals(statusBusy)) {

                    String  message = teacherURL+one;

                    if(statusBusy != (teacherStatusMap.get(one) == null? 0:teacherStatusMap.get(one))){
                        setTG(message);
                    }

                }
                teacherStatusMap.put(one,Integer.parseInt(status));


            } else {
                System.out.println("POST request not worked");
            }
        }
    }
}
