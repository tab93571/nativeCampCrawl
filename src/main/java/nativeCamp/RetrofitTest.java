package nativeCamp;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;


public class RetrofitTest {

    public static void main(String[] args) {

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://nativecamp.net/user/api/getTeacherStatus/") // 设置网络请求的Url地址
//                .addConverterFactory(GsonConverterFactory.create()) // 设置数据解析器
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 支持RxJava平台
//                .build();
//
//        PostRequest_Interface request = retrofit.create(PostRequest_Interface.class);
//
//        //对 发送请求 进行封装(设置需要翻译的内容)
//        Call<Translation1> call = request.getCall("teacherId=39784");
//
//        //步骤6:发送网络请求(异步)
//        call.enqueue(new Callback<Translation1>() {
//
//            //请求成功时回调
//            @Override
//            public void onResponse(Call<Translation1> call, Response<Translation1> response) {
//                // 步骤7：处理返回的数据结果：输出翻译的内容
//                System.out.println(response);
//                System.out.println(response.body().getTranslateResult().get(0).get(0).getTgt());
//            }
//
//            //请求失败时回调
//            @Override
//            public void onFailure(Call<Translation1> call, Throwable throwable) {
//                System.out.println("请求失败");
//                System.out.println(throwable.getMessage());
//            }
//        });

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS)
                .build();

        IHttpService service = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
                .create(IHttpService.class);
        RequestSuccess<String> requestSuccess = new RequestSuccess<String>();
         service.post("https://nativecamp.net/user/api/getTeacherStatus","teacherId=39784").subscribe(requestSuccess);
        String response = requestSuccess.get();


    }
}
