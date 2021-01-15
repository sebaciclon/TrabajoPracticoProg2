package Pocimas;

import tpeprog2.Atributo;

public class PocimaSelectiva extends Pocima {

    private String nombreAtributo;
    private double valorPorcentaje;
	
    public PocimaSelectiva(String nombreAtributo, double valorPorcentaje) {
	super("Selectiva " + nombreAtributo);
	this.nombreAtributo = nombreAtributo;
	this.valorPorcentaje = valorPorcentaje;
    }

    public String getNombreAtributo() {
	return this.nombreAtributo;
    }

    public void setNombreAtributo(String nombreAtributo) {
	this.nombreAtributo = nombreAtributo;
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
	if (atributo.getNombre().equals(this.getNombreAtributo())) {
            return  valor + valor * this.getValorPorcentaje() / 100;
	}
	return valor;	}
	
    public String toString() {
	return "Nombre Pocima: " + this.getNombre() + " Valor: " + this.getValorPorcentaje();
    }
}







/*
public class PocimaSelectiva extends Pocima {

    private String nombreAtributo;
    private double valorPorcentaje;
	
    public PocimaSelectiva(String nombre, String nombreAtributo, double valorPorcentaje) {
	super(nombre);
	this.nombreAtributo = nombreAtributo;
	this.valorPorcentaje = valorPorcentaje;
    }

    public String getNombreAtributo() {
	return this.nombreAtributo;
    }

    public void setNombreAtributo(String nombreAtributo) {
	this.nombreAtributo = nombreAtributo;
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
	if (atributo.getNombre().equals(this.getNombreAtributo())) {
            return  valor + valor * this.getValorPorcentaje() / 100;
	}
	return valor;
    }
	
    public String toString() {
	return "Nombre Pocima: " + this.getNombre() + " Valor: " + this.getValorPorcentaje();
    }
}*/

