package tpeprog2;

import Pocimas.Pocima;
import Pocimas.PocimaAumentadora;
import Pocimas.PocimaCocktail;
import Pocimas.PocimaNumeroFijo;
import Pocimas.PocimaReductora;
import Pocimas.PocimaSelectiva;
import java.util.ArrayList;
import java.util.List;

public class GeneradorMazoPocimas {

    private List<Pocima> mazoPocimas;
    private List<String> AtributosMazo;
	
    public GeneradorMazoPocimas(ArrayList<String> atributosMazo) {
        this.mazoPocimas = new ArrayList<>();
        this.AtributosMazo = atributosMazo;
		
        PocimaAumentadora p1 = new PocimaAumentadora("Fortalecedora",20);
        PocimaAumentadora p2 = new PocimaAumentadora("Fortalecedora Plus", 50);
	PocimaReductora p3 = new PocimaReductora("Kriptonita", 25);
	PocimaNumeroFijo p4 = new PocimaNumeroFijo("Numero Magico", 23);
	PocimaNumeroFijo p5 = new PocimaNumeroFijo("Quiero Vale Cuatro", 4);
	PocimaReductora p6 = new PocimaReductora("Reductor De Plomo", 55);
	PocimaSelectiva p7 = new PocimaSelectiva(this.nombreAtributo(this.indiceAtributoMazo()), 35);
	PocimaSelectiva p8 = new PocimaSelectiva(this.nombreAtributo(this.indiceAtributoMazo()), 43);
		
	PocimaReductora p9 = new PocimaReductora("Kriptonita", 21);
	PocimaReductora p10 = new PocimaReductora("Reductor De Plomo", 75);
	PocimaSelectiva p11 = new PocimaSelectiva(this.nombreAtributo(this.indiceAtributoMazo()), 15);
		
	PocimaCocktail p12 = new PocimaCocktail();
	p12.addPocima(p9);
	p12.addPocima(p10);
	p12.addPocima(p11);
		
	PocimaAumentadora p20 = new PocimaAumentadora("Fortalecedora",15);
	PocimaAumentadora p13 = new PocimaAumentadora("Fortalecedora Plus", 40);
	PocimaReductora p14 = new PocimaReductora("Kriptonita", 35);
	PocimaNumeroFijo p15 = new PocimaNumeroFijo("Numero Magico", 28);
	PocimaNumeroFijo p16 = new PocimaNumeroFijo("Quiero Re Truco", 3);
	PocimaReductora p17 = new PocimaReductora("Reductor De Plomo", 15);
	PocimaSelectiva p18 = new PocimaSelectiva(this.nombreAtributo(this.indiceAtributoMazo()), 27);
	PocimaSelectiva p19 = new PocimaSelectiva(this.nombreAtributo(this.indiceAtributoMazo()), 33);
		
	PocimaCocktail p21 = new PocimaCocktail();
	p21.addPocima(p12);
	p21.addPocima(p2);
		
	this.mazoPocimas.add(p1);
	this.mazoPocimas.add(p2);
	this.mazoPocimas.add(p3);
	this.mazoPocimas.add(p4);
	this.mazoPocimas.add(p5);
	this.mazoPocimas.add(p6);
	this.mazoPocimas.add(p7);
	this.mazoPocimas.add(p8);
	this.mazoPocimas.add(p12);
	this.mazoPocimas.add(p20);
	this.mazoPocimas.add(p13);
	this.mazoPocimas.add(p14);
	this.mazoPocimas.add(p15);
	this.mazoPocimas.add(p16);
	this.mazoPocimas.add(p17);
	this.mazoPocimas.add(p18);
	this.mazoPocimas.add(p19);
	this.mazoPocimas.add(p21);
    }
	
    public List<Pocima> getMazoPocimas(){
	List<Pocima> aux = new ArrayList<>();
	aux.addAll(this.mazoPocimas);
	return aux;
    }
	
    private int indiceAtributoMazo() {
	int cantidadAtributos = this.AtributosMazo.size();
	double i = Math.random()*(cantidadAtributos);
	return (int)i;
    }
	
    private String nombreAtributo(int i) {
	return this.AtributosMazo.get(this.indiceAtributoMazo());
    }
	
}
