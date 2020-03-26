package model.data_structures;

public interface IListaDoble <K> {

	public void instertar(K dato);

	public K darPrimero();

	public boolean estaVacio();

	public int darTamano();

	public K buscarElemento(K buscado);

	public K sacar();

	public K darFinal();

	public void eliminar();
	;
}
