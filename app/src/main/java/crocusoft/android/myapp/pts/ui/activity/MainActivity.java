package crocusoft.android.myapp.pts.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import crocusoft.android.myapp.pts.ui.fragments.MainPageFragment;
import crocusoft.android.myapp.pts.ui.fragments.OnMapFragment;
import crocusoft.android.myapp.pts.ui.fragments.ProfileFragment;
import crocusoft.android.myapp.pts.R;


public class MainActivity extends AppCompatActivity {
    RelativeLayout mainpage, onmap, profile;
    ImageView mainView, onmapView, profileView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainpage = (RelativeLayout) findViewById(R.id.mainpage);
        onmap = (RelativeLayout) findViewById(R.id.onmap);
        profile = (RelativeLayout) findViewById(R.id.profile);
        mainView = (ImageView) findViewById(R.id.mainpage_imageview);
        onmapView = (ImageView) findViewById(R.id.onmap_imageview);
        profileView = (ImageView) findViewById(R.id.profile_imageview);
        onmapView.getBackground().setAlpha(127);
        profileView.getBackground().setAlpha(127);
        setFragment(0, null);
        mainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setFragment(0, null);
                mainView.getBackground().setAlpha(255);
                onmapView.getBackground().setAlpha(127);
                profileView.getBackground().setAlpha(127);

            }
        });
        onmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setFragment(1, null);
                mainView.getBackground().setAlpha(127);
                onmapView.getBackground().setAlpha(255);
                profileView.getBackground().setAlpha(127);
                //Intent i = new Intent(MainActivity.this, MapsActivity.class);
                //startActivity(i);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setFragment(2, null);
                mainView.getBackground().setAlpha(127);
                onmapView.getBackground().setAlpha(127);
                profileView.getBackground().setAlpha(255);
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);

    }

    public int setFragment(int id, Bundle bundle) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (id == 0) {
            MainPageFragment fragment = new MainPageFragment();
            fragmentTransaction.replace(R.id.frameContainer, fragment);
            fragmentTransaction.commit();

        } else if (id == 1) {
            OnMapFragment fragment = new OnMapFragment();
            fragmentTransaction.replace(R.id.frameContainer, fragment);
            fragmentTransaction.commit();
        } else {
            ProfileFragment fragment = new ProfileFragment();
            fragmentTransaction.replace(R.id.frameContainer, fragment);
            fragmentTransaction.commit();
        }

        return id;
    }

}
