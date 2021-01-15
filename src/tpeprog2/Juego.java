package tpeprog2;

import Pocimas.Pocima;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {
    
    private Mazo mazo;
    private Jugador jugador1;
    private Jugador jugador2;
    private int cantidadRondas;
    private List<Pocima> pocimas;
    
    //Constructor juego sin pocima
    public Juego(Mazo mazo, Jugador jugador1, Jugador jugador2, int cantidadRondas) {
	this.mazo = mazo;
	this.jugador1 = jugador1;
	this.jugador2 = jugador2;
	this.cantidadRondas = cantidadRondas;
        this.pocimas = new ArrayList<>();
    }
    
    //Contructor juego con pocima
    public Juego(Mazo mazo, Jugador jugador1, Jugador jugador2, int cantidadRondas, List<Pocima> pocimas) {
    	this(mazo, jugador1, jugador2, cantidadRondas);
    	this.pocimas.addAll(pocimas);
    }
    
    //Reparte las cartas del mazo entre los dos jugadores
    public void repartirCartas(Jugador jugador1, Jugador jugador2) {
    	this.mazo.repartirCartas(jugador1, jugador2, this.pocimas);
    }
    
    public int getCantidadRondas() {
        return cantidadRondas;
    }
    
    public void jugar() {
        
        int contRondas = 1;
        String atributo = "";
        
        //Se reparte las cartas entre los dos jugadores
        this.repartirCartas(this.jugador1, this.jugador2);
        System.out.println(this.jugador1.getNombre() + " tiene " + this.jugador1.cantCartas() + " cartas");
        System.out.println(this.jugador2.getNombre() + " tiene " + this.jugador2.cantCartas() + " cartas");
        System.out.println("Los dos jugadores ya pensaron sus estrategias de juego");
        System.out.println("Comienza el juego! Empieza " + this.jugador1.getNombre() + " por ser el jugador 1");
        
        Jugador ganadorRonda = this.jugador1;
           
        while(this.jugador1.tieneCartas() && this.jugador2.tieneCartas() && this.getCantidadRondas() >= contRondas) {
            
            Carta cartaDeJugador1 = this.jugador1.jugarCarta();
            Carta cartaDeJugador2 = this.jugador2.jugarCarta();
            
            if(ganadorRonda.equals(this.jugador2))
               atributo = ganadorRonda.getEstrategia().atributoEnJuego(cartaDeJugador2); 
            else
                atributo = ganadorRonda.getEstrategia().atributoEnJuego(cartaDeJugador1);
            
            System.out.println("************************** Ronda " + contRondas + " *************************");
            System.out.println(ganadorRonda.getNombre() + " selecciona competir por el atributo " + atributo);
            if(cartaDeJugador1.getAtributo(atributo).getValor() == cartaDeJugador1.getValorAtributoConPocima(atributo))
                System.out.println("La carta de " + jugador1.getNombre() + " es " + cartaDeJugador1.getNombre() + " con " + atributo + " " 
                        + cartaDeJugador1.getAtributo(atributo).getValor() + " , no se le aplico pocima");
            else 
                System.out.println("La carta de " + jugador1.getNombre() + " es " + cartaDeJugador1.getNombre() + " con " + atributo + " " 
                        + cartaDeJugador1.getAtributo(atributo).getValor() + " , se aplico pocima " + cartaDeJugador1.getPocima().getNombre() + " cuyo valor resultante es " 
                        + cartaDeJugador1.getValorAtributoConPocima(atributo));
            if(cartaDeJugador2.getAtributo(atributo).getValor() == cartaDeJugador2.getValorAtributoConPocima(atributo))
                System.out.println("La carta de " + jugador2.getNombre() + " es " + cartaDeJugador2.getNombre() + " con " + atributo + " " 
                        + cartaDeJugador2.getAtributo(atributo).getValor() + " , no se le aplico pocima");
            else 
                System.out.println("La carta de " + jugador2.getNombre() + " es " + cartaDeJugador2.getNombre() + " con " + atributo + " " 
                        + cartaDeJugador2.getAtributo(atributo).getValor() + " , se aplico pocima " + cartaDeJugador2.getPocima().getNombre() + " cuyo valor resultante es " 
                        + cartaDeJugador2.getValorAtributoConPocima(atributo));
                        
            System.out.println(" ");
            
            if(cartaDeJugador1.ganaA(cartaDeJugador2, atributo) > 0) {
                this.jugador1.addCarta(cartaDeJugador1);
                this.jugador1.addCarta(cartaDeJugador2);
                System.out.println("Gana la ronda " + this.jugador1.getNombre() + " , ahora tiene " + this.jugador1.cantCartas() + " cartas");
                System.out.println(jugador2.getNombre() + " se queda con " + jugador2.cantCartas() + " cartas");
                ganadorRonda = this.jugador1;
            } else {
                if(cartaDeJugador1.ganaA(cartaDeJugador2, atributo) < 0) {
                    jugador2.addCarta(cartaDeJugador1);
                    jugador2.addCarta(cartaDeJugador2);
                    System.out.println("Gana la ronda " + jugador2.getNombre() + " , ahora tiene " + jugador2.cantCartas() + " cartas");
                    System.out.println(this.jugador1.getNombre() + " se queda con " + this.jugador1.cantCartas() + " cartas");
                    ganadorRonda = jugador2;
                } else {
                    this.jugador1.addCarta(cartaDeJugador1);
                    jugador2.addCarta(cartaDeJugador2);
                    System.out.println("Empate");
                    System.out.println(this.jugador1.getNombre() + " se queda con " + this.jugador1.cantCartas() + " cartas");
                    System.out.println(this.jugador2.getNombre() + " se queda con " + this.jugador2.cantCartas() + " cartas");
                }
            }
            contRondas ++;
        }    
        
        if(!this.jugador1.tieneCartas()) {
            System.out.println("El ganador del juego es " + this.jugador2.getNombre() + "!!!! ");
        } else {
            if(!this.jugador2.tieneCartas()) {
               System.out.println("El ganador del juego es " + this.jugador1.getNombre() + "!!!!"); 
            } else {
                if(this.jugador1.cantCartas() > this.jugador2.cantCartas()) {
                    System.out.println("Se acabaron las ruedas, " + this.jugador1.getNombre() + " tiene mas cartas que " + this.jugador2.getNombre() + ". Gano " + jugador1.getNombre());
                } else {
                    if(jugador1.cantCartas() < this.jugador2.cantCartas()) {
                        System.out.println("Se acabaron las ruedas, " + this.jugador2.getNombre() + " tiene mas cartas que " + this.jugador1.getNombre() + ". Gano " + this.jugador2.getNombre());
                    } else {
                        System.out.println("Empataron " + this.jugador1.getNombre() + " y " + this.jugador2.getNombre());
                    }
                }
            }
        }
    }
}
