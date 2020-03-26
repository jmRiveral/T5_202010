package model.data_structures;

import java.util.ArrayList;
import java.util.Iterator;

public class HashTable <Key extends Comparable<Key>,Value> {
	
	
//array usado para almacenar cadenas
	private ArrayList<HashNodo> arrayHash; 
  
    // capacidad actual del arreglo 
    private int capacidad; 
  
    // tamano actual del arreglo
    private int tamano; 
    
    //nodosHash que se van a usar en metdos
    private HashNodo head;
    private HashNodo temp;
    // Constructor
    public HashTable() 
    { 
        arrayHash = new ArrayList<>(); 
        capacidad = 10; 
        tamano = 0; 
        head=null;
  
        for (int i = 0; i < capacidad; i++) 
            arrayHash.add(null); 
    } 
  
    //metodos
    
    
    //Se aplica funcion del hash rara y se saca un indice segun llave para el array
    public int getHashcodeIndex(Key key) 
    { 
        int hashCode = key.hashCode(); 
        int index = hashCode % capacidad; 
        return index; 
    } 
    public int darTamanoActual() { 
    	
    	return tamano; 
    	} 
    
    
    
    public boolean isEmpty() { 
    	return darTamanoActual() == 0;
    	} 
  
    
   
  
    // remueve una llave y si no existe da null
    public Value delete(Key key) 
    { 
        int arrayIndex = getHashcodeIndex(key); 
  
        // Get head of chain 
        HashNodo head = arrayHash.get(arrayIndex); 
  
        // Search for key in its chain 
        HashNodo prev = null; 
        while (head != null) 
        { 
            if (head.darllave().equals(key)) {
                break; }
  
            prev = head; 
            head = head.darSiguente(); 
        } 
  
        if (head == null) {
            return null; 
        }
        tamano--; 
  
        if (prev != null) 
            prev.sig= head.darSiguente(); 
        else
            arrayHash.set(arrayIndex, (HashNodo) head.darDato()); 
  
        return (Value) head.darDato(); 
    } 
  
    public Value get(Key key) 
    { 
        int bucketIndex = getHashcodeIndex(key); 
        HashNodo<Key, Value> head = arrayHash.get(bucketIndex); 
  
        while (head != null) 
        { 
            if (head.darllave().equals(key)) {
                return head.darDato(); 
            }
            
            
            head = head.darSiguente(); 
        } 
  
        return null; 
    } 
  
    public void put(Key key, Value value) 
    { 
        int bucketIndex = getHashcodeIndex(key); 
        head = arrayHash.get(bucketIndex); 
  
        // revisa si llave existe , si existe cambia el dato, si no
        while (head != null) 
        { 
            if (head.darllave().equals(key)) 
            { 
                head.datoActual= value; 
                return; 
                
            } 
            head = head.darSiguente(); 
        } 
  
        tamano++; 
        head = arrayHash.get(bucketIndex); 
        HashNodo<Key, Value> newNode = new HashNodo<Key, Value>(key, value); 
      head.sig=newNode;
      head= newNode;
        arrayHash.set(bucketIndex, newNode); 
        
  //si se sobrepsa capacidad se hace mayor
        if (tamano/capacidad >= 0.7) 
        { 
            ArrayList<HashNodo> temp = arrayHash; 
            arrayHash = new ArrayList<>(); 
            capacidad = 2 * capacidad; 
            tamano = 0; 
            for (int i = 0; i < capacidad; i++) 
                arrayHash.add(null); 
  
            for (HashNodo<Key, Value> headNode : temp) 
            { 
                while (headNode != null) 
                { 
                    put(headNode.llave, headNode.datoActual); 
                    headNode = headNode.sig; 
                } 
            } 
        } }}
