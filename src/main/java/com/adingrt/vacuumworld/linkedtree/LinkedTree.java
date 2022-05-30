package com.adingrt.vacuumworld.linkedtree;

import com.adingrt.vacuumworld.exceptions.EmptyTreeException;
import com.adingrt.vacuumworld.exceptions.InaccessibleException;
import com.adingrt.vacuumworld.exceptions.InvalidOperationException;
import java.util.ArrayList;
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
        Iterable<IPosition<E>> pos = (Iterable<IPosition<E>>) this.positions();
        List<IPosition<E>> result = new ArrayList<IPosition<E>>();
        for(IPosition<E> p : pos) {
            result.add(p);
        }
        return result.iterator();
    }

    @Override
    public Iterator positions() {
        List<IPosition<E>> list = new ArrayList<IPosition<E>>();
        this.preorden(this.root, list);
        return (Iterator) list;
    }

    @Override
    public IPosition<E> root() {
        if (root == null) {
            throw new EmptyTreeException("El arbol esta vacio");
        } else {
            return (IPosition<E>) this.root;
        }
    }

    @Override
    public IPosition<E> parent(IPosition<E> p) {
        TreeNode<E> node = checkPosition(p);
        TreeNode<E> parent = node.getParent();
        if (parent == null) {
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
        if ((childrens == null) || (childrens.isEmpty())) {
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
        E aux = node.getElement();
        node.setElement(element);
        return aux;
    }

    public IPosition<E> add(IPosition<E> parent, E element) {
        TreeNode<E> nodeParent = checkPosition(parent);
        TreeNode<E> newNode = this.createNode(nodeParent, element, new ArrayList<TreeNode<E>>());
        List<TreeNode<E>> childrens = nodeParent.getChildrens();
        childrens.add(newNode);
        this.size++;
        return (IPosition<E>) newNode;
    }

    public IPosition<E> addRoot(E element) {
        TreeNode<E> newNode = this.createNode(null, element, new ArrayList<TreeNode<E>>());
        this.root = newNode;
        this.size++;
        return (IPosition<E>) newNode;
    }

    public IPosition<E> remove(IPosition<E> p) {
        TreeNode<E> node = checkPosition(p);
        TreeNode<E> nodeParent = node.getParent();
        List<TreeNode<E>> childrens = nodeParent.getChildrens();
        childrens.remove(node);
        this.size--;
        return (IPosition<E>) node;
    }

    // Castea un Position a un TreeNode si es posible
    protected TreeNode<E> checkPosition(IPosition<E> p) {
        if ((p == null)) {
            throw new InvalidOperationException("Posicion del Nodo invalida!");
        }
        TreeNode<E> n = (TreeNode<E>) p;
        return n;
    }

    protected TreeNode<E> createNode(TreeNode<E> parent, E element, List<TreeNode<E>> childrens) {
        TreeNode<E> newNode = new TreeNode<E>(parent, element, childrens);
        return newNode;
    }
    
    public void preorden(IPosition<E> p, List<IPosition<E>> list) {
        list.add(p);
        TreeNode<E> node = checkPosition(p);
        p.getElement().toString();
        if(!this.isLeaf(p)) {
            for(IPosition<E> h: node.getChildrens()) {
                preorden(h,list);
            }
        }
    }

}
