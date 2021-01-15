package Estrategias;

import tpeprog2.Carta;

public class Ambicioso extends Estrategia {

    public Ambicioso() {
    }
    
    @Override
    public String atributoEnJuego(Carta carta) {
        return carta.getAtributoMayorValor();
    }
    
}
