package com.example.countries.Ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countries.Model.Photo;
import com.example.countries.Model.Photos;
import com.example.countries.Model.Root;
import com.example.countries.R;
import com.example.countries.databinding.ItemBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
ArrayList<Photo> list = new ArrayList();
int pos;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItemBinding bining1 = DataBindingUtil.inflate(inflater, R.layout.item,parent,false);

        return new ViewHolder(bining1);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//       holder.itemBinding.page.setText(list.get(position).getPage());
//        holder.itemBinding.pages.setText(list.get(position).getPages());
//        holder.itemBinding.perpage.setText(list.get(position).getPerpage());
//        holder.itemBinding.total.setText(list.get(position).getTotal());

        holder.itemBinding.id.setText(list.get(position).getId());
        holder.itemBinding.owner.setText(list.get(position).getOwner());
        holder.itemBinding.secret.setText(list.get(position).getSecret());
        holder.itemBinding.server.setText(list.get(position).getServer());
        holder.itemBinding.farm.setText(""+list.get(position).getFarm());
        holder.itemBinding.title.setText(list.get(position).getTitle());
        holder.itemBinding.ispublic.setText(""+list.get(position).getIspublic());
        holder.itemBinding.isfriend.setText(""+list.get(position).getIsfriend());
        holder.itemBinding.isfamily.setText(""+list.get(position).getIsfamily());



       // Picasso.get().load("").into(holder.itemBinding.image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList<Photo> list) {
        this.list = list;
        notifyDataSetChanged();
    }




    protected class ViewHolder extends RecyclerView.ViewHolder{
        private ItemBinding itemBinding;


        public ViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.itemBinding=binding;
        }
    }
}
