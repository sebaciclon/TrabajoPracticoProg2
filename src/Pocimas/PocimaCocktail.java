package Pocimas;

import java.util.ArrayList;
import java.util.List;
import tpeprog2.Atributo;

public class PocimaCocktail extends Pocima {

    private List<Pocima> pocimas;
	
    public PocimaCocktail() {
	super("Cocktail");
	this.pocimas = new ArrayList<>();
    }
	
    public void addPocima(Pocima pocima) {
	this.pocimas.add(pocima);
    }

    @Override
    public double calcularValoresAtributos(Atributo atributo) {
	Atributo aux = atributo;
	double resultadoFinal = atributo.getValor();
	for (Pocima pocima: this.pocimas) {
		resultadoFinal = pocima.calcularValoresAtributos(aux);
		aux.setValor(resultadoFinal);
	}
	return resultadoFinal;
    }
	
    public String toString() {
	String salida = "Nombre Pocima: " + this.getNombre() + "\n";
	for (Pocima pocima: this.pocimas)
		salida += "Componentes del Cocktail: " + pocima.getNombre() + "\n";
	return salida;				
    }
}
