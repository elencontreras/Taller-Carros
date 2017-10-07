package com.example.android.carros;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistrarCarros extends AppCompatActivity {
    private EditText cajaPlaca, cajaPrecio;
    private Spinner comboMarca, comboModelo, comboColor;
    private String [] opcMarca, opcModelo, opcColor;
    private ArrayList<Carro> carros;
    private ArrayList<Integer> fotos;
    private Resources res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_carros);

        res =this.getResources();

        cajaPlaca=(EditText)findViewById(R.id.txtPlaca);
        cajaPrecio=(EditText)findViewById(R.id.txtPrecio);
        comboMarca = (Spinner)findViewById(R.id.cmbMarca);
        comboModelo = (Spinner)findViewById(R.id.cmbModelo);
        comboColor = (Spinner)findViewById(R.id.cmbColor);

        fotos = new ArrayList<>();
        fotos.add(R.drawable.audi);
        fotos.add(R.drawable.chevrolet);
        fotos.add(R.drawable.kia);

        opcMarca= res.getStringArray(R.array.marca);
        opcModelo = res.getStringArray(R.array.modelo);
        opcColor = res.getStringArray(R.array.color);

        ArrayAdapter <String> adapterMarca = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opcMarca);
        ArrayAdapter <String> adapterModelo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opcModelo);
        ArrayAdapter <String> adapterColor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opcColor);

        comboMarca.setAdapter(adapterMarca);
        comboModelo.setAdapter(adapterModelo);
        comboColor.setAdapter(adapterColor);

    }

    public void Guardar(View v){
        int marca, modelo, color;
        String placa;
        double precio;

        if (validar()) {
            placa = cajaPlaca.getText().toString();
            marca = comboMarca.getSelectedItemPosition();
            modelo = comboModelo.getSelectedItemPosition();
            color = comboColor.getSelectedItemPosition();
            precio = Integer.parseInt(cajaPrecio.getText().toString());

            Carro c = new Carro(Metodos.fotoAleatoria(fotos), placa, marca, modelo, color, precio);
            c.guardar();
            limpiar();
            Toast.makeText(this, res.getString(R.string.msjGuardar), Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validar(){

        if (cajaPlaca.getText().toString().isEmpty()){
            cajaPlaca.setError(res.getString(R.string.error1));
            cajaPlaca.requestFocus();
            return false;
        }
        if (cajaPrecio.getText().toString().isEmpty()){
            cajaPrecio.setError(res.getString(R.string.error2));
            cajaPrecio.requestFocus();
            return false;
        }
        if (Integer.parseInt(cajaPrecio.getText().toString())==0){
            cajaPrecio.setError(res.getString(R.string.error3));
            cajaPrecio.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        cajaPlaca.setText("");
        cajaPrecio.setText("");
        comboMarca.setSelection(0);
        comboModelo.setSelection(0);
        comboColor.setSelection(0);
        cajaPlaca.requestFocus();
    }

    private void limpiar(){
        cajaPlaca.setText("");
        cajaPrecio.setText("");
        comboMarca.setSelection(0);
        comboModelo.setSelection(0);
        comboColor.setSelection(0);
        cajaPlaca.requestFocus();
    }
}
