package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.*;

class TestGrafo {

//	@BeforeEach
//	void criarGrafo() throws Exception {
//		Lista<Integer> vertices = new Lista<Integer>();
//		vertices.add(1);
//		vertices.add(3);
//		vertices.add(7);
//		GrafoDirecionado novoGrafo = new GrafoDirecionado("Novo Grafo");
//	}
	
	@Test
	void testCriaSubGrafo() {
		Lista<Integer> vertices = new Lista<Integer>();
		vertices.add(1);
		
		GrafoDirecionado novoGrafo = new GrafoDirecionado("Novo Grafo");
		novoGrafo.addVertice(1);
		novoGrafo.addVertice(2);
		novoGrafo.addAresta(1, 2, -1);
		
		
		Grafo subGrafo = novoGrafo.subGrafo(vertices);
		assertEquals(1, subGrafo.existeVertice(1));
	}

}