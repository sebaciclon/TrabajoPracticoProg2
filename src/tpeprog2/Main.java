package tpeprog2;

import Estrategias.Ambicioso;
import Estrategias.Estrategia;
import Estrategias.Obstinado;
import Estrategias.Timbero;
import Pocimas.Pocima;
import java.util.List;

public class Main {
    

    public static void main(String[] args) {
        
        //Creamos las estrategias de juego
        Estrategia jugadorTimbero = new Timbero();
        Estrategia jugadorAmbicioso = new Ambicioso();
        Estrategia jugadorObstinado = new Obstinado("fuerza");
               
        //Creamos los jugadores
    	Jugador jugador1 = new Jugador("leo", jugadorAmbicioso);   
        Jugador jugador2 = new Jugador("juan", jugadorObstinado);
        
        //Creamos el mazo
        /*String pathMazo = "./src/tpeprog2/superheroes.json";      
        String nombreMazo = "SuperHeroes";
        Mazo mazo = new GeneradorDeMazo(pathMazo, nombreMazo).armarMazo();
        System.out.println("Mazo de " + nombreMazo + " para jugar el juego! ");
        System.out.println("El mazo cuenta con " + mazo.cantidadCartas() + " cartas");
        System.out.println(mazo);*/
        
        //Armamos los dos mazos para que puedan probarlo facilmente. Comentan uno y descomentan el otro
        
        String pathMazo = "./src/tpeprog2/autos.json";      
        String nombreMazo = "Autos";
        Mazo mazo = new GeneradorDeMazo(pathMazo, nombreMazo).armarMazo();
        System.out.println("Mazo de " + nombreMazo + " para jugar el juego! ");
        System.out.println("El mazo cuenta con " + mazo.cantidadCartas() + " cartas");
        System.out.println(mazo);
        
        //Generamos la lista de pocimas
        GeneradorMazoPocimas generador = new GeneradorMazoPocimas(mazo.getAtributos());
        List<Pocima> mazoPocimas = generador.getMazoPocimas();
        
        Juego nuevoJuego = new Juego(mazo, jugador1, jugador2, 6, mazoPocimas);
        
        nuevoJuego.jugar();
    }
}
