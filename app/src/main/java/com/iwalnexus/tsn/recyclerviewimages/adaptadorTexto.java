package com.iwalnexus.tsn.recyclerviewimages;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class adaptadorTexto extends RecyclerView.Adapter<adaptadorTexto.ViewHolder> {

    private List<String> lista;
    private  int layout;
    private Context context;
    private View.OnClickListener listener;

    public adaptadorTexto(List<String> lista, int layout, Context context, View.OnClickListener listener) {
        this.lista = lista;
        this.layout = layout;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public adaptadorTexto.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull adaptadorTexto.ViewHolder holder, int position) {
        holder.bind(lista.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener{

            public ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            image.setOnCreateContextMenuListener(this);
        }

        public void bind(String texto, View.OnClickListener listener) {

           Glide.with(context).load(texto).into(image);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

            MenuInflater inflater = new MenuInflater(context);
            inflater.inflate(R.menu.context_menu, menu);

            for (int i= 0; i < menu.size(); i++){
                menu.getItem(i).setOnMenuItemClickListener(this);

            }
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.borrar:
                lista.remove(getAdapterPosition());
                notifyItemRemoved(getAdapterPosition());
                        return true;

                default:
                    return false;
            }


        }
    }



}
