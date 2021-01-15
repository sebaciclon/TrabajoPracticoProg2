package tpeprog2;

import Pocimas.Pocima;
import java.util.ArrayList;
import java.util.List;

public class Carta {
    
    private String nombre;
    private List<Atributo> atributos;
    private Pocima pocima;
	
    public Carta(String nombre) {
	this.nombre = nombre;
	this.atributos = new ArrayList<>(); 
        this.pocima = null;
    }
    
    public List<Atributo> getAtributos() {
        return new ArrayList<>(this.atributos);
    }
	
    public String getNombre() {
	return nombre;
    }
    
    //Retorne si la carta tiene un atributo con un nombre determinado
    public boolean contieneAtributo(String nombreAtributo) {
	for(int i=0; i < this.atributos.size(); i++) {
            if(this.atributos.get(i).getNombre().equals(nombreAtributo))
		return true;
	}
	return false;
    }
    
    //Agrega un atributo a la lista si no existe y retorna true, si no lo agrega retorna false
    public boolean addAtributo(Atributo atributo) {
	if(!this.contieneAtributo(atributo.getNombre())) {
            this.atributos.add(atributo);
            return true;
	}
	return false;
    }
	
    //Devuelve el nombre del atributo en la posición i
    //Se usa para que un jugador diga con que atributo juega la ronda
    public String getNombreAtributo(int i) {
	return this.atributos.get(i).getNombre();
    }
	
    //Retorna la cantida de atributos que tiene la carta
    public int cantidadAtributos() {
	return this.atributos.size();
    }
	
    //Retorna un atributo (String, int) buscado por su nombre
    public Atributo getAtributo(String atributoABuscar) {
	for(int i=0; i < this.atributos.size(); i++) {
            if(this.atributos.get(i).getNombre().equals(atributoABuscar))
		return this.atributos.get(i);
	}
	return null;
    }

    //Retorna >0 si gana, <0 si pierde y 0 si empatan
    public int ganaA(Carta carta, String atributoEnJuego) {
	Atributo miAtributo = this.getAtributo(atributoEnJuego);
	Atributo otroAtributo = carta.getAtributo(atributoEnJuego);
	
	double valorMiAtributoConPocima = miAtributo.getValor();
	double valorOtroAtributoConPocima = otroAtributo.getValor();
		
	valorMiAtributoConPocima = this.aplicarPocima(miAtributo);
	valorOtroAtributoConPocima = carta.aplicarPocima(otroAtributo);	
		
	return (int)(valorMiAtributoConPocima - valorOtroAtributoConPocima);
    }
	
    //Retorna la lista de nombres de atributos de la carta
    //Se usa para inicializar los atributos que va a tener el mazo
    public List<String> getNombresAtributos(){
	List<String> lista = new ArrayList<>();
	for(int i=0; i < this.cantidadAtributos(); i++)
            lista.add(this.getNombreAtributo(i));
	return lista;
    }
    
    //Busca el atributo de mayor valor y devuelve su nombre
    //Se usa para el jugador ambicioso
    public String getAtributoMayorValor() {
        String nombre = this.atributos.get(0).getNombre();
        double valor = this.atributos.get(0).getValor();
        
        for(int i = 0; i < this.atributos.size(); i ++) {
            if(this.atributos.get(i).getValor() > valor) {
                nombre = this.atributos.get(i).getNombre();
                valor = this.atributos.get(i).getValor();
            }
        }
        return nombre;
    }
    
    //Agrega una pocima a la carta y aplica las modificaciones
    public void addPocima(Pocima pocima) {
	this.pocima = pocima;
    }
    
    public Pocima getPocima() {
	return this.pocima;
    }
	
    //Aplica la pocima al valor del atributo pasado
    //Si no tiene pocima retorna el mismo valor 
    private double aplicarPocima(Atributo atributo) {
	if (this.getPocima() != null) {
            return (this.getPocima().calcularValoresAtributos(atributo)); 
	}
	return atributo.getValor();
    }
    
    //Devuelve el valor de una atributo aplicandole una pocima
    //Se usa para imprimir en el juego el valor con pocima
    public double getValorAtributoConPocima(String atributo) {
        return (this.aplicarPocima(this.getAtributo(atributo)));
    }
}
