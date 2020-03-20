package model.data_structures;

public class Nodo <Key,Value> {
    Nodo<Key,Value> sig;
	
	private Value datoActual;
	private Key llave;
	public Nodo(Key llaveP, Value dato){
		datoActual = dato;
		sig = null;
		llave = llaveP;
	}
	public Value darDato() {
		return datoActual;
	}

		public Key darllave() {
			return llave;
		}
		
		
	public Nodo darSiguente() {
		return sig;
	}
	
	
	public void setSiguiente(Nodo psiguiente) {
		
		sig=psiguiente;
		
	}

	
	
	public void setDato(Value dato) 
	{
		datoActual = dato;
	}
	
	public void setLlave(Key llaveEntrada) {
		llave = llaveEntrada;
	}
	
}
