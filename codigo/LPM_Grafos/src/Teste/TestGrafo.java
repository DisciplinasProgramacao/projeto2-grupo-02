package Teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

import business.*;

class TestGrafo {

	@BeforeEach
	void criarGrafo() {
		LinkedList<Integer> vertices = new LinkedList<Integer>();
		vertices.addLast(1);
		vertices.addLast(3);
		vertices.addLast(7);
		GrafoDirecionado novoGrafo = new GrafoDirecionado("Novo Grafo");
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
