package com.adingrt.vacuumworld.linkedtree;

import com.adingrt.vacuumworld.exceptions.EmptyTreeException;
import com.adingrt.vacuumworld.exceptions.InaccessibleException;
import com.adingrt.vacuumworld.exceptions.InvalidPositionException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Adin Rubio
 */
public class LinkedTree<E> implements ITree<E> {
    private TreeNode<E> root;
    private int size;
    
    public LinkedTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator positions() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public IPosition<E> root() {
        if(root == null) {
            throw new EmptyTreeException("El arbol esta vacio");
        } else {
            return (IPosition<E>) this.root;
        }
    }

    @Override
    public IPosition<E> parent(IPosition<E> p) {
        TreeNode<E> node = checkPosition(p);
        TreeNode<E> parent = node.getParent();
        if(parent == null) {
            throw new InaccessibleException("No tiene padre!");
        }
        return (IPosition<E>) parent; 
    }

    @Override
    public Iterator children(IPosition<E> p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isLeaf(IPosition<E> p) {
        TreeNode<E> node = checkPosition(p);
        List<TreeNode<E>> childrens = node.getChildrens();
        if((childrens == null)||(childrens.isEmpty())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isInternal(IPosition<E> p) {
        if (this.isLeaf(p)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isRoot(IPosition<E> p) {
        TreeNode<E> node = checkPosition(p);
        return (node == this.root);
    }

    @Override
    public E replace(IPosition<E> p, E element) {
        TreeNode<E> node = checkPosition(p);
        node.setElement(element);
        return node.getElement();
    }
    
    
    // Castea un Position a un TreeNode si es posible
    protected TreeNode<E> checkPosition(IPosition<E> p) {
        if((p == null) || (p instanceof TreeNode)) {
            throw new InvalidPositionException("Posicion del Nodo invalida!");
        }
        TreeNode<E> n = (TreeNode<E>) p;
        return n;
    }
    
}
