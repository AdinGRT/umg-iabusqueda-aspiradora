package com.adingrt.vacuumworld.logic;

/**
 * @author Adin Rubio
 */
public class Aspiradora {
    private String id;
    private int posicionActual; // 0 = izquierda | 1 = derecha
    
    public Aspiradora() {
    }

    public Aspiradora(String id, int posicionActual) {
        this.id = id;
        this.posicionActual = posicionActual;
    }
    
    public int[] limpiar(int[] estado){
        if(estado[0] == 0) {
            estado[1] = 1;
        } else if (estado[0] == 1) {
            estado[2] = 1;
        }
        return estado;
    }
    public int[] movIzq(int[] estado){
        estado[0] = 0;
        return estado;
    }
    public int[] movDer(int[] estado){
        estado[0] = 1;
        return estado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aspiradora{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
