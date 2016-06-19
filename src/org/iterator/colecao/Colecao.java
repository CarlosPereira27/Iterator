package org.iterator.colecao;

import java.util.Arrays;
import java.util.Iterator;

public class Colecao<E> implements Iterable<E> {
	
	private static final int TAMANHO_MINIMO = 10;
	private Object[] elementos;
	private int qtdElementos = 0;
	
	public Colecao() {
		elementos = new Object[TAMANHO_MINIMO];
	}
	
	public Colecao(int tamanho) {
		elementos = new Object[tamanho];
	}
	
	public void inserir(E elemento) {
		if(qtdElementos < elementos.length) {
			elementos[qtdElementos++] = elemento;
		} else {
			if(elementos.length < TAMANHO_MINIMO) {
				elementos = Arrays.copyOf(elementos, TAMANHO_MINIMO);
			} else {
				elementos = Arrays.copyOf(elementos, 
						elementos.length + elementos.length << 1);
			}
			elementos[qtdElementos++] = elemento;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new Itr();
	}
	
	public Iterator<E> iteratorInverso() {
		return new ItrInverso();
	}
	
	private class Itr implements Iterator<E> {
		
		private int indice = 0;

		@Override
		public boolean hasNext() {
			return indice < qtdElementos;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			if(hasNext()) {
				return (E) elementos[indice++];
			}
			return null;
		}
	}
	
	private class ItrInverso implements Iterator<E> {
		
		private int indice = qtdElementos-1;

		@Override
		public boolean hasNext() {
			return indice > -1;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			if(hasNext()) {
				return (E) elementos[indice--];
			}
			return null;
		}
	}
	
}
