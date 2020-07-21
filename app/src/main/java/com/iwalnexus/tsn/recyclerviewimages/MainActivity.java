package com.iwalnexus.tsn.recyclerviewimages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    adaptadorTexto adaptadorTexto;
    RecyclerView.LayoutManager manager;
    List<String> lista;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);

        lista = new ArrayList<>();
        lista.add("https://cnnespanol2.files.wordpress.com/2019/12/s_64a163f16ecbb099e52f2f8271f73cbbfcfc9034be4d646f7375e4db1ca6f3d7_1573501883482_ap_19001106049831-1.jpg?quality=100&strip=info&w=320&h=240&crop=1");
        lista.add("https://cnnespanol2.files.wordpress.com/2019/12/mejores-imagenes-del-ancc83o-noticias-2019-galeria10.jpg?quality=100&strip=info&w=320&h=240&crop=1");
        lista.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1-VKyjuYtIw6bi0o0oyHdnqaTKFiimP4yQmpKXZCNu3EiFctMKw&s");


        manager = new LinearLayoutManager(this);

        //manager = new GridLayoutManager(this, 2);


        adaptadorTexto = new adaptadorTexto(lista, R.layout.rv_lista, this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptadorTexto);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_rv, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.añadir:
                lista.add("Nuevo" + ++contador);
                adaptadorTexto.notifyDataSetChanged();
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }


    }
}