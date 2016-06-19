package org.iterator.javateste;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class IteratorTest {

	private static final String nomes[] = { "Miguel", "Davi", "Sophia", "Julia", "Arthur" };
	private List<String> listaNomes;

	@Before
	public void inicializaListaNomes() {
		listaNomes = new ArrayList<>();
		for (String nome : nomes) {
			listaNomes.add(nome);
		}
	}

	@Test(expected = ConcurrentModificationException.class)
	public void testeIteratorRemoveForEach() {
		for (String nome : listaNomes) {
			if (nome.startsWith("Ar") || nome.endsWith("os")) {
				listaNomes.remove(nome);
			}
		}
	}

	@Test(expected = ConcurrentModificationException.class)
	public void testeIteratorRemove() {
		String nome;
		for (Iterator<String> it = listaNomes.iterator(); it.hasNext();) {
			nome = it.next();
			if (nome.startsWith("Ar") || nome.endsWith("os")) {
				listaNomes.remove(nome);
			}
		}
	}

	@Test
	public void testeIteratorRemoveIt() {
		String nome;
		for (Iterator<String> it = listaNomes.iterator(); it.hasNext();) {
			nome = it.next();
			if (nome.startsWith("Ar") || nome.endsWith("os")) {
				it.remove();
			}
		}
	}

	@Test(expected = ConcurrentModificationException.class)
	public void testeIteratorAddForEach() {
		for (String nome : listaNomes) {
			if (nome.startsWith("Ar") || nome.endsWith("os")) {
				listaNomes.add("Carlos");
			}
		}
	}

	@Test(expected = ConcurrentModificationException.class)
	public void testeIteratorAdd() {
		String nome;
		for (Iterator<String> it = listaNomes.iterator(); it.hasNext();) {
			nome = it.next();
			if (nome.startsWith("Ar") || nome.endsWith("os")) {
				listaNomes.add("Carlos");
			}
		}
	}

}
