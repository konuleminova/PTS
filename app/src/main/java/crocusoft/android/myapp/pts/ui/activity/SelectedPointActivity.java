package crocusoft.android.myapp.pts.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import crocusoft.android.myapp.pts.R;
import crocusoft.android.myapp.pts.ui.fragments.MainPageFragment;
import crocusoft.android.myapp.pts.ui.fragments.OnMapFragment;
import crocusoft.android.myapp.pts.ui.fragments.ProfileFragment;
import crocusoft.android.myapp.pts.ui.fragments.SelectedPointInfoFragment;
import crocusoft.android.myapp.pts.ui.fragments.SelectedPointLocationFragment;

/**
 * Created by Asus on 1/13/2018.
 */

public class SelectedPointActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.selected_point_frame_container);
        setFragment(0,null);

    }
    public  int setFragment(int id, Bundle bundle) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (id == 0) {
            SelectedPointInfoFragment fragment = new SelectedPointInfoFragment ();
            fragmentTransaction.replace(R.id.selectedpoint_frameContainer, fragment);
            fragmentTransaction.commit();

        } else  {
           SelectedPointLocationFragment fragment = new SelectedPointLocationFragment();
            fragmentTransaction.replace(R.id.selectedpoint_frameContainer, fragment);
            fragmentTransaction.commit();
        }
        return id;
    }
}
