import java.util.Scanner;

import business.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira o nome do arquivo: ");
        String filename = scan.nextLine();

        System.out.println("Selecione o tipo de grafo: ");
        System.out.println("1 - Direcionado \n2 - Não direcionado");
        int op = Integer.parseInt(scan.nextLine());

        GrafoMutavel grafo = null;

        switch (op){
            case 1:
                grafo = new GrafoDirecionado("");
                grafo.carregar(filename);
                break;
            case 2:
                grafo = new GrafoNaoDirecionado("");
                grafo.carregar(filename);
                break;
        }

        scan.close();
    }
}
