package Pocimas;

import tpeprog2.Atributo;

public abstract class Pocima {

    private String nombre;
		
    public Pocima(String nombre) {
	this.nombre = nombre;
    }

    public String getNombre() {
	return this.nombre;
    }

    public abstract double calcularValoresAtributos(Atributo atributo);
}
