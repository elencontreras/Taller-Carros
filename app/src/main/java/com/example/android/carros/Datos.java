package com.example.android.carros;

import java.util.ArrayList;

/**
 * Created by android on 07/10/2017.
 */

public class Datos {

    public static ArrayList<Carro> carros= new ArrayList<>();

    public static void guardarCarro(Carro p){
        carros.add(p);
    }

    public static ArrayList<Carro> obtenerCarro(){
        return carros;
    }
}
