import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.*;

class TestGrafo {
	
	public static GrafoMutavel grafo;
	public static Vertice[] arrayVertice;
	public static Vertice[] verticesGrafo;

	@BeforeEach
	void iniciaGrafo () throws Exception {
		grafo = new GrafoDirecionado("Novo Grafo");
		grafo.carregar("direcionado.txt");
		arrayVertice = new Vertice[grafo.getVertices().size()];
		verticesGrafo = grafo.getVertices().allElements(arrayVertice);
	}
	
	
	@Test 
	void testCarregaArquivo () throws Exception{	
		for(int i = 0; i < verticesGrafo.length; i++) {
			assertEquals(i+1, verticesGrafo[i].getId());
		}	
	}
	
	@Test
	void testExisteVertice () {
		assertEquals(verticesGrafo[0], grafo.existeVertice(1));
	}
	
	@Test
	void testExisteAresta () {		
		assertEquals(verticesGrafo[0].existeAresta(2), grafo.existeAresta(1, 2));
	}
	
	@Test
	void testAdicionaVertice() {
		assertTrue(grafo.addVertice(16));
		
		Vertice [] arrayVertice = new Vertice[grafo.getVertices().size()];
		Vertice [] verticesGrafo = grafo.getVertices().allElements(arrayVertice);
		
		assertEquals(verticesGrafo[15], grafo.existeVertice(16));
	}
	
	@Test
	void testRemoveVertice() {
		assertEquals(verticesGrafo[14], grafo.removeVertice(15));
	}

	@Test
	void testOrdemGrafo() {
		assertEquals(15, grafo.ordem());
	}

	@Test
	void testGrafoCompleto() {
		Grafo g = Grafo.grafoCompleto(3);
		assertTrue(g.completo());
	}

	@Test
	void testAddArestaGrafoDirecionado() {
		assertTrue(grafo.addAresta(1, 6, -1));	
	}

	@Test
	void testRemoveArestaGrafoDirecionado() {
		assertEquals(verticesGrafo[0].getArestas().find(2), grafo.removeAresta(verticesGrafo[0].getId(),2));
	}
	
	@Test
	void testCriaSubGrafo() {
		Lista<Integer> vertices = new Lista<Integer>();
		vertices.add(1);
			
		Grafo subGrafo = novoGrafo.subGrafo(vertices);
		
		Vertice[] arrayVertice = new Vertice[subGrafo.getVertices().size()];
		Vertice[] verticesSubgrafo = subGrafo.getVertices().allElements(arrayVertice);
		
		assertEquals(verticesSubgrafo[0], subGrafo.existeVertice(1));
	}

}