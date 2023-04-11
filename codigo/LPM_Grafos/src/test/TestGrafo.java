package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.*;

class TestGrafo {

	@Test
	void testCriaSubGrafo() {
		Lista<Integer> vertices = new Lista<Integer>();
		vertices.add(1);
		
		GrafoDirecionado novoGrafo = new GrafoDirecionado("Novo Grafo");
		novoGrafo.addVertice(1);
		novoGrafo.addVertice(2);
		novoGrafo.addAresta(1, 2, -1);
		
		
		Grafo subGrafo = novoGrafo.subGrafo(vertices);
		
		Vertice[] arrayVertice = new Vertice[subGrafo.getVertices().size()];
		Vertice[] verticesSubgrafo = subGrafo.getVertices().allElements(arrayVertice);
		
		
		assertEquals(verticesSubgrafo[0], subGrafo.existeVertice(1));
	}

}
