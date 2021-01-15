package Pocimas;

import tpeprog2.Atributo;

public class PocimaNumeroFijo extends Pocima {

    private double valorFijo;
	
    public PocimaNumeroFijo(String nombre, double valorFijo) {
	super(nombre);
	this.valorFijo = valorFijo;
    }
	
    public double getValorFijo() {
	return this.valorFijo;
    }

    public void setValorFijo(double valorFijo) {
	this.valorFijo = valorFijo;
    }

    @Override
    public double calcularValoresAtributos(Atributo atributo) {
	return  this.valorFijo;
    }
	
    public String toString() {
	return "Nombre Pocima: " + this.getNombre() + " Valor: " + this.getValorFijo();
    }
}
