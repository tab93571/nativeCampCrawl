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

    private static boolean mustUseCertainID = true;

    private static boolean mustInTeacherInformation = false;


    private static Integer certainID = TeacherInformation.JELENA.getTeacherID();

    private static long durationTime = 500l;

    private static String cookie = "_ga=GA1.2.1518765863.1622295376; _ts_yjad=1622295375837; __lt__cid=81f0e5cc-0ab3-44ca-8798-f71a0d19b24a; userInstagramModalAfterLesson_730511=no; change_filter=0; CakeCookie[em]=Q2FrZQ%3D%3D.XkfXaprKdWQ70vbEbYjzcMrX9MJ%2BUx8t%2BsofIssa%2Fcc%3D; rmStore5987=tmid:5987; dable_uid=17475158.1627477632961; previous_filter=reserved; _gcl_au=1.1.1418435093.1637924805; previous_pagi=1; viewMode=pc; CakeCookie[localizeDir]=Q2FrZQ%3D%3D.TGSLXYU%3D; _gid=GA1.2.939096027.1642319393; UUNID=q4ejrcp2fvnc2ov6kgcoo4is84; timezone_dialog_show=off; searchTeacherForm[searchData]=%7B%22keywordText%22%3A%22%22%2C%22teacheNameText%22%3A%22%22%2C%22statusRadio%22%3A%22possible%22%2C%22genderRadio%22%3A%220%22%2C%22sortRadio%22%3A%22status%22%2C%22moreData%22%3A%22%22%2C%22limitData%22%3A%222%22%2C%22limitHistory%22%3A%22%22%2C%22limitCount%22%3A%22%22%2C%22badgeIds%22%3A%220%22%2C%22textbookRadioVal%22%3A%220%22%2C%22lesson5minRadio%22%3A%22show%22%2C%22coinSelectStart%22%3A%220%22%2C%22coinSelectEnd%22%3A%221000%22%2C%22localizeDir%22%3A%22zh-tw%22%7D; stc116386=env:1642326466%7C20220216094746%7C20220116101746%7C1%7C1059100:20230116094746|uid:1622337117410.161233026.69100332.116386.970109828.:20230116094746|srchist:1059099%3A1639905134%3A20220119091214%7C1059100%3A1640521304%3A20220126122144%7C1059099%3A1640521314%3A20220126122154%7C1059100%3A1641417980%3A20220205212620%7C1059099%3A1641417996%3A20220205212636%7C1059100%3A1641638478%3A20220208104118%7C1059099%3A1641638495%3A20220208104135%7C1059100%3A1642319393%3A20220216074953%7C1059099%3A1642319411%3A20220216075011%7C1059100%3A1642326466%3A20220216094746:20230116094746|nsc:1:20220530012039|tsa:1642326466158.741000070.9187059.4263177702777119.7:20220116101746; _gat=1";









    private static  String user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36";

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
                Set<Integer>teacherIDSet = getTeacherIDSet(response,condition);



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

    public static Set<Integer> getTeacherIDSet(String response,String condition){


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

        //若是母語師太廢就不上了，反正母語師也只抓第一個，所以就看第一個的評價就可以了

        if(condition.equals(conditionNativeSpeaker) && !teacherIDSet.isEmpty()){

            String[]pointArray = response.split("\"ユーザー評価\">");

            String pointString = pointArray[1].substring(0,4);
            Double point = Double.parseDouble(pointString);

            if(point <4.87){
                return null;
            }

        }

        return teacherIDSet;
    }

}
