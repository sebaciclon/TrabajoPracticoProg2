package tpeprog2;

import Pocimas.Pocima;
import java.util.ArrayList;
import java.util.List;

public class Mazo {
    
    private String nombre;
    private List<String> atributosDelMazo; //Nombres de atributos que tiene el mazo
    private List<Carta> mazo;
	
    public Mazo(String nombre) {
	this.nombre = nombre;
	this.atributosDelMazo = new ArrayList<>(); //Atributos que tienen que tener todas las cartas del mazo
	this.mazo = new ArrayList<>();
    }
	
    //Agrega los nombres de los atributos que va a tener el mazo y deben tener 
    //cada una de las cartas. Estos atributos los sacamos de la primera carta que 
    //agregamos al mazo
    public void addAtributosDelMazo(List<String> atributos) {
	this.atributosDelMazo = atributos;
    }
	
    public void addCarta(Carta carta) {
	if(this.perteneceAMazo(carta))
            this.mazo.add(carta);
    }
	
    //Verifica que la carta corresponda al mazo
    public boolean perteneceAMazo(Carta carta) {
	if(this.cantidadAtributos() == carta.cantidadAtributos()) {
            for(int i=0; i < this.atributosDelMazo.size(); i++) {
		if(!carta.contieneAtributo(this.atributosDelMazo.get(i)))
                    return false;
            }
            return true;
	}
	return false;
    }
	
    //Cantidad de atributos que tiene el mazo y por ende tiene que tener las cartas
    public int cantidadAtributos() {
	return this.atributosDelMazo.size();
    }
	
    //Se usa para saber qué cantidad de cartas vamos a repartir
    public int cantidadCartas() {
	return this.mazo.size();
    }
	
    //Se usa para repartir el mazo entre los jugadores
    public Carta darCarta() {
	return this.mazo.remove(0);
    }
    
    //Reparte las cartas del mazo entre los dos jugadores
    //Si hay pocimas, tambien las reparte
    public void repartirCartas(Jugador jugador1, Jugador jugador2, List<Pocima> pocimas) {
	int cantidadDeCartas = this.cantidadCartas();
	for(int i=0; i < cantidadDeCartas; i++) {
            Carta nuevaCarta = this.darCarta();
            if (i < pocimas.size()) {
		nuevaCarta.addPocima(pocimas.get(i));
            }
            if(i%2 == 0)
                jugador1.addCarta(nuevaCarta);
            else
                jugador2.addCarta(nuevaCarta);
        }
    }
	
    public String toString() {
	String cadena = "";
	for(int i=0; i < this.mazo.size(); i++) {
            cadena = cadena + this.mazo.get(i).getNombre() + " " + this.mazo.get(i).getAtributos() + "\n"; 
	}
	return cadena;
    }
    
    //Retorna una copia de la lista de atributos del mazo
    //Se usa para generar Pocima Selectiva
    public ArrayList<String> getAtributos(){
	ArrayList<String> aux = new ArrayList<>();
	aux.addAll(this.atributosDelMazo);
	return aux;
    }
}
