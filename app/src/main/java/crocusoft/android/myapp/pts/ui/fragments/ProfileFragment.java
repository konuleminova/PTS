package crocusoft.android.myapp.pts.ui.fragments;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import crocusoft.android.myapp.pts.R;

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



        return view;
    }

}
