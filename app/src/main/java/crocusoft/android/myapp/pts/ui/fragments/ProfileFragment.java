package crocusoft.android.myapp.pts.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import crocusoft.android.myapp.pts.R;
import crocusoft.android.myapp.pts.ui.objects.ViewDialog;

/**
 * Created by Asus on 12/24/2017.
 */

public class ProfileFragment extends Fragment {
    EditText usernameEditText, emilEditext;
    LinearLayout t;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.profile_normal_mod_layout, container, false);
        final View views = getActivity().findViewById(R.id.design_bottom_sheet);
        t = (LinearLayout) view.findViewById(R.id.text_containerLayout);

        final ScrollView scrollView = (ScrollView) view.findViewById(R.id.scrollView);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST);
        usernameEditText = (EditText) view.findViewById(R.id.surnameEdittext);
        usernameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    // your action here


                    //scrollView.fullScroll(ScrollView.FOCUS_UP);


                }
            }
        });
        Button imageView=(Button) view.findViewById(R.id.name_editBtn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity(),"Alert Dialog ");

            }
        });


        return view;
    }

}
