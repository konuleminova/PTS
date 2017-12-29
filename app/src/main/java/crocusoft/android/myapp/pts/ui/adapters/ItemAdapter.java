package crocusoft.android.myapp.pts.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import crocusoft.android.myapp.pts.R;
import crocusoft.android.myapp.pts.ui.objects.Item;

/**
 * Created by Asus on 12/25/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    ArrayList<Item> persons;

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_layout, parent, false);
        return new ItemViewHolder(view);
    }

    public ItemAdapter(ArrayList<Item> persons) {
        this.persons = persons;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.txtName.setText(persons.get(position).getName());
        holder.txtLocation.setText(persons.get(position).getLocation());
        holder.txtTime.setText(persons.get(position).getTime());

        holder.imgName.setImageResource(persons.get(position).getNameImg());
        holder.imgLOaction.setImageResource(persons.get(position).getNameImg());
        holder.imgTime.setImageResource(persons.get(position).getNameImg());
        holder.nextbtn.setImageResource(persons.get(position).getNextbtn());

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtLocation, txtTime;
        ImageView imgName, imgLOaction, imgTime, nextbtn;

        public ItemViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.Name);
            txtLocation = (TextView) itemView.findViewById(R.id.loaction);
            txtTime = (TextView) itemView.findViewById(R.id.time);

            imgName = (ImageView) itemView.findViewById(R.id.imgName);
            imgLOaction = (ImageView) itemView.findViewById(R.id.imgLocation);
            imgTime = (ImageView) itemView.findViewById(R.id.imgTime);
            nextbtn = (ImageView) itemView.findViewById(R.id.nextbtn);
        }
    }
}
