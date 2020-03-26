package model.logic;


import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.HashTable;
import model.data_structures.ListaDoble;


/**
 * Definicion del modelo del mundo
 */
public class Modelo {

	public static String PATH = "./data/Comparendos_DEI_2018_Bogota_D.C_small.geojson";

	public ListaDoble<Comparendo> datos;
	public HashTable datosHash;
	public Modelo(){
		datos= new ListaDoble<>();
		datosHash= new HashTable<>();
	}

	public void cargarDatos() {

		JsonReader reader;

		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();

			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

			for (JsonElement e : e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();
				Date FECHA_HORA = parser.parse(s);

				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETECCION").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHICULO").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVICIO").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRACCION").getAsString();
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();
				String MUNICIPIO = e.getAsJsonObject().get("properties").getAsJsonObject().get("MUNICIPIO").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, DES_INFRAC, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, LOCALIDAD, MUNICIPIO, longitud, latitud);
				datos.instertar(c);
				int llave = FECHA_HORA.hashCode()*CLASE_VEHI.hashCode()*INFRACCION.hashCode();

				datosHash.put(llave, c);
			}

		}
		catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public int darTamano() {
		// TODO Auto-generated method stub
		return datosHash.darTamanoActual();
	}
	
	public String reque1(Object fecha, Object claseVehi, Object infrac)
	{
		String msj = "";
		try {
			cargarDatos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		for (int i = 0; i < datosHash.darTamanoActual(); i++) {
			int llave = fecha.hashCode()*claseVehi.hashCode()*infrac.hashCode();
			Object actual = datosHash.get(llave);
			ArrayList<Comparendo> resp = new ArrayList<>();
			
			if (actual!=null) {
				resp.add((Comparendo) actual);
				
			}
			int mayor=0;
			for (int j = 0; j < resp.size()-1; j++) {
				Comparendo act = resp.get(i);
				
				msj=msj+"[ID="+act.dartId()+",Fecha="+act.darFecha()+",Tipo_Servicio="+act.darTipoServi()+",="+act.darClaseVehi()+",Infraccion="+act.darCodInfrac()+"]"+"\n";
				
			}
			
		}
		
		
	}
		return msj;
}
	}