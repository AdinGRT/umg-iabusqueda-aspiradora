package com.adingrt.vacuumworld.logic;

import com.adingrt.vacuumworld.linkedtree.ITree;
import com.adingrt.vacuumworld.linkedtree.LinkedTree;
import com.adingrt.vacuumworld.linkedtree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adin Rubio
 */
public class SearchLogic<E> {

    private static final char SUCKDIRT = 's';
    private static final char MOVELEFT = 'l';
    private static final char MOVERIGHT = 'r';

    private VacuumWorld world;
    private VacuumCleaner vacuum;

    private VacuumWorldState initialState;
    private VacuumWorldState[] finalStates;

    private boolean[][] room;
    
    private LinkedTree treeVacuumWorldStates;

    public SearchLogic(int dimRoomRow, int dimRoomColumn) {
        this.world = new VacuumWorld(new boolean[dimRoomRow][dimRoomColumn], true);
        this.vacuum = new VacuumCleaner(new Coordinates(0, 0));
        this.initialState = new VacuumWorldState(this.vacuum, this.world);
        this.finalStates = new VacuumWorldState[2];
        this.finalStates[0] = new VacuumWorldState(new VacuumCleaner(new Coordinates(0, 0)), new VacuumWorld(new boolean[dimRoomRow][dimRoomColumn], false));
        this.finalStates[1] = new VacuumWorldState(new VacuumCleaner(new Coordinates(0, 1)), new VacuumWorld(new boolean[dimRoomRow][dimRoomColumn], false));
    }

    //AGREGA NODOS AL ARBOL SEGUN ESTADO GENERADO
    private void addStatesToTree(LinkedTree treeVacuumWorldStates, VacuumWorldState stateElementParent, TreeNode<E> parentNode, char operador) {
        //GENERAR NUEVO ESTADO CON OPERADOR DADO
        System.out.println("Estado Actual: " + stateElementParent.toString());
        VacuumWorldState stateElementChild = new VacuumWorldState();
        stateElementChild.copyState(stateElementParent); //COPIAR ESTADO DEL QUE VIENE
        stateElementChild.changeState(operador);//ESTADO NUEVO GENERADO
        System.out.println("Estado Generado: " + stateElementChild.toString() + "\n\n");
        //COMPARAR ESTADOS PARA AGREGAR NODO A ARBOL O NO
        if (!treeVacuumWorldStates.isLeaf(parentNode)) {
            System.out.println("TEST SI NO ES HOJA: \n");
            for (TreeNode<E> cN : parentNode.getChildrens()) {
                
                this.addStatesToTree(treeVacuumWorldStates, stateElementChild, cN, operador);
            }
        } else if (!stateElementChild.isTheSameGeneratedState(stateElementParent)) {
            System.out.println("TEST SI ES HOJA: \n");
            TreeNode<E> childNode = (TreeNode<E>) treeVacuumWorldStates.add(parentNode, stateElementChild);
            this.addStatesToTree(treeVacuumWorldStates, stateElementChild, childNode, operador);
        }
    }

    
    public void generateTree(int level, List<Character> operators) {
        
        VacuumWorldState currState = new VacuumWorldState();
        currState.copyState(this.initialState);
               
        this.treeVacuumWorldStates = new LinkedTree<>();
        
        TreeNode<E> currNode = (TreeNode<E>) this.treeVacuumWorldStates.addRoot(currState);
        System.out.println("TEST NODO: " + currNode.getElement());
        
        for (int i = 0; i < level; i++) {
            System.out.println("FOR i: " + i);
            for (Character op : operators) {
                System.out.println("op = " + op);
                this.addStatesToTree(this.treeVacuumWorldStates, currState, currNode, op);
            }
        }
        
        System.out.println("\n\n\nRECORRIDO: \n\n");
        this.treeVacuumWorldStates.preorden(currNode, new ArrayList());
    }

    
    public Boolean isGoal(VacuumWorldState state) {
        return state.isTheSameGeneratedState(this.finalStates[0]) || state.isTheSameGeneratedState(this.finalStates[1]);
    }

    
//    public List<E> getRoute() {
//        List<VacuumWorldState> routes = new ArrayList<>();
//        VacuumWorldState currState = new VacuumWorldState(this.initialState.getVacuum(), this.initialState.getWorld());
//        VacuumWorldState auxState;
//        while (!this.isGoal(currState)) {
//            //MOVER IZQUIERDA
//            auxState = new VacuumWorldState(currState.getVacuum(), currState.getWorld());
//            auxState.getVacuum().move('l');
//            routes.add(auxState);
//            //MOVER DERECHA
//            auxState = new VacuumWorldState(currState.getVacuum(), currState.getWorld());
//            auxState.getVacuum().move('d');
//            routes.add(auxState);
//            //LIMPIAR
//            auxState = new VacuumWorldState(currState.getVacuum(), currState.getWorld());
//            auxState.getVacuum().suckdirt();
//            routes.add(auxState);
//        }
//        return (List<E>) routes;
//    }

}
