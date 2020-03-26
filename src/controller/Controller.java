package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() throws ParseException 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				view.printMessage("--------- \req 1 ");
				int capacidad = lector.nextInt();
				modelo = new Modelo();
				SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
				view.printMessage("dar fecha segunyyyy-MM-dd'T'HH:mm:ss.SSSXXX");
				dato=lector.next()	;

				Date fecha= parser.parse(dato);

				view.printMessage("dar clase de vehiculo");
				respuesta= lector.next();
				view.printMessage("dar infraccion");
				dato= lector.next();


				modelo.reque1(fecha, respuesta, dato);
				view.printMessage(modelo.reque1(fecha, respuesta, dato));					
				break;

			}}
	}	
}
