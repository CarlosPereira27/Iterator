package org.iterator.arvore;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class ArvoreTest {
	
	private static final String[] NOMES = { "Pedro", "Fernando", "Roger", 
			"Carlos", "Raul", "Manollo", "Bruno", "Raphael", 
			"Silvestrini", "Igor", "Tiago" };
	private static final String[] NOMES_EM_ORDEM = { "Bruno", "Carlos", 
			"Fernando", "Igor", "Manollo", "Pedro", "Raphael", 
			"Raul", "Roger", "Silvestrini", "Tiago" };
	private static final String[] NOMES_PRE_ORDEM = { "Pedro", "Fernando", 
			"Carlos", "Bruno", "Manollo", "Igor", "Roger", "Raul", 
			"Raphael", "Silvestrini", "Tiago" };
	private static final String[] NOMES_POS_ORDEM = { "Bruno", "Carlos", 
			"Igor", "Manollo", "Fernando", "Raphael", "Raul", "Tiago", 
			"Silvestrini", "Roger", "Pedro" };
	private Arvore<String> arvore;
	
	@Test
	public void iteratorEmOrdemTeste() {
		arvore = new Arvore<String>();
		for(String nome : NOMES) {
			arvore.inserir(nome);
		}
		Iterator<String> iteratorEmOrdem = arvore.iterator();
		for(String nome : NOMES_EM_ORDEM) {
			assertTrue(iteratorEmOrdem.hasNext());
			assertEquals(nome, iteratorEmOrdem.next());
		}
		assertFalse(iteratorEmOrdem.hasNext());
		assertEquals(null, iteratorEmOrdem.next());
	}

	@Test
	public void iteratorPreOrdemTeste() {
		arvore = new Arvore<String>();
		for(String nome : NOMES) {
			arvore.inserir(nome);
		}
		Iterator<String> iteratorPreOrdem = arvore.iteratorPreOrdem();
		for(String nome : NOMES_PRE_ORDEM) {
			assertTrue(iteratorPreOrdem.hasNext());
			assertEquals(nome, iteratorPreOrdem.next());
		}
		assertFalse(iteratorPreOrdem.hasNext());
		assertEquals(null, iteratorPreOrdem.next());
	}
	
	@Test
	public void iteratorPosOrdemTeste() {
		arvore = new Arvore<String>();
		for(String nome : NOMES) {
			arvore.inserir(nome);
		}
		Iterator<String> iteratorPosOrdem = arvore.iteratorPosOrdem();
		for(String nome : NOMES_POS_ORDEM) {
			assertTrue(iteratorPosOrdem.hasNext());
			assertEquals(nome, iteratorPosOrdem.next());
		}
		assertFalse(iteratorPosOrdem.hasNext());
		assertEquals(null, iteratorPosOrdem.next());
	}

}
