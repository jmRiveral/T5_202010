package model.data_structures;

public class ListaDoble <K>implements IListaDoble<K>{

	private Integer dato;
	private Nodo primero;
	private Nodo ultimo;
	private int tamano;

	public ListaDoble() {





		primero=null;
		ultimo=null;
		tamano=0;
	}


	public Nodo darInicial() {
		return primero;
	}

	public void instertar(Object Pdato) {
		// TODO Auto-generated method stub
		Nodo nuevoNodo=new Nodo(Pdato);
		nuevoNodo.setSiguiente(null);
		if(primero==null & ultimo==null)
		{
			primero=nuevoNodo;
			ultimo=nuevoNodo;
			tamano++;

		}
		ultimo.setSiguiente(nuevoNodo);
		ultimo=ultimo.darSiguente();
		tamano++;

	}

	public K darPrimero() {
		// 
		K dato=(K) primero.darDato();

		return dato;
	}

	public boolean estaVacio() {
		boolean cola=false;
		if(primero==null & ultimo==null)
		{
			cola=true;
			System.out.println("La cola esta vacia");
		}
		else
		{
			System.out.println("La cola no esta vacia");
			cola=false;
		}
		return cola;
	}

	public int darTamano() {
		int contador=0;
		Nodo c=primero;
		while(c!=null)
		{
			contador++;
			c=c.darSiguente();
		}
		System.out.println("Numero de datos en la cola: "+contador);
		tamano=contador;

		return contador;
	}




	public K buscarElemento(Object buscado) {
		// TODO Auto-generated method stub
		if (estaVacio()!=true) {

			Nodo act=primero;
			boolean encontrado=false;
			while (act!=null && encontrado==false) {
				if (act.darDato().equals(buscado)) {
					encontrado=true;
				}else {
					act=act.darSiguente();
				}

			}
			if (encontrado!=false) {
				return (K) act.darDato();
			}
			else {
				return null;
			}

		}else {
			return null;
		}


	}




	public void eliminar() {

		if (estaVacio()==false) {
			Nodo out = primero;

			Nodo queue=primero.darSiguente();
			primero=queue;
			out.setSiguiente(null);
			tamano--;



			;

		}else {
			System.out.println("No se pudo eliminar,esta vacia la cola");

		}


	}


	public K sacar(){
		K out = darPrimero();
		eliminar();


		return out;
	}

	public K darFinal() {
		return (K) ultimo.darDato();
	}


}


