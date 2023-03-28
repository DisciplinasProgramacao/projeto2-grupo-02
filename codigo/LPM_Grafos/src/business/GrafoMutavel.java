package business;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
        //Remover arestas que apontam para o vértice removido antes de remover o vértie.
        return vertices.remove(id);
    }

    public void salvar(String nomeArquivo) {
        File file = new File("./" + nomeArquivo);
        
        try {
        	
			FileWriter fw = new FileWriter(file);

			Vertice[] abbVertices = vertices.allElements(new Vertice[] {});

	        for (Vertice vertice : abbVertices) {
	
	            Aresta[] allArestas = vertice.todasAsArestas();
	
	            for (Aresta aresta : allArestas) {
	
	                Vertice destino = new Vertice(aresta.destino());
	                
	                if (aresta.peso() == -1) {
	                	fw.write(vertice.getId() + " " + destino.getId());
	                } else {
	                	fw.write(vertice.getId() + " " + destino.getId() + " " + aresta.peso());
	                }
	            }
	        }
	        
	        fw.close();
	        
        } catch (IOException e) {
			e.printStackTrace();
		}
    }

    public abstract boolean addAresta(int origem, int destino, int peso);


    public abstract Aresta removeAresta(int origem, int destino);
}
