import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GrafoMutavel extends Grafo {
    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso
     * de nome não informado
     * (string vazia), recebe o nome genérico "Grafo"
     *
     * @param nome
     */
    public GrafoMutavel(String nome) {
        super(nome);
    }

    public void carregar(String nomeArquivo) throws FileNotFoundException {
        File file = new File(nomeArquivo);
        Scanner fileReader = new Scanner(file);

        String line = null;
        String[] tokens;
        int key;

        while (fileReader.hasNextLine()){
            line = fileReader.nextLine();
            tokens = line.split("\\D+");

            Vertice origem = new Vertice(Integer.parseInt(tokens[0]));
            vertices.add(Integer.parseInt(tokens[0]), origem);

            Vertice destino = new Vertice(Integer.parseInt(tokens[1]));
            vertices.add(Integer.parseInt(tokens[1]), destino);

            origem.addAresta(Integer.parseInt(tokens[1]));
        }
    }
}
