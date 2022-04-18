package com.adingrt.vacuumworld.linkedtree;

import java.util.Iterator;

/**
 *
 * @author Adin Rubio
 */
public interface ITree<E> {
    public int size();
    public boolean isEmpty();
    public Iterator iterator(); //Devuelve un iterador con todos sus elementos.
    public Iterator positions(); //Devuelve una coleccion de todos sus nodos.
    public IPosition<E> root(); //Devuelve la raiz del arbol
    public IPosition<E> parent(IPosition<E> p); //Devuelve el padre del nodo.
    public Iterator children(IPosition<E> p); //Devuelve una lista con todos sus nodos hijo de un nodo.
    public boolean isLeaf(IPosition<E> p); //Devuelve si un nodo es hoja o no.
    public boolean isInternal(IPosition<E> p); //Devuelve si un nodo es interno o no.
    public boolean isRoot(IPosition<E> p); //Devuelve si el nodo es raiz o no.
    
    public E replace(IPosition<E> p, E element); //Reemplaza el elemento del nodo p por el elemento e.
}
