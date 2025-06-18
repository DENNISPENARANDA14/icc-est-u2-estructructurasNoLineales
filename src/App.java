import java.nio.channels.Pipe.SourceChannel;

import Materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
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
        System.out.println("PREODER");
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

    }
}
