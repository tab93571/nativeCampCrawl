package nativeCamp.nativeCamp;

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

    private static boolean mustUseCertainID = true;

    private static boolean mustInTeacherInformation = false;


    private static Integer certainID = TeacherInformation.JELENA.getTeacherID();

    private static long durationTime = 500l;

    private static String cookie = "_ga=GA1.2.1518765863.1622295376; _ts_yjad=1622295375837; __lt__cid=81f0e5cc-0ab3-44ca-8798-f71a0d19b24a; userInstagramModalAfterLesson_730511=no; change_filter=0; CakeCookie[em]=Q2FrZQ%3D%3D.XkfXaprKdWQ70vbEbYjzcMrX9MJ%2BUx8t%2BsofIssa%2Fcc%3D; rmStore5987=tmid:5987; dable_uid=17475158.1627477632961; _gcl_au=1.1.1181145002.1630143881; previous_pagi=1; previous_filter=reserved; viewMode=pc; CakeCookie[localizeDir]=Q2FrZQ%3D%3D.TGSLXYU%3D; _gid=GA1.2.1845043682.1637490557; _gat=1; UUNID=2a8o0ibu880fmfcuvn6ndi69r4; stc116386=env:1637490576%7C20211222102936%7C20211121105936%7C1%7C1059099:20221121102936|uid:1622337117410.161233026.69100332.116386.970109828.:20221121102936|srchist:1059100%3A1634910786%3A20211122135306%7C1059099%3A1634910812%3A20211122135332%7C1059100%3A1635515973%3A20211129135933%7C1059099%3A1635515987%3A20211129135947%7C1059100%3A1636201778%3A20211207122938%7C1059099%3A1636201790%3A20211207122950%7C1059100%3A1636811859%3A20211214135739%7C1059099%3A1636811892%3A20211214135812%7C1059100%3A1637490556%3A20211222102916%7C1059099%3A1637490576%3A20211222102936:20221121102936|nsc:1:20220530012039|tsa:0:20211121105936";





    private static  String user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36";




    //幾次後要再sendTG
    private static long sendTGDuration = 100;







    public static void main(String[] args) throws  InterruptedException {

        //key: teacherID  value:發的第幾次請求
        Map<Integer,Long>teacherIDTimesMap = new HashMap<>();


        HttpSendUtil httpSendUtil = new HttpSendUtil();

        Map<Integer,String> favouriteTeachersMap = TeacherInformation.getTeacherMap();

        long times =0;

        while (true) {
            long startTime=System.currentTimeMillis();
            try {

                String response = httpSendUtil.sendPOST(url,cookie,condition,user_agent);
                long gotResponseTime=System.currentTimeMillis();

                System.out.println("get response耗時："+(gotResponseTime-startTime)+"ms");
                if(null == response ){
                    continue;
                }
                Set<Integer>teacherIDSet = getTeacherIDSet(response);



                if(teacherIDSet != null && teacherIDSet.size()>0){

                    Integer teacherID = teacherSort(teacherIDSet,favouriteTeachersMap, mustUseCertainID);
                    if(null!= teacherID){

                        if(null == teacherIDTimesMap.get(teacherID) || (times - teacherIDTimesMap.get(teacherID)>sendTGDuration)){
                            TestTurnOnBrowser.turnOnTeacherPage(teacherID);
                            java.awt.Toolkit.getDefaultToolkit().beep();
//                            setTG(teacherURL+teacherID);
                            System.out.println("teacherID: "+teacherID+"   time:"+new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
                            java.awt.Toolkit.getDefaultToolkit().beep();
                            if(favouriteTeachersMap.keySet().contains(teacherID)){
                                break;
                            }

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

        if(teacherIDSet.contains(certainID))return certainID;

        //一定要用certainID
        if(mustUseCertainID)return null;

        //find from the favourite
        for(Integer id:favouriteTeacherSet){
            if(teacherIDSet.contains(id))return id;
        }

        //假如一定要在teacherInformation中的老師的話就不會往下跑了
        if(mustInTeacherInformation)return null;


        return teacherIDSet.iterator().next();
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
