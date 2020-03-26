package model.data_structures;

public class Nodo <K> {
	
	public Nodo<K> sig;

	public  Nodo<K> ant;
	private K datoActual;
	public Nodo(K dato){
		datoActual = dato;
		sig = null;
		ant=null;
	}
	public K darDato() {
		return datoActual;
	}



	public Nodo darSiguente() {
		return sig;
	}


	public void setSiguiente(Nodo psiguiente) {

		sig=psiguiente;

	}
	public Nodo darAnterior() {
		return sig;
	}


	public void setAnterior(Nodo panterior) {

		sig=panterior;

	}


	public void setDato(K dato) 
	{
		datoActual = dato;
	}

	

}
