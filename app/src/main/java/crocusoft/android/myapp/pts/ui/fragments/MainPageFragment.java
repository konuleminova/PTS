package crocusoft.android.myapp.pts.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import crocusoft.android.myapp.pts.R;
import crocusoft.android.myapp.pts.network.ApiClient;
import crocusoft.android.myapp.pts.network.ApiInterface;
import crocusoft.android.myapp.pts.network.requests.GetTemplateRequest;
import crocusoft.android.myapp.pts.network.requests.LoginRequestClass;
import crocusoft.android.myapp.pts.network.responses.FormInputs;
import crocusoft.android.myapp.pts.network.responses.LoginResponseClass;
import crocusoft.android.myapp.pts.network.responses.getTemplateResponse;
import crocusoft.android.myapp.pts.ui.activity.AddItemActivity;
import crocusoft.android.myapp.pts.ui.activity.LoginActivity;
import crocusoft.android.myapp.pts.ui.activity.MainActivity;
import crocusoft.android.myapp.pts.ui.activity.SelectedPointActivity;
import crocusoft.android.myapp.pts.ui.activity.WelcomeActivity;
import crocusoft.android.myapp.pts.ui.adapters.ItemAdapter;
import crocusoft.android.myapp.pts.ui.objects.Item;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Asus on 12/24/2017.
 */

public class MainPageFragment extends Fragment {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private ArrayList<Item> dataList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mainpage_layout, container, false);
        dataList = new ArrayList<>();
        dataList.add(new Item(getResources().getString(R.string.name), getResources().getString(R.string.loaction), getResources().getString(R.string.time), R.drawable.location_round_icon, R.drawable.location_round_icon, R.drawable.location_round_icon, R.drawable.arrow_point_to_right));
        dataList.add(new Item(getResources().getString(R.string.name), getResources().getString(R.string.loaction), getResources().getString(R.string.time), R.drawable.location_round_icon, R.drawable.location_round_icon, R.drawable.location_round_icon, R.drawable.arrow_point_to_right));
        dataList.add(new Item(getResources().getString(R.string.name), getResources().getString(R.string.loaction), getResources().getString(R.string.time), R.drawable.location_round_icon, R.drawable.location_round_icon, R.drawable.location_round_icon, R.drawable.arrow_point_to_right));
        dataList.add(new Item(getResources().getString(R.string.name), getResources().getString(R.string.loaction), getResources().getString(R.string.time), R.drawable.location_round_icon, R.drawable.location_round_icon, R.drawable.location_round_icon, R.drawable.arrow_point_to_right));

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        adapter = new ItemAdapter(dataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        Button addButton = (Button) view.findViewById(R.id.add_icon);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AddItemActivity.class);
                startActivity(i);
            }
        });
        recyclerView.addOnItemTouchListener(new ClickListener.RecyclerOnItemTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void OnClick(final View view, final int position) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.recycler_relativeLayout);
                relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view1) {
                        Intent intent = new Intent(getActivity(), SelectedPointActivity.class);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void OnLongClick(View view, int position) {

            }
        }));

        return view;
    }

    public interface ClickListener {
        void OnClick(View view, int position);

        void OnLongClick(View view, int position);


        class RecyclerOnItemTouchListener implements RecyclerView.OnItemTouchListener {
            public GestureDetector gestureDetector;
            public MainPageFragment.ClickListener clickListener;

            public RecyclerOnItemTouchListener(Context context, final RecyclerView recyclerView, final MainPageFragment.ClickListener clickListener) {
                this.clickListener = clickListener;
                gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        return true;
                    }

                    @Override
                    public void onLongPress(MotionEvent e) {
                        View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                        if (child != null && clickListener != null) {
                            clickListener.OnLongClick(child, recyclerView.getChildPosition(child));
                        }
                    }

                });
            }

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clickListener != null) {
                    clickListener.OnClick(child, rv.getChildPosition(child));
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        }
    }


}
