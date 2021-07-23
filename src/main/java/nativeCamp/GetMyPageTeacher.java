package nativeCamp;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GetMyPageTeacher {


    private static String conditionMyCollection = "keywordText=&teacheNameText=&statusRadio=possible&genderRadio=0&ageRadio=0&sortRadio=evaluation_points&moreData=&limitData=2&limitHistory=&limitCount=&badgeIds=preset&searchFavorite=on&textbookRadioVal=3&lesson5minRadio=show&coinSelectStart=0&coinSelectEnd=1000&localizeDir=zh-tw";
    private static String conditionNativeSpeaker = "keywordText=&teacheNameText=&statusRadio=possible&genderRadio=0&ageRadio=0&sortRadio=evaluation_points&moreData=&limitData=2&limitHistory=&limitCount=&badgeIds=preset&teacherFeature%5B%5D=native&textbookRadioVal=3&lesson5minRadio=show&coinSelectStart=0&coinSelectEnd=1000&localizeDir=zh-tw";

    private static TgBotLNNAUtil tgBotLNNAUtil = new TgBotLNNAUtil();

    private static final String url ="https://nativecamp.net/user/MyPage/onlineTeachers/mypage";



    private static final String teacherURL = "https://nativecamp.net/zh-tw/waiting/detail/";


    //variable

    private static String  condition =conditionMyCollection;

    private static boolean mustUseCertainID = false;


    private static Integer certainID = TeacherInformation.JELENA.getTeacherID();

    private static long durationTime = 900l;

    private static String cookie = "_ga=GA1.2.1518765863.1622295376; _gid=GA1.2.368324697.1622295376; _ts_yjad=1622295375837; __lt__cid=81f0e5cc-0ab3-44ca-8798-f71a0d19b24a; _gcl_au=1.1.1244101971.1622337117; _fbc=fb.1.1622337117638.IwAR32LrZ0BJmCbG0vtbU5KpHQ-QyDaGSCximIBGXFq2HQP2jm3oXFlddH96A; _fbp=fb.1.1622337117640.1245245735; userInstagramModalAfterLesson_730511=no; change_filter=0; previous_filter=reserved; CakeCookie[em]=Q2FrZQ%3D%3D.XkfXaprKdWQ70vbEbYjzcMrX9MJ%2BUx8t%2BsofIssa%2Fcc%3D; rmStore5987=tmid:5987; 14649.vst=%7B%22s%22%3A%2276d9a57d-a407-458d-bd7b-68c64653c186%22%2C%22t%22%3A%22new%22%2C%22lu%22%3A1624881018169%2C%22lv%22%3A1624881018169%2C%22lp%22%3A0%7D; viewMode=pc; CakeCookie[localizeDir]=Q2FrZQ%3D%3D.TGSLXYU%3D; timezone_dialog_show=off; searchTeacherForm[searchData]=%7B%22keywordText%22%3A%22%22%2C%22teacheNameText%22%3A%22%22%2C%22statusRadio%22%3A%22possible%22%2C%22genderRadio%22%3A%220%22%2C%22ageRadio%22%3A%220%22%2C%22sortRadio%22%3A%22evaluation_points%22%2C%22moreData%22%3A%22%22%2C%22limitData%22%3A%222%22%2C%22limitHistory%22%3A%22%22%2C%22limitCount%22%3A%22%22%2C%22badgeIds%22%3A%22preset%22%2C%22searchFavorite%22%3A%22on%22%2C%22textbookRadioVal%22%3A%223%22%2C%22lesson5minRadio%22%3A%22show%22%2C%22coinSelectStart%22%3A%220%22%2C%22coinSelectEnd%22%3A%221000%22%2C%22localizeDir%22%3A%22zh-tw%22%7D; CakeCookie[currency_cookie]=Q2FrZQ%3D%3D.fFz%2F; _gat=1; UUNID=v5omjq2qf4ebcrtou8bunt30bu; stc116386=env:1627043141%7C20210823122541%7C20210723130028%7C8%7C1059099:20220723123028|uid:1622337117410.161233026.69100332.116386.970109828.:20220723123028|srchist:1059100%3A1625921725%3A20210810125525%7C1059099%3A1625922865%3A20210810131425%7C1059100%3A1626396795%3A20210816005315%7C1059099%3A1626396808%3A20210816005328%7C1059100%3A1627018911%3A20210823054151%7C1059099%3A1627018922%3A20210823054202%7C1059100%3A1627024925%3A20210823072205%7C1059099%3A1627025622%3A20210823073342%7C1059100%3A1627042506%3A20210823121506%7C1059099%3A1627043141%3A20210823122541:20220723123028|nsc:1:20220530012039|tsa:0:20210723130028";

    //幾次後要再sendTG
    private static long sendTGDuration = 100;







    public static void main(String[] args) throws  InterruptedException {

        //key: teacherID  value:發的第幾次請求
        Map<Integer,Long>teacherIDTimesMap = new HashMap<>();


        HttpSendUtil httpSendUtil = new HttpSendUtil();

        Map<Integer,String> teacherMap = TeacherInformation.getTeacherMap();

        long times =0;

        while (true) {
            long startTime=System.currentTimeMillis();
            try {

                String response = httpSendUtil.sendPOST(url,cookie,condition);
                long gotResponseTime=System.currentTimeMillis();

                System.out.println("get response耗時："+(gotResponseTime-startTime)+"ms");
                if(null == response ){
                    continue;
                }
                Set<Integer>teacherIDSet = getTeacherIDSet(response);



                if(teacherIDSet != null && teacherIDSet.size()>0){

                    Integer teacherID = teacherSort(teacherIDSet,teacherMap, mustUseCertainID);
                    if(null!= teacherID){

                        if(null == teacherIDTimesMap.get(teacherID) || (times - teacherIDTimesMap.get(teacherID)>sendTGDuration)){
                            TestTurnOnBrowser.turnOnTeacherPage(teacherID);
                            java.awt.Toolkit.getDefaultToolkit().beep();
//                            setTG(teacherURL+teacherID);
                            System.out.println("teacherID: "+teacherID+"   time:"+new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));

                            teacherIDTimesMap.put(teacherID,times);}
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            long finishLoopTimeBeforeSleep=System.currentTimeMillis();
            long executingTime = finishLoopTimeBeforeSleep-startTime;
            long randomNum = (long)(Math.random()*50);
            long sleepTime =durationTime-executingTime>=0?durationTime-executingTime:100l;
            Thread.sleep(sleepTime+randomNum);
            long finishOneLoopTimeAfterSleep=System.currentTimeMillis();
            System.out.println("一次迴圈時間："+(finishOneLoopTimeAfterSleep-startTime)+"ms");


            times++;
        }

    }

    private static Integer teacherSort(Set<Integer>teacherIDSet,Map<Integer,String> teacherMap,Boolean mustUseCertainID){
        Set<Integer>favouriteTeacherSet = teacherMap.keySet();

        if(teacherIDSet.contains(certainID)){ 
            return certainID; 
        }else{
            //一定要用certainID
            if(mustUseCertainID){
                return null;
            }
        }

        //find from the favourite
        for(Integer id:favouriteTeacherSet){
            if(teacherIDSet.contains(id)){
                return id;
            }
        }
        //find the first
        for(Integer id:teacherIDSet){
            return id;
        }

        return null;
    }

    private static void setTG(String message) throws TelegramApiException {

        SendMessage sendMessage = new SendMessage(tgBotLNNAUtil.getChatId(), message);
        tgBotLNNAUtil.execute(sendMessage);
    }

    public static Set<Integer> getTeacherIDSet(String response){

        Set<Integer> teacherIDSet = new HashSet();
        String[]array= response.split("https://nativecamp.net/zh-tw/waiting/detail/");

        if(null == array || array.length==0){
            return null;
        }

        for(int i=1;i< array.length;i+=2){
            String id;
            Integer idInt;
            try{
             id= array[i].substring(0,5);
             idInt = Integer.parseInt(id);
            }catch(Exception e){
                try{
                id= array[i].substring(0,4);
                idInt = Integer.parseInt(id);
                } catch(Exception ex){
                    try{
                    id= array[i].substring(0,3);
                    idInt = Integer.parseInt(id);}
                    catch(Exception ee){
                        id= array[i].substring(0,2);
                        idInt = Integer.parseInt(id);

                    }
                }
            }
            teacherIDSet.add(idInt);
            }

        return teacherIDSet;
    }

}
