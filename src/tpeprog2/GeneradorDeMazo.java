package tpeprog2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class GeneradorDeMazo {
    
    private String jsonFile;
    private String nombreMazo;
	
    public GeneradorDeMazo(String jsonFile, String nombreMazo) {
	this.jsonFile = jsonFile;
	this.nombreMazo = nombreMazo;
    }

    //Genera un mazo levantando los datos de un archivo json
    public Mazo armarMazo() {
        Mazo nuevoMazo = new Mazo(this.nombreMazo);
	File jsonInputFile = new File(this.jsonFile);
	InputStream is;
	try {
	    is = new FileInputStream(jsonInputFile);
	    // Creo el objeto JsonReader de Json.
	    JsonReader reader = Json.createReader(is);
	    // Obtenemos el JsonObject a partir del JsonReader.
	    JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
	    for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
	        //Generamos una nueva carta
	      	String nombreCarta = carta.getString("nombre");
	        Carta nuevaCarta = new Carta(nombreCarta);
	        JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
	        for (String nombreAtributo:atributos.keySet()) {
                    //Generamos un nuevo atributo y lo agregamos en la carta
	            Atributo nuevoAtributo = new Atributo(nombreAtributo, atributos.getInt(nombreAtributo));
	            nuevaCarta.addAtributo(nuevoAtributo);
	        }
	        //Si no tenemos inicializados los atributos del mazo lo hacemos
	        //con la primera carta
	        if(nuevoMazo.cantidadAtributos() == 0) {
                    //Inicializamos los atributos que va a tener el mazo
	            nuevoMazo.addAtributosDelMazo(nuevaCarta.getNombresAtributos());
	        }
	        //Agregamos la nueva carta al mazo
	        nuevoMazo.addCarta(nuevaCarta);
	    }
	    reader.close();
        } catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	return nuevoMazo;
    }
}
