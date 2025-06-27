package Materia.controllers;

import java.nio.channels.Pipe.SourceChannel;

import Materia.models.Node;

public class AVLTree {
    private Node root;

    public AVLTree(){
        this.root = null;
    }

    public void insert(int value){
        root =  insertRec(root, value);
    }

    private Node insertRec(Node node, int value){
        if(node == null){
            Node newNode = new Node(value);
            newNode.setHeight(1);
            System.out.println("Nodo insertado -> " + value + " con balance " + getBalance(newNode));
            return newNode;
        }

        if(value <= node.getValue()){
            Node newNode = insertRec(node.getHijoIzquierda(), value);
            node.setHijoIzquierda(newNode);
        } else if (value > node.getValue()){
            Node newNode = insertRec(node.getHijoDerecha(), value);
            node.setHijoDerecha(newNode);
        } else {
            return node;
        }

        System.out.println("Nodo actual -> " + node.getValue());
        int altura = 1 + Math.max(height(node.getHijoIzquierda()), height(node.getHijoDerecha()));
        node.setHeight(altura);
        System.out.println("   Altura -> " + node.getHeight());

        int balance = getBalance(node);
        System.out.println("   Balance -> " + balance);

        // Caso Izquierda Izquierda
        if (balance > 1 && value < node.getHijoIzquierda().getValue()) {
            System.out.println("Cambio");
            return rightRotation(node);
        }

        // Caso Derecha Derecha
        if (balance < -1 && value > node.getHijoDerecha().getValue()) {
            System.out.println("Cambio");
            return leftRotation(node);
        }

        // Caso Izquierda Derecha
        if (balance > 1 && value > node.getHijoIzquierda().getValue()) {
            System.out.println("Cambio");
            node.setHijoIzquierda(leftRotation(node.getHijoIzquierda()));
            System.out.println("Rotacion Simple Derecha");
            return rightRotation(node);
        }

        // Caso Derecha Izquierda
        if (balance < -1 && value < node.getHijoDerecha().getValue()) {
            System.out.println("Cambio");
            node.setHijoDerecha(rightRotation(node.getHijoDerecha()));
            System.out.println("Rotacion Simple Izquierda");
            return leftRotation(node);
        }

        return node;
    }

    private int height(Node node){
        if (node == null)
            return 0;
        return node.getHeight();
    }

    private int getBalance(Node node){
        if (node == null)
            return 0;
        int leftHeight = height(node.getHijoIzquierda());
        int rightHeight = height(node.getHijoDerecha());
        return leftHeight - rightHeight;
    }

    private Node leftRotation(Node x){
        Node y = x.getHijoDerecha();
        Node temp = y.getHijoIzquierda();

        System.out.println("Rotacion IZQ en nodo: " + x.getValue()
                + ", con balance = " + getBalance(x));

        y.setHijoIzquierda(x);
        x.setHijoDerecha(temp);

        x.setHeight(Math.max(height(x.getHijoIzquierda()), height(x.getHijoDerecha())) + 1);
        y.setHeight(Math.max(height(y.getHijoIzquierda()), height(y.getHijoDerecha())) + 1);

        System.out.println("Nueva raiz despues de la rotación " + y.getValue());

        return y;
    }

    private Node rightRotation(Node y){
        Node x = y.getHijoIzquierda();
        Node temp = x.getHijoDerecha();

        System.out.println("Rotacion DER en nodo: " + y.getValue()
                + ", con balance = " + getBalance(y));

        x.setHijoDerecha(y);
        y.setHijoIzquierda(temp);

        y.setHeight(Math.max(height(y.getHijoIzquierda()), height(y.getHijoDerecha())) + 1);
        x.setHeight(Math.max(height(x.getHijoIzquierda()), height(x.getHijoDerecha())) + 1);

        System.out.println("Nueva raiz despues de la rotación " + x.getValue());

        return x;
    }
}
