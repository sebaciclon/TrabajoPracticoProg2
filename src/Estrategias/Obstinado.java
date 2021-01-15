package Estrategias;

import tpeprog2.Carta;

public class Obstinado extends Estrategia {
    
    private String nombreAtributo;

    public Obstinado(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }
    
    //Por defecto juega con el primer atributo si no existe el elegido por el jugador
    @Override
    public String atributoEnJuego(Carta carta) {
        if(carta.contieneAtributo(this.nombreAtributo))
            return this.nombreAtributo;
        return carta.getNombreAtributo(0);
    }
}
