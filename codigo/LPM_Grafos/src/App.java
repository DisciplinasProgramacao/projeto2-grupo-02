import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        GrafoMutavel g = new GrafoMutavel("Grafo de Teste");
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira o nome do arquivo: ");
        String filename = scan.nextLine();

        g.carregar(filename);
    }
}
