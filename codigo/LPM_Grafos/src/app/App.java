import java.util.Scanner;

import business.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira o nome do arquivo: ");
        String filename = scan.nextLine();

        System.out.println("Selecione o tipo de grafo: ");
        System.out.println("1 - Direcionado e não ponderado \n2 - Direcionado e ponderado \n3- Não direcionado e não ponderado \n4 - Não direcionado e ponderado");
        int op = Integer.parseInt(scan.nextLine());

        switch (op){
            case 1:
                GrafoDirecionado grafoDirecionado = new GrafoDirecionado("");
                grafoDirecionado.carregar(filename);
                break;
            case 2:
                // A implementar
                break;
            case 3:
                GrafoNaoDirecionado grafoNaoDirecionado = new GrafoNaoDirecionado("");
                grafoNaoDirecionado.carregar(filename);
                break;
            case 4:
                // A implementar
                break;
        }

    }
}
