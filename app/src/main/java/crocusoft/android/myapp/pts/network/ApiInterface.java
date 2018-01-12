package crocusoft.android.myapp.pts.network;

import crocusoft.android.myapp.pts.network.requests.ForgotPasswordRequestClass;
import crocusoft.android.myapp.pts.network.requests.LoginRequestClass;
import crocusoft.android.myapp.pts.network.responses.ForgotPassResponseClass;
import crocusoft.android.myapp.pts.network.responses.LoginResponseClass;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Asus on 1/10/2018.
 */

public interface ApiInterface {
    @Headers({
            "ptsheader: {\"transactionId\":null,\"apiKey\":\"dsakDH6436824HQKE\",\"os\":\"IOS\",\"appVersion\":\"1.0.0\" }",
            "Content-Type: application/json"
    })
    @POST("login")
    Call<LoginResponseClass> sendMessage(@Body LoginRequestClass requestClass);
    @Headers({
            "ptsheader: {\"transactionId\":123456789,\"apiKey\":\"dsakDH6436824HQKE\",\"os\":\"IOS\",\"appVersion\":\"1.0.0\" }",
            "Content-Type: application/json"
    })
    @POST("forgetPassword")
    Call<ForgotPassResponseClass> sendMessage(@Body ForgotPasswordRequestClass requestClass);

}
