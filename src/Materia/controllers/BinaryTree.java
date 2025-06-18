package Materia.controllers;

import Materia.models.Node;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    //insertar datos en el arbol
    public void insert(int value){

        root = insertRec(root, value);
    }
    
    private Node insertRec(Node padre, int value){
        if (padre==null){
            return new Node(value);
        }if (value < padre.getValue()){
            //me voy a la izquierda
            Node newNode = insertRec(padre.getHijoIzquierda(), value);
            padre.setHijoIzquierda(newNode);
        }else if (value > padre.getValue()){
            padre.setHijoDerecha(insertRec(padre.getHijoDerecha(), value));
        }
        return padre;
    }

    public void imprimirPreorder(){
        imprimirPreOrderRec(root);
    }
    private void imprimirPreOrderRec(Node node){
        if(node!=null){
            System.out.print(node.getValue() + " , ");
            imprimirPreOrderRec(node.getHijoIzquierda());
            imprimirPreOrderRec(node.getHijoDerecha());
        }
    }

    public void imprimirPosOrder(){
        imprimirPosOrderRec(root);
    }
    private void imprimirPosOrderRec(Node node){
        if(node!=null){
            imprimirPosOrderRec(node.getHijoIzquierda());
            imprimirPosOrderRec(node.getHijoDerecha());
            System.out.print(node.getValue() + " , ");
        }
    }
    public void imprimirInOrder(){
        imprimirInOrderRec(root);
    }
    private void imprimirInOrderRec(Node node){
        if(node!=null){
            imprimirInOrderRec(node.getHijoIzquierda());
            System.out.print(node.getValue() + " , ");
            imprimirInOrderRec(node.getHijoDerecha());
        }
    }

    public Node findValue(int value){
        return findValueRec(root,value);
    }
    private Node findValueRec(Node node,int value){
        if(node == null || node.getValue()==value){
            return node;
        }
        if(value < node.getValue()){
            return findValueRec(node.getHijoIzquierda(),value);
        }
        return findValueRec(node.getHijoDerecha(), value);
    }
}
