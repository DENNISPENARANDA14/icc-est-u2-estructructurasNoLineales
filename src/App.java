import java.nio.channels.Pipe.SourceChannel;

import Materia.controllers.AVLTree;
import Materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        AVLTree abl=new AVLTree();
        abl.inser(5);
        abl.inser(20);
        abl.inser(15);
    }
    
    private static void app(){
        System.out.println("Hello, World!");
        BinaryTree ab = new BinaryTree();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);
        
        /*System.out.println("PREODER");
        ab.imprimirPreorder();
        System.out.println("\n INORDER");
        ab.imprimirInOrder();
        System.out.println("\n POSTORDER");
        ab.imprimirPosOrder();

        if (ab.findValue(23)!=null){
            System.out.println("\n Encontro el numero 23");
        }
        else{
            System.out.println("No se encontro el valor 23");
        }
        if (ab.findValue(77)!=null){
            System.out.println("Encontro el numero 77");
        }else{
            System.out.println("No se encontro el valor 77");
        }
        System.out.println("inorder por altura");
        ab.imprimirInOrderAlt();

        System.out.println("factor de equilibrio de cada nodo");
        ab.factEquilibrio();*/
        System.out.println("nombre: DENNIS ALEJANDRO PENARANDA TELLO");
        System.out.println("Peso: " + ab.getPeso());
        System.out.println("Altura: " + ab.altura1());
        System.out.println("recorrido inorder");
        ab.imprimirInOrder();
        System.out.println("\n recorrido inorder con altura");
        ab.imprimirInOrderAlt();
        System.out.println("\n Recorrido inorder con factor de equilibrio");
        ab.factEquilibrio();
        if (ab.esAVL()){
            System.out.println("\n arbol esta equilibrado = TRUE");
        }
        else{
            System.out.println("\\n arbol esta equilibrado = FALSE");
        }
        if (ab.findValue(15)!=null){
            System.out.println("\n Existe el nodo 15: TRUE");
        }
        else{
            System.out.println("Existe el nodo 15: FALSE");
            System.out.println("Agregamos el nodo 15");
            ab.insert(15);
        }
        if (ab.esAVL()){
            System.out.println("\n arbol esta equilibrado = TRUE");
        }
        else{
            System.out.println("arbol esta equilibrado = FALSE");
        }
        ab.factEquilibrio();
        ab.nodoDes();
    }

}
