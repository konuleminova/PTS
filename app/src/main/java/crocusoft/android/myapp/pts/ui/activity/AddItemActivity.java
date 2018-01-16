package crocusoft.android.myapp.pts.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.nio.channels.AcceptPendingException;

import crocusoft.android.myapp.pts.R;
import crocusoft.android.myapp.pts.network.ApiClient;
import crocusoft.android.myapp.pts.network.ApiInterface;
import crocusoft.android.myapp.pts.network.requests.GetTemplateRequest;
import crocusoft.android.myapp.pts.network.responses.FormInputs;
import crocusoft.android.myapp.pts.network.responses.getTemplateResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Asus on 1/16/2018.
 */

public class AddItemActivity extends Activity {
    LinearLayout parentLinearLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item_layout);
        parentLinearLayout = (LinearLayout) findViewById(R.id.parent_linear_layout);
        sendGetTitemData();

    }
    private void sendGetTitemData() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        GetTemplateRequest requestClass = new GetTemplateRequest();
        apiInterface.sendMessage(requestClass).enqueue(new Callback<getTemplateResponse>() {

            @Override
            public void onResponse(Call<getTemplateResponse> call, Response<getTemplateResponse> response) {
                //Toast.makeText(getActivity(), response.body().getTemplate().), Toast.LENGTH_LONG).show();
                if (response.body().getMessage().getId().equals("1000")) {
                    FormInputs[] formInputs = response.body().getTemplate().getFormInputs();
                    for (int i = 0; i < formInputs.length; i++) {
                        Log.e("template",formInputs[i].toString());
                        fillView(formInputs[i]);
                    }


                }
                else {
                    Log.e("Message",response.body().getMessage().getId());
                }
            }

            @Override
            public void onFailure(Call<getTemplateResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(), "system error", Toast.LENGTH_LONG).show();
            }
        });

    }


    private void fillView(FormInputs formInputs) {
        switch (formInputs.getTypeName()) {
            case "TEXT":
                addEditTextIntoVIew(formInputs);
                break;
        }


    }

    private void addEditTextIntoVIew(FormInputs formInputs) {

        // add edittext
        EditText et = new EditText(this);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        et.setLayoutParams(p);
        et.setText("Text");
        /// et.setId(numberOfLines + 1);
        parentLinearLayout.addView(et);
        Log.e("edit text","log");
        //numberOfLines++;
    }

}
