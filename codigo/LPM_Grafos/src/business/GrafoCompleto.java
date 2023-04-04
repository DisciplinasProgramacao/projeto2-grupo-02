package business;

public class GrafoCompleto extends GrafoNaoDirecionado {

    private int ordem;

    public GrafoCompleto(int ordem, String nome) {
        super(nome);
        this.ordem = ordem;

       // Criação dos vertices
       for (int i = 1; i <= ordem; i++) {
           this.addVertice(i);
       }

        // Criação das arestas
        for (int i = 1; i < ordem; i++)
           for (int j = i + 1; i <= ordem; j++) {
                this.addAresta(i, j, 0);
            }

    }

}
