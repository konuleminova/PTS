package photogeneia.koteoglou.olga.pts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

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
        dataList.add(new Item(getResources().getString(R.string.name), getResources().getString(R.string.loaction), getResources().getString(R.string.time),R.drawable.location_round_icon,R.drawable.location_round_icon,R.drawable.location_round_icon,R.drawable.arrow_point_to_right));
        dataList.add(new Item(getResources().getString(R.string.name),getResources().getString(R.string.loaction), getResources().getString(R.string.time),R.drawable.location_round_icon,R.drawable.location_round_icon,R.drawable.location_round_icon,R.drawable.arrow_point_to_right));
        dataList.add(new Item(getResources().getString(R.string.name), getResources().getString(R.string.loaction), getResources().getString(R.string.time),R.drawable.location_round_icon,R.drawable.location_round_icon,R.drawable.location_round_icon,R.drawable.arrow_point_to_right));
        dataList.add(new Item(getResources().getString(R.string.name), getResources().getString(R.string.loaction), getResources().getString(R.string.time),R.drawable.location_round_icon,R.drawable.location_round_icon,R.drawable.location_round_icon,R.drawable.arrow_point_to_right));

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        adapter = new ItemAdapter(dataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
