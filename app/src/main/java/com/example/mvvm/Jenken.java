package com.example.mvvm;


public class Jenken {

    interface LlamameAqui {
        void cuandoSepasElResultado(String resultado);
        void cuandoLasManosSeanIncorrectas(int mano);
    }

    void comprobarGanador(String mano1, String mano2, LlamameAqui llamameAqui){

        if (!mano1.equals("Piedra") && !mano1.equals("Papel") && !mano1.equals("Tijeras")){
            llamameAqui.cuandoLasManosSeanIncorrectas(1);
        }
        if (!mano2.equals("Piedra") && !mano2.equals("Papel") && !mano2.equals("Tijeras")){
            llamameAqui.cuandoLasManosSeanIncorrectas(2);
        }
        String resultado = "";

        if (mano2.equals("Papel")) {
            if (mano1.equals("Papel")) {
                resultado = "Empate";
            } else if (mano1.equals("Tijeras")) {
                resultado = "Mano 1 gana";
            } else if (mano1.equals("Piedra")) {
                resultado = "Mano 2 gana";
            }
        }
        if (mano2.equals("Tijeras")) {
            if (mano1.equals("Papel")) {
                resultado = "Mano 2 gana";
            }
            if (mano1.equals("Tijeras")) {
                resultado = "Empate";
            }
            if (mano1.equals("Piedra")) {
                resultado = "Mano 1 gana";
            }
        }
        if (mano2.equals("Piedra")) {
            if (mano1.equals("Papel")) {
                resultado = "Mano 1 gana";
            }
            if (mano1.equals("Tijeras")) {
                resultado = "Mano 2 gana";
            }
            if (mano1.equals("Piedra")) {
                resultado = "Empate";
            }
        }

        llamameAqui.cuandoSepasElResultado(resultado);
    }
}
