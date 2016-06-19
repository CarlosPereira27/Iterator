package org.iterator.colecao;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class ColecaoTest {
	
	private static final String[] NOMES = { "Pedro", "Fernando", "Roger", 
			"Carlos", "Raul", "Manollo", "Bruno", "Raphael", 
			"Silvestrini", "Igor", "Tiago" };
	private Colecao<String> colecaoNomes;

	@Test
	public void iteratorTeste() {
		colecaoNomes = new Colecao<String>();
		for(String nome : NOMES) {
			colecaoNomes.inserir(nome);
		}
		Iterator<String> iterator = colecaoNomes.iterator();
		for(String nome : NOMES) {
			assertTrue(iterator.hasNext());
			assertEquals(nome, iterator.next());
		}
		assertFalse(iterator.hasNext());
		assertEquals(null, iterator.next());
	}
	
	@Test
	public void iteratorInversoTeste() {
		colecaoNomes = new Colecao<String>();
		for(String nome : NOMES) {
			colecaoNomes.inserir(nome);
		}
		Iterator<String> iterator = colecaoNomes.iteratorInverso();
		for(int i = NOMES.length-1; i > -1; i--) {
			assertTrue(iterator.hasNext());
			assertEquals(NOMES[i], iterator.next());
		}
		assertFalse(iterator.hasNext());
		assertEquals(null, iterator.next());
	}

}
