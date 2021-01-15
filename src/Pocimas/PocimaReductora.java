package Pocimas;

import tpeprog2.Atributo;

public class PocimaReductora extends Pocima {

    private double valorPorcentaje;

    public PocimaReductora(String nombre, double valorPorcentaje) {
	super(nombre);
	this.valorPorcentaje = valorPorcentaje;
    }
	
    public double getValorPorcentaje() {
	return this.valorPorcentaje;
    }

    public void setValorPorcentaje(double valorPorcentaje) {
	this.valorPorcentaje = valorPorcentaje;
    }

    @Override
    public double calcularValoresAtributos(Atributo atributo) {
	double valor = atributo.getValor();
	return  valor - valor * this.getValorPorcentaje() / 100;
    }
	
    public String toString() {
	return "Nombre Pocima: " + this.getNombre() + " Valor: " + this.getValorPorcentaje();
    }
}
