package model.data_structures;

import java.util.Iterator;

public class HashTable <Key extends Comparable<Key>,Value> {
	
	
	private int x; 
	private int y; //numero clave valor
	private Nodo<Key, Value>[] start;
	


	public HashTable(int Py){
		y=Py;

		start = new Nodo[y];
	}

	public void put (Key K, Value V) {
		Nodo<Key, Value> insert = new Nodo<Key, Value>(K, V);
		int pos = 0;
		if(start[pos] == null)
		{
			start[pos] = insert; 
		}
		else
		{
			Nodo<Key, Value> actual = start[pos];
			boolean existeN = false;
			while(actual.darSiguente() != null)
			{
				if(actual.darllave() == K)
				{
					actual.setDato(V);
					existeN = true;
					break;
				}		
				actual = actual.darSiguente();
			}
			if(!existeN)
			{
				actual.setSiguiente(insert);	
			}
		}
		y++;
		double total = (double)y / (double) x;
		if(total >= 0.5)
		{
			resize();
		}
	}

	

	

	public void resize() {
		// TODO Auto-generated method stub
		
	}

	public Value get(Key K) {
		return null;
	}

	public Value delete(Key K) {
		return null;
	}


	
public	Iterator<Key> iterador= new Iterator<Key>() {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Key next() {
			// TODO Auto-generated method stub
			return null;
		}
	};



	public Iterator<Key> Keys(){
		return iterador;
	}

	}
