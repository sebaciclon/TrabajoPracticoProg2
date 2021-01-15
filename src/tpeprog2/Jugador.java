package tpeprog2;

import java.util.ArrayList;
import java.util.List;
import Estrategias.Estrategia;

public class Jugador {
    
    private String nombre;
    private List<Carta> cartas;
    private Estrategia estrategia;
    
    public Jugador(String nombre, Estrategia estrategia) {
	this.nombre = nombre;
	this.cartas = new ArrayList<>();
        this.estrategia = estrategia;
    }
	
    public String getNombre() {
	return this.nombre;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }
    
    public void addCarta(Carta carta) {
	this.cartas.add(carta);
    }
	
    //Retorna la primer carta del mazo deljugador para jugar la ronda
    public Carta jugarCarta() {
	return cartas.remove(0);
    }
    	
    //Devuelve si el jugador aún tiene cartas
    public boolean tieneCartas() {
	return this.cartas.size() > 0;
    }
    
    //Devuelve la cantidad de cartas del jugador
    public int cantCartas() {
        return this.cartas.size();
    }
	
    public String toString() {
	String cadena = "";
    	for(int i=0; i < this.cartas.size(); i++) {
            cadena = cadena + this.cartas.get(i).getNombre() + " " + this.cartas.get(i).getAtributos() + "\n"; 
	}
	return cadena;
    }
}
