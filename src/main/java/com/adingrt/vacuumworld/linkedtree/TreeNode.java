package com.adingrt.vacuumworld.linkedtree;

import java.util.List;

/**
 *
 * @author Adin Rubio
 */
public class TreeNode<E> implements IPosition<E>{

    private TreeNode<E> parent; //Nodo padre
    private E element; //Estados
    private List<TreeNode<E>> childrens; //Nodos
    
    public TreeNode(TreeNode<E> parent, E element, List<TreeNode<E>> childrens) {
        this.parent = parent;
        this.element = element;
        this.childrens = childrens;
    }
    
    @Override
    public E getElement() {
        return element;
    }
    
     public void setElement(E element) {
        this.element = element;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    public List<TreeNode<E>> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<TreeNode<E>> childrens) {
        this.childrens = childrens;
    }
}
