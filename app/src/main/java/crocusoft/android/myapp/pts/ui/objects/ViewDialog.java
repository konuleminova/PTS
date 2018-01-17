package crocusoft.android.myapp.pts.ui.objects;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import crocusoft.android.myapp.pts.R;

/**
 * Created by Asus on 1/13/2018.
 */

public class ViewDialog {
    TextInputLayout oldPassEdittext_tv, newPassEdittext_tv, confirmPassEdittext_tv;
    EditText oldPassEdittext_et, newPassEdittext_et, confirmPassEdittext_et;

    public void showDialog(Activity activity, int id) {

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialoge);
        Button saveButton = (Button) dialog.findViewById(R.id.btn_dialog_save);
        oldPassEdittext_tv = (TextInputLayout) dialog.findViewById(R.id.dialoge_alert_oldPass_text);
        newPassEdittext_tv = (TextInputLayout) dialog.findViewById(R.id.dialoge_alert_newPass_text);
        confirmPassEdittext_tv = (TextInputLayout) dialog.findViewById(R.id.dialoge_alert_confirmPass_text);
        oldPassEdittext_et = (EditText) dialog.findViewById(R.id.oldPass_Edittext);
        newPassEdittext_et = (EditText) dialog.findViewById(R.id.newPass_editText);
        confirmPassEdittext_et = (EditText) dialog.findViewById(R.id.confirmPass_editText);

        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Perfome Action
                dialog.dismiss();
            }
        });

        dialog.show();
        setDialogView(id, null);

    }

    public int setDialogView(int id, Bundle bundle) {
        if (id == 0) {
            newPassEdittext_tv.setVisibility(View.GONE);
            confirmPassEdittext_tv.setVisibility(View.GONE);
            oldPassEdittext_tv.setHint("Name");
        } else if (id == 1) {
            newPassEdittext_tv.setVisibility(View.GONE);
            confirmPassEdittext_tv.setVisibility(View.GONE);
            oldPassEdittext_tv.setHint("Surname");
        } else if (id == 2) {
            newPassEdittext_tv.setVisibility(View.GONE);
            confirmPassEdittext_tv.setVisibility(View.GONE);
            oldPassEdittext_tv.setHint("Email");
            oldPassEdittext_et.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        } else if (id == 3) {
            newPassEdittext_tv.setVisibility(View.GONE);
            confirmPassEdittext_tv.setVisibility(View.GONE);
            oldPassEdittext_tv.setHint("Phone Number");
            oldPassEdittext_et.setInputType(InputType.TYPE_CLASS_PHONE);
        } else if (id == 4) {
            oldPassEdittext_tv.setHint("Password");
            oldPassEdittext_et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            oldPassEdittext_et.setTransformationMethod(PasswordTransformationMethod.getInstance());
            newPassEdittext_et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            newPassEdittext_et.setTransformationMethod(PasswordTransformationMethod.getInstance());
            confirmPassEdittext_et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            confirmPassEdittext_et.setTransformationMethod(PasswordTransformationMethod.getInstance());


        }
        return id;
    }
}
