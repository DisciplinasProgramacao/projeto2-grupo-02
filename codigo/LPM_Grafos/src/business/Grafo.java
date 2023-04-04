package business;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** 
 * MIT License
 *
 * Copyright(c) 2021-23 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * Classe básica para um Grafo simples não direcionado.
 */
public abstract class Grafo {
    public final String nome;
    protected ABB<Vertice> vertices;

    public static Grafo grafoCompleto(int ordem) {

        GrafoCompleto g = new GrafoCompleto(ordem, "GrafoCompleto");

        return g;

    }

    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso
     * de nome não informado
     * (string vazia), recebe o nome genérico "Grafo"
     */
    public Grafo(String nome) {
        if (nome.length() == 0)
            this.nome = "Grafo";
        else
            this.nome = nome;
        this.vertices = new ABB<>();
    }

    /**
     * Retorna o nome do grafo (string), caso seja necessário em outras
     * classes/sistemas
     * 
     * @return O nome do grafo (uma string)
     */
    public String nome() {
        return this.nome;
    }

    public void salvar(String nomeArquivo) {
        File file = new File(nomeArquivo);

        try {

            FileWriter fw = new FileWriter(file);

            Vertice[] abbVertices = vertices.allElements(new Vertice[] {});

            for (Vertice vertice : abbVertices) {

                Aresta[] allArestas = vertice.todasAsArestas();

                for (Aresta aresta : allArestas) {

                    Vertice destino = new Vertice(aresta.destino());

                    fw.write(vertice.getId() + " " + destino.getId() + " " + aresta.peso());
                    
                }
            }

            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param idVertice O indentificado do vértice procurado
     * @return Vértice procurado ou null caso não exista
     */
    public Vertice existeVertice(int idVertice) {
        return vertices.find(idVertice);
    }

    /**
     * Verifica se existe uma aresta entre A e B
     * 
     * @param verticeA Vertice de partida
     * @param verticeB Vertice de chegada
     * @return A aresta ente A e B ou null caso não exista
     */
    public Aresta existeAresta(int verticeA, int verticeB) {
        Vertice verticePartida = vertices.find(verticeA);
        return verticePartida.existeAresta(verticeB);
    }

    /**
     * Verifica se um grafo é completo, supondo que este seja conexo
     * @return Resultado da comparação entre o somatório de arestas com a expressão (n*(n-1))/2
     */
    public boolean completo() {
        Vertice[] todosVertices = new Vertice[1000]; 
        todosVertices = vertices.allElements(todosVertices); 
        int n = ordem();
        int total = 0;
        
        for (Vertice vertice : todosVertices) {
            total += vertice.grau();
        }

        return (total != (n*(n-1))/2);
    }

    /**
     * Gera um subgrafo a partir das indicações dos vértices do grafo original
     * 
     * @param vertices Lista de vértices do grafo original
     * @return Um subrgrafos com os vértices da lista
     */
    public Grafo subGrafo(Lista<Integer> vertices) {
        GrafoDirecionado subgrafo = new GrafoDirecionado("Subgrafo de " + this.nome);
        subgrafo.vertices = this.vertices;

        boolean estaNaLista = false;
        int id;

        Integer[] array = new Integer[vertices.size()];
        Integer[] allData = vertices.allElements(array);

        Lista<Integer> verticesExcluidos = new Lista<Integer>();

        for (int i = 1; i <= subgrafo.vertices.size(); i++) {
            for (int j = 0; j < allData.length; j++) {
                if (i == allData[j]) {
                    estaNaLista = true;
                    break;
                }
            }

            if (estaNaLista == false) {
                verticesExcluidos.add(i);
            }

            estaNaLista = false;
        }

        int tamanho = verticesExcluidos.size();

        for (int i = 0; i < tamanho; i++) {
            id = verticesExcluidos.remove(0);
            subgrafo.removeVertice(id);
        }

        return subgrafo;
    }

    public int tamanho() {
        return Integer.MIN_VALUE;
    }

    public int ordem() {
        return this.vertices.size();
    }

}
