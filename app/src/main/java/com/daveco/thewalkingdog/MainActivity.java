package com.daveco.thewalkingdog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(this, ActivityContacto.class);
                startActivity(intent);
                break;

            case R.id.mAbout:
                Intent i = new Intent(this, ActivityAbout.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.schnauzer, "Jack", 10));
        mascotas.add(new Mascota(R.drawable.french_poodle, "Bob", 7));
        mascotas.add(new Mascota(R.drawable.pastor_alem_n, "Sam", 4));
        mascotas.add(new Mascota(R.drawable.beagle,"Zack", 9));
        mascotas.add(new Mascota(R.drawable.dachshund,"Slinky", 1));
        mascotas.add(new Mascota(R.drawable.labrador,"Chester", 6));
        mascotas.add(new Mascota(R.drawable.pitbull, "Jhonny", 8));
    }

    public void GoMascotasFav (View v){
        Intent intent = new Intent(this, MascotasFavoritas.class);
        startActivity(intent);
    }

}
