package Materia.controllers;

import Materia.models.Node;

public class BinaryTree {
    private Node root;
    private int peso;

    public BinaryTree() {
        this.root = null;
        this.peso=0;
    }

    //insertar datos en el arbol
    public void insert(int value){

        root = insertRec(root, value);
        peso++;
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

    public int getHeighTree(){
        return getHeigRec(root);
    }
    public int getHeigRec(Node node){
        if (node==null){
            return 0;
        }
        int leftHeight = getHeigRec(node.getHijoIzquierda());
        int rightHeight = getHeigRec(node.getHijoDerecha());
        return Math.max(leftHeight, rightHeight)+1;
        
        //if (leftHeight>rightHeight?leftHeight+1:rightHeight+1)
        /*if (leftHeight>rightHeight) {
            return leftHeight+1;
        }else{
            return rightHeight+1;
        }*/
    }

    //imprimir la altura de cada metodo con inorder
    public void imprimirInOrderAlt(){
        imprimirInOrderRecAlt(root);
    }
    private void imprimirInOrderRecAlt(Node node){
        if(node!=null){
            imprimirInOrderRecAlt(node.getHijoIzquierda());
            int altura= getHeigRec(node);
            System.out.print(node.getValue()+" (h = "+altura+" ), ");
            imprimirInOrderRecAlt(node.getHijoDerecha());
        }
    }

    public int altura1(){
        return altura(root);
    }
    //factor de equilibrio de cana nodo
    public void factEquilibrio(){
        factEquilibrioRec(root);
    }
    public int altura(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(altura(node.getHijoIzquierda()), altura(node.getHijoDerecha()));
    } 
    public void factEquilibrioRec(Node node){
        if (node == null)
            return;

        factEquilibrioRec(node.getHijoIzquierda());
        int alturaIzquierda = altura(node.getHijoIzquierda());
        int alturaDerecha = altura(node.getHijoDerecha());

        int factorEquilibrio = alturaIzquierda - alturaDerecha;

        System.out.print(node.getValue() + "( FE: " + factorEquilibrio+" ), ");
        factEquilibrioRec(node.getHijoDerecha());
    }

    //ver si un arbol esta equilibrado
    public int estaEquilibrado(Node node) {
        if (node == null)
            return 0;

        int altIzq = estaEquilibrado(node.getHijoIzquierda());
        if (altIzq == -1) return -1;

        int altDer = estaEquilibrado(node.getHijoDerecha());
        if (altDer == -1) return -1;

        if (Math.abs(altIzq - altDer) > 1)
            return -1;  // No está equilibrado

        return 1 + Math.max(altIzq, altDer);
    }

    
    // Retorna true si el árbol está equilibrado
    public boolean esAVL() {
        return estaEquilibrado(root) != -1;
    }

    public int imprimirNodosDesequilibrados(Node node) {
        if (node == null)
            return 0;

        int altIzq = imprimirNodosDesequilibrados(node.getHijoIzquierda());
        int altDer = imprimirNodosDesequilibrados(node.getHijoDerecha());

        int factor = altIzq - altDer;

        if (Math.abs(factor) > 1) {
            System.out.println("\n Nodo " + node.getValue() + " no está equilibrado (FE = " + factor + ")");
        }

        return 1 + Math.max(altIzq, altDer);
    }
    public void nodoDes(){
        imprimirNodosDesequilibrados(root);
    }

    public Node getRoot() {
        return root;
    }

    public int getPeso() {
        return peso;
    }

}
