package crocusoft.android.myapp.pts.ui.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
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
import crocusoft.android.myapp.pts.network.responses.ArrayItems;
import crocusoft.android.myapp.pts.network.responses.FormInputs;
import crocusoft.android.myapp.pts.network.responses.getTemplateResponse;
import crocusoft.android.myapp.pts.ui.fragments.MainPageFragment;
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
        String s = formInputs.getPlaceholder();
        switch (formInputs.getTypeName()) {
            case "TEXT":

                addTextInputLayout(0, s);
                break;
            case "NUMBER":
                addTextInputLayout(1, s);
                break;
            case "DECIMAL":
                addTextInputLayout(2, s);
                break;
            case "PHONE":
                addTextInputLayout(3, s);
                break;
            case "CHECKBOX":
                addCheckBox(formInputs);
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

    private void addCheckBox(FormInputs formInputs) {

        for (int i = 0; i < formInputs.getArrayItems().length; i++) {
            CheckBox cb = new CheckBox(this);
            ArrayItems[] arrayItems = formInputs.getArrayItems();
            cb.setText(arrayItems[i].getValue());
            cb.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            cb.setId(i);
            cb.setTextColor(getResources().getColor(R.color.colorRed));
            parentLinearLayout.addView(cb);

        }

    }

    void addTextInputLayout(int id, String s) {
        super.setTheme(R.style.TextLabelRed);
        EditText editText = new EditText(this);
        editText.setTextColor(getResources().getColor(R.color.colorRed));
        editText.setHintTextColor(getResources().getColor(R.color.colorRed));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        editText.setLayoutParams(layoutParams);
        TextInputLayout textInputLayout = new TextInputLayout(this);
        textInputLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textInputLayout.addView(editText, layoutParams);

        textInputLayout.setHintTextAppearance(R.style.InputLayoutErrorHint);
        if (id == 0) {
            editText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
            textInputLayout.setHint(s);

        } else if (id == 1) {
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            textInputLayout.setHint(s);

        } else if (id == 2) {


            editText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
            textInputLayout.setHint(s);
        } else if (id == 3) {

            editText.setInputType(InputType.TYPE_CLASS_PHONE);
            textInputLayout.setHint(s);
        } else if (id == 4) {
            textInputLayout.setHint(s);
            editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }

        parentLinearLayout.addView(textInputLayout);
    }

}
