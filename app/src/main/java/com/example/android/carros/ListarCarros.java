package com.example.android.carros;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarCarros extends AppCompatActivity {
    private ListView lista;
    private ArrayList<Carro> carros;
    private Context contexto;
    private AdaptadorCarro adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_carros);

        lista = (ListView)findViewById(R.id.lstListado);
        contexto = this.getApplicationContext();
        carros = Datos.obtenerCarro();
        adapter = new AdaptadorCarro(contexto, carros);
        lista.setAdapter(adapter);
    }
}
