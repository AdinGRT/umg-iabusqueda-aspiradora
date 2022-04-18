package com.adingrt.vacuumworld.linkedtree;

import java.util.List;

/**
 *
 * @author Adin Rubio
 */
public class TreeNode<E> implements IPosition<E>{

    private TreeNode<E> parent;
    private E element;
    private List<TreeNode<E>> childrens;
    
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
