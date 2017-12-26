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
import java.util.List;

/**
 * Created by Asus on 12/24/2017.
 */

public class MainPageFragment extends Fragment {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private ArrayList<Item> employeeArrayList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mainpage_layout, container, false);

        employeeArrayList = new ArrayList<>();
        employeeArrayList.add(new Item("Employee1", "emp1@example.com", "123456789",R.drawable.back_photo_pts,R.drawable.back_photo_pts,R.drawable.back_photo_pts,R.drawable.back_photo_pts));
        employeeArrayList.add(new Item("Employee2", "emp1@example.com", "123456789",R.drawable.back_photo_pts,R.drawable.back_photo_pts,R.drawable.back_photo_pts,R.drawable.back_photo_pts));
        employeeArrayList.add(new Item("Employee3", "emp1@example.com", "123456789",R.drawable.back_photo_pts,R.drawable.back_photo_pts,R.drawable.back_photo_pts,R.drawable.back_photo_pts));
        employeeArrayList.add(new Item("Employee4", "emp1@example.com", "123456789",R.drawable.back_photo_pts,R.drawable.back_photo_pts,R.drawable.back_photo_pts,R.drawable.back_photo_pts));


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        adapter = new ItemAdapter(employeeArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
        return view;
    }
}
