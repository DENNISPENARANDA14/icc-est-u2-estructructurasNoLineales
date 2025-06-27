package Materia.models;

public class Node {
    private int value;
    private Node hijoIzquierda;
    private Node hijoDerecha;
    private int Height;
    
    public Node(int value) {
        this.value = value;
        this.hijoIzquierda = null;
        this.hijoDerecha = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getHijoIzquierda() {
        return hijoIzquierda;
    }

    public void setHijoIzquierda(Node hijoIzquierda) {
        this.hijoIzquierda = hijoIzquierda;
    }

    public Node getHijoDerecha() {
        return hijoDerecha;
    }

    public void setHijoDerecha(Node hijoDerecha) {
        this.hijoDerecha = hijoDerecha;
    }
    

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }
    
    
}
