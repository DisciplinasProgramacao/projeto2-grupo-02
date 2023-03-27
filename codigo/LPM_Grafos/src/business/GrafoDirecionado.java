package business;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GrafoDirecionado extends GrafoMutavel {

    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso
     * de nome não informado
     * (string vazia), recebe o nome genérico "Grafo"
     *
     * @param nome Nome do grafo
     */
    public GrafoDirecionado(String nome) {
        super(nome);
    }

    /**
     * Lê conteudo de um arquivo .txt e instancia vértices conforme descrito,
     * adicionando-os à ABB. Em seguida, adiciona aresta divergindo do vértice
     * de origem e convergindo no vértice de destino.
     *
     * @param nomeArquivo Nome do arquivo a ser lido
     */
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

    /**
     * Adiciona uma aresta entre dois vértices do grafo, caso os dois vértices
     * existam no grafo.
     * Caso a aresta já exista, ou algum dos vértices não existir, o comando é
     * ignorado e retorna FALSE.
     *
     * @param origem  Vértice de origem
     * @param destino Vértice de destino
     * @param peso    Peso da aresta
     * @return TRUE se foi inserida, FALSE caso contrário
     */
    @Override
    public boolean addAresta(int origem, int destino, int peso){
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);

        if (saida != null && chegada != null) {
            adicionou = (saida.addAresta(destino, peso) && chegada.addAresta(origem, peso));
        }

        return adicionou;
    }

    // TODO Implementar método
    @Override
    public Aresta removeAresta(int origem, int destino) {
        return null;
    }

}
