package crocusoft.android.myapp.pts.ui.objects;

import android.app.Activity;
import android.app.Dialog;
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

    public void showDialog(Activity activity, String msg) {

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialoge);
        Button saveButton = (Button) dialog.findViewById(R.id.btn_dialog_save);
        EditText oldPassEdittext_tv = (EditText) dialog.findViewById(R.id.dialoge_alert_oldPass_text);
        EditText newPassEdittext_tv = (EditText) dialog.findViewById(R.id.dialoge_alert_newwPass_text);
        EditText confirmPassEdittext_tv = (EditText) dialog.findViewById(R.id.dialoge_alert_confirmPass_text);

        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Perfome Action
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}