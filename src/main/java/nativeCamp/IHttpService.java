package nativeCamp;

import retrofit2.http.*;
import rx.Observable;

import java.util.Map;

public interface IHttpService {

    @PUT
    @Headers("Content-Type:application/json")
    Observable<String> put(@Url String url, @Body String json);

    @GET
    Observable<String> query(@Url String url);

    /**
     * 對接鳳凰線上支付平台,Content-Type有些許差異須參考文件<br>
     * https://www.showdoc.cc/457099981375923?page_id=2666381443789018
     *
     * @param url
     * @param body
     * @return
     */
    @POST
    @FormUrlEncoded
    Observable<String> phPost(@Url String url, @FieldMap Map<String, String> body);



    @Headers({
            "Cookie: _ga=GA1.2.1518765863.1622295376; _gid=GA1.2.368324697.1622295376; _ts_yjad=1622295375837; __lt__cid=81f0e5cc-0ab3-44ca-8798-f71a0d19b24a; _gcl_au=1.1.1244101971.1622337117; _fbc=fb.1.1622337117638.IwAR32LrZ0BJmCbG0vtbU5KpHQ-QyDaGSCximIBGXFq2HQP2jm3oXFlddH96A; _fbp=fb.1.1622337117640.1245245735; userInstagramModalAfterLesson_730511=no; change_filter=0; previous_pagi=1; previous_filter=reserved; CakeCookie[em]=Q2FrZQ%3D%3D.XkfXaprKdWQ70vbEbYjzcMrX9MJ%2BUx8t%2BsofIssa%2Fcc%3D; viewMode=pc; rmStore5987=tmid:5987; CakeCookie[searchReserveData]=Q2FrZQ%3D%3D.TS7SQJ%2F4R3E8%2BeuyLuG6IZSX%2B6tsRhca8f9ELNlTup9CV%2BXSRPcD3rb9QFTSBhmuxGDbn06yoWPgbmOZ4ZNHv54CsWMvbtZLKcLG1%2FqEOsAi%2Fwd6BQGsftxZtpbT9ROxYuRXUAXucvxrJlz8X1VdovofCLSGDfidH3GrdHIO8ULmVKEBSOhXXmCC5oGSkeaG5BbvAg1a%2BO2p%2BDi8NGSUXkdyKyyZyi%2BWbuAW9H%2BLF5Vq7jXDxS%2BCGBftwlbJDJmBQE02sE4gqPcyhqL6I%2FnN4iomY8JsNj%2B6xCECOuEHDGur72LqjCKUPKc%2FiWRZEYwAsbdnLuQQpRKY; CakeCookie[currency_cookie]=Q2FrZQ%3D%3D.fFz%2F; changeSize=switch_middle; 14649.vst=%7B%22s%22%3A%2276d9a57d-a407-458d-bd7b-68c64653c186%22%2C%22t%22%3A%22new%22%2C%22lu%22%3A1624881018169%2C%22lv%22%3A1624881018169%2C%22lp%22%3A0%7D; CakeCookie[localizeDir]=Q2FrZQ%3D%3D.TGSLXYU%3D; searchTeacherForm[searchData]=%7B%22keywordText%22%3A%22%22%2C%22teacheNameText%22%3A%22%22%2C%22statusRadio%22%3A%22possible%22%2C%22genderRadio%22%3A%220%22%2C%22ageRadio%22%3A%220%22%2C%22sortRadio%22%3A%22evaluation_points%22%2C%22moreData%22%3A%22%22%2C%22limitData%22%3A%222%22%2C%22limitHistory%22%3A%22%22%2C%22limitCount%22%3A%22%22%2C%22badgeIds%22%3A%220%22%2C%22textbookRadioVal%22%3A%220%22%2C%22lesson5minRadio%22%3A%22show%22%2C%22coinSelectStart%22%3A%220%22%2C%22coinSelectEnd%22%3A%221000%22%2C%22localizeDir%22%3A%22zh-tw%22%7D; timezone_dialog_show=off; UUNID=jeb7lfu9lounr47t19qj2s9dbv; _gat=1; stc116386=env:1625041613%7C20210731082653%7C20210630090551%7C7%7C1059100:20220630083551|uid:1622337117410.161233026.69100332.116386.970109828.:20220630083551|srchist:1059099%3A1623852223%3A20210717140343%7C1059100%3A1624201196%3A20210721145956%7C1059099%3A1624230655%3A20210721231055%7C1059100%3A1624362613%3A20210723115013%7C1059099%3A1624362622%3A20210723115022%7C1059100%3A1624873361%3A20210729094241%7C1059099%3A1624881307%3A20210729115507%7C1059100%3A1625022303%3A20210731030503%7C1059099%3A1625022310%3A20210731030510%7C1059100%3A1625041613%3A20210731082653:20220630083551|nsc:1:20220530012039|tsa:1625041613787.161448604.89464998.6283513464303381.:20210630090551",
            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36"


    })
    @POST
    Observable<String> post(@Url String url, @Body String fields);

    @Headers({"Content-Type:application/json"})
    @POST
    Observable<String> gamingLoginPost(@Url String url, @Body String fields);

    @GET
    Observable<String> lotteryOpenGet(@Url String url, @Header("x-access-token") String token);

    @Headers("Content-Type:application/json")
    @POST
    Observable<String> standardPost(@Url String url, @Header("Authorization") String token, @Body String paramJson);

    @Headers("Content-Type:application/json")
    @PUT
    Observable<String> standardPut(@Url String url, @Header("Authorization") String token, @Body String paramJson);

}

