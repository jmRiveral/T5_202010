package model.data_structures;

import model.data_structures.HashNodo;

public class HashNodo <Key,Value> {
		
		public HashNodo<Key,Value> sig;

		public  HashNodo<Key,Value> ant;
		public Value datoActual;
		public Key llave;
		public HashNodo(Key llaveP, Value dato){
			datoActual = dato;
			sig = null;
			ant=null;
			llave = llaveP;
		}
		
		  
	        
		public Value darDato() {
			return datoActual;
		}

		public Key darllave() {
			return llave;
		}


		public HashNodo darSiguente() {
			return sig;
		}


		public void setSiguiente(HashNodo psiguiente) {

			sig=psiguiente;

		}
	

		public void setDato(Value dato) 
		{
			datoActual = dato;
		}

		public void setLlave(Key llaveEntrada) {
			llave = llaveEntrada;
		}
		@Override
        public String toString() {
            return "[" + llave + ", " + datoActual + "]";
        }
	

}
