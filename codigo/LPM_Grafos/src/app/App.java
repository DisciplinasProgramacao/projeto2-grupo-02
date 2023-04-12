import java.util.Scanner;

import business.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira o nome do arquivo. Você pode encontrar arquivos de grafos na pasta projeto2-grupo-02\\codigo\\LPM_Grafos\\src\\grafos: ");
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
        

        System.out.println("Escolha uma aresta para ser removida.");
        System.out.println("\nOrigem: ");
        int removerArestaOrigem = Integer.parseInt(scan.nextLine());
        System.out.println("\nDestino: ");
        int removerArestaDestino = Integer.parseInt(scan.nextLine());

        grafo.removeAresta(removerArestaOrigem, removerArestaDestino);

        System.out.println("Escolha a origem e destino de uma nova aresta a ser adicionada.");
        System.out.println("\nOrigem: ");
        int adicionarArestaOrigem = Integer.parseInt(scan.nextLine());
        System.out.println("\nDestino: ");
        int adicionarArestaDestino = Integer.parseInt(scan.nextLine());
        
        grafo.addAresta(adicionarArestaOrigem, removerArestaDestino, -1);

        grafo.salvar(filename);
        System.out.println("As alterações no grafo foram salvas!");

        scan.close();
    }
}
