package Estrategias;

import tpeprog2.Carta;

public class Timbero extends Estrategia {

    public Timbero() {
    }
    
    @Override
    public String atributoEnJuego(Carta carta) {
        int i = (int) (Math.random()*(carta.cantidadAtributos()));
	return carta.getNombreAtributo(i);
    }
}
