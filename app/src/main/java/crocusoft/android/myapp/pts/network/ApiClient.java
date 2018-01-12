package crocusoft.android.myapp.pts.network;

import android.widget.BaseAdapter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Asus on 1/10/2018.
 */

public class ApiClient {
    private static Retrofit retrofit=null;
    public static final String BASE_URL="http://139.59.210.18:8080/pts/api/";
    public static Retrofit getClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
