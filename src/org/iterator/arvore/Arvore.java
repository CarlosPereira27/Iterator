package org.iterator.arvore;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

enum PosicaoFilho {
	FILHO_ESQUERDA, FILHO_DIREITA
}

public class Arvore<E extends Comparable<E>> implements Iterable<E> {

	private No raiz;

	public Arvore() {
		raiz = null;
	}

	@SuppressWarnings("unchecked")
	private void inserir(E elemento, No noAtual, No noPai, PosicaoFilho posicaoFilho) {
		if (noAtual == null) {
			noAtual = new No(elemento);
			switch (posicaoFilho) {
			case FILHO_ESQUERDA:
				noPai.setFilhoEsquerda(noAtual);
				break;
			case FILHO_DIREITA:
				noPai.setFilhoDireita(noAtual);
				break;
			}
			return;
		} else {
			if (elemento.compareTo((E) noAtual.getElemento()) <= 0) {
				inserir(elemento, noAtual.getFilhoEsquerda(), noAtual, PosicaoFilho.FILHO_ESQUERDA);
			} else {
				inserir(elemento, noAtual.getFilhoDireita(), noAtual, PosicaoFilho.FILHO_DIREITA);
			}
		}
	}
	
	public void inserir(E elemento) {
		if (raiz == null) {
			raiz = new No(elemento);
			return;
		}
		inserir(elemento, raiz, null, null);
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorEmOrdem();
	}
	
	public Iterator<E> iteratorPosOrdem() {
		return new IteratorPosOrdem();
	}
	
	public Iterator<E> iteratorPreOrdem() {
		return new IteratorPreOrdem();
	}
	
	private class IteratorEmOrdem implements Iterator<E> {
		
		private Deque<NoFilhosVisitados> pilhaNo;
		
		public IteratorEmOrdem() {
			pilhaNo = new LinkedList<NoFilhosVisitados>();
			if (raiz != null) {
				pilhaNo.push(new NoFilhosVisitados(raiz));
			}
		}
		
		@Override
		public boolean hasNext() {
			return !pilhaNo.isEmpty();
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			NoFilhosVisitados no = pilhaNo.peek();
			if (hasNext()) {
				while (no.getFilhoEsquerda() != null && !no.isVisitaFilhoEsquerda()) {
					no.setVisitaFilhoEsquerda(true);
					no = (new NoFilhosVisitados(no.getFilhoEsquerda()));
					pilhaNo.push(no);
				}
				no = pilhaNo.pop();
				if (no.getFilhoDireita() != null && !no.isVisitaFilhoDireita()) {
					no.setVisitaFilhoDireita(true);
					pilhaNo.push(new NoFilhosVisitados(no.getFilhoDireita()));
				}
				return (E) no.getElemento();
			}
			return null;
		}
		
	}
	
	private class IteratorPreOrdem implements Iterator<E> {

		private Deque<No> pilhaNo;

		public IteratorPreOrdem() {
			pilhaNo = new LinkedList<No>();
			if (raiz != null) {
				pilhaNo.push(raiz);
			}
		}

		@Override
		public boolean hasNext() {
			return !pilhaNo.isEmpty();
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			if (hasNext()) {
				No no = pilhaNo.pop();
				if (no.getFilhoDireita() != null) {
					pilhaNo.push(no.getFilhoDireita());
				}
				if (no.getFilhoEsquerda() != null) {
					pilhaNo.push(no.getFilhoEsquerda());
				}
				return (E) no.getElemento();
			}
			return null;
		}

	}

	private class IteratorPosOrdem implements Iterator<E> {

		private Deque<NoFilhosVisitados> pilhaNo;

		public IteratorPosOrdem() {
			pilhaNo = new LinkedList<NoFilhosVisitados>();
			if (raiz != null) {
				pilhaNo.push(new NoFilhosVisitados(raiz));
			}

		}

		@Override
		public boolean hasNext() {
			return !pilhaNo.isEmpty();
		}

		private boolean temFilhosAVisitar(NoFilhosVisitados no) {
			if (no.getFilhoEsquerda() != null && !no.isVisitaFilhoEsquerda()) {
				return true;
			}
			if (no.getFilhoDireita() != null && !no.isVisitaFilhoDireita()) {
				return true;
			}
			return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			if (hasNext()) {
				NoFilhosVisitados no = pilhaNo.peek();
				while (temFilhosAVisitar(no)) {
					while (no.getFilhoEsquerda() != null && !no.isVisitaFilhoEsquerda()) {
						no.setVisitaFilhoEsquerda(true);
						no = (new NoFilhosVisitados(no.getFilhoEsquerda()));
						pilhaNo.push(no);
					}
					if (no.getFilhoDireita() != null && !no.isVisitaFilhoDireita()) {
						no.setVisitaFilhoDireita(true);
						no = (new NoFilhosVisitados(no.getFilhoDireita()));
						pilhaNo.push(no);
					}
				}
				no = pilhaNo.pop();
				return (E) no.getElemento();
			}
			return null;
		}

	}
	
	private class NoFilhosVisitados {

		private No no;
		private boolean visitaFilhoEsquerda = false;
		private boolean visitaFilhoDireita = false;

		public NoFilhosVisitados(No no) {
			this.no = no;
		}

		public Object getElemento() {
			return no.getElemento();
		}

		public No getFilhoEsquerda() {
			return no.getFilhoEsquerda();
		}

		public No getFilhoDireita() {
			return no.getFilhoDireita();
		}

		public boolean isVisitaFilhoEsquerda() {
			return visitaFilhoEsquerda;
		}

		public void setVisitaFilhoEsquerda(boolean visitaFilhoEsquerda) {
			this.visitaFilhoEsquerda = visitaFilhoEsquerda;
		}

		public boolean isVisitaFilhoDireita() {
			return visitaFilhoDireita;
		}

		public void setVisitaFilhoDireita(boolean visitaFilhoDireita) {
			this.visitaFilhoDireita = visitaFilhoDireita;
		}
		
		@Override
		public String toString() {
			return no.toString();
		}
	}

}
