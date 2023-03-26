import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class GrafoMutavel extends Grafo {
    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso
     * de nome não informado
     * (string vazia), recebe o nome genérico "Grafo"
     *
     * @param nome Nome do grafo
     */
    public GrafoMutavel(String nome) {
        super(nome);
    }

    /**
     * Lê conteudo de um arquivo .txt e instancia vértices conforme descrito,
     * adicionando-os à ABB. Método abstrato cuja implementação varia em
     * GrafoDirecionado e GrafoNaoDirecionado
     *
     * @param nomeArquivo Nome do arquivo a ser lido
     */
    public abstract void carregar(String nomeArquivo) throws FileNotFoundException;

    /**
     * Adiciona um vértice com o id especificado. Ignora a ação e retorna false se
     * já existir
     * um vértice com este id
     *
     * @param id O identificador do vértice a ser criado/adicionado
     * @return TRUE se houve a inclusão do vértice, FALSE se já existia vértice com
     *         este id
     */
    public boolean addVertice(int id) {
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    /**
     *
     * @param id O Identificador do vértice a ser removido
     * @return Vértice removido
     */
    public Vertice removeVertice(int id) {
        return vertices.remove(id);
    }

    public abstract boolean addAresta(int origem, int destino, int peso);

    public abstract Aresta removeAresta(int origem, int destino);
}
