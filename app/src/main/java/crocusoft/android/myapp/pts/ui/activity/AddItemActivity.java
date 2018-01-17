package crocusoft.android.myapp.pts.ui.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.nio.channels.AcceptPendingException;
import java.util.ArrayList;

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
        parentLinearLayout.setPadding(10, 0, 0, 10);
        parentLinearLayout.setGravity(Gravity.CENTER);
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
                        Log.e("template", formInputs[i].toString());
                        fillView(formInputs[i]);

                    }


                } else {
                    Log.e("Message", response.body().getMessage().getId());
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
                // addCheckBox();
                break;
            case "CHECKBOX":
                addCheckBox();
                break;
            case "RADIOBUTTON":
                addradioButton();
                break;
            case "LIST":
                addList();
                break;
            case "PHOTO":
                addPhoto();


        }


    }

    private void addPhoto() {

        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearlayout.setOrientation(LinearLayout.VERTICAL);
       linearlayout.setGravity(Gravity.CENTER);
        ImageView i = new ImageView(this);
        i.setImageDrawable(getResources().getDrawable(R.drawable.images));
        i.setTranslationY(10);
        i.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearlayout.addView(i);
        LinearLayout linearlayoutinside = new LinearLayout(this);
        linearlayoutinside.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearlayoutinside.setOrientation(LinearLayout.HORIZONTAL);
        Button b = new Button(this);
        b.setText("TAKE A PHOTO");
        b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearlayoutinside.addView(b);
        linearlayoutinside.setTranslationY(10);
        linearlayoutinside.setGravity(Gravity.CENTER);
        linearlayout.setBackgroundColor(getResources().getColor(R.color.colorRed));

        Button b1 = new Button(this);
        b1.setText("FROM GALLERY");
        b1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearlayoutinside.addView(b1);
        linearlayout.addView(linearlayoutinside);
        parentLinearLayout.addView(linearlayout);

        // setContentView(linearlayout);
    }

    private void addList() {


        //RelativeLayout linearlayout = (RelativeLayout)findViewById(R.id.main_layout);

        ArrayList<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("one");
        spinnerArray.add("two");
        spinnerArray.add("three");
        spinnerArray.add("four");
        spinnerArray.add("five");

        Spinner spinner = new Spinner(this);
        spinner.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spinner.setAdapter(spinnerArrayAdapter);

        parentLinearLayout.addView(spinner);


    }

    private void addradioButton() {
        final RadioButton[] rb = new RadioButton[5];
        RadioGroup rg = new RadioGroup(this); //create the RadioGroup
        rg.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL
        for (int i = 0; i < 2; i++) {
            rb[i] = new RadioButton(this);
            rb[i].setText("Dynamic Radio Button " + i);
            rb[i].setId(i);
            rg.addView(rb[i]); //the RadioButtons are added to the radioGroup instead of the layout

        }
        parentLinearLayout.addView(rg);//you add the whole RadioGroup to the layout
    }

    private void addCheckBox() {

        for (int i = 0; i < 2; i++) {
            CheckBox cb = new CheckBox(this);
            cb.setText("Dynamic Checkbox " + i);
            cb.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            cb.setId(i);
          cb.setTextColor(getResources().getColor(R.color.colorRed));
            parentLinearLayout.addView(cb);

        }

    }

    private void addEditTextIntoVIew(FormInputs formInputs) {
        super.setTheme(R.style.TextLabelRed);
        // add edittext
        EditText et = new EditText(this);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        et.setLayoutParams(p);
        et.setHintTextColor(Color.RED);
        et.setHintTextColor(getResources().getColor(android.R.color.holo_red_dark));
        // Set the font size of the text that the user will enter
        et.setTextSize(16);
        // Set the color of the text inside the EditText field
       et.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        //et.setText("Text");
        //et.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
        et.setHint("Text");
        et.setHighlightColor(getResources().getColor(android.R.color.holo_blue_dark));
        et.setHighlightColor(getResources().getColor(android.R.color.holo_red_dark));


        parentLinearLayout.addView(et);
        Log.e("edit text", "log");
        Toast.makeText(getBaseContext(), "text input", Toast.LENGTH_LONG).show();

    }

}
