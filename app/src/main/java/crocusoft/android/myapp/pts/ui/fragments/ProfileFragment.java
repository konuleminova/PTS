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
    Button nameBtn, snameBtn, emailBtn, phoneBtn, passBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.profile_normal_mod_layout, container, false);
        final View views = getActivity().findViewById(R.id.design_bottom_sheet);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST);
        nameBtn = (Button) view.findViewById(R.id.name_editBtn);
        nameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity(), 0);

            }
        });
       snameBtn = (Button) view.findViewById(R.id.sname_editBtn);
       snameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity(), 1);

            }
        });
        emailBtn = (Button) view.findViewById(R.id.email_editBtn);
        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity(), 2);

            }
        });
        phoneBtn = (Button) view.findViewById(R.id.phone_ediBtn);
       phoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity(), 3);

            }
        });
        passBtn = (Button) view.findViewById(R.id.pass_editBtn);
        passBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity(), 4);

            }
        });



        return view;
    }

}
