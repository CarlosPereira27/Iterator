package org.iterator.arvore;

public class No {

	private Object elemento;
	private No filhoEsquerda;
	private No filhoDireita;

	public No(Object elemento) {
		this.elemento = elemento;
		filhoEsquerda = null;
		filhoDireita = null;
	}

	public No getFilhoEsquerda() {
		return filhoEsquerda;
	}

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

	public void setFilhoEsquerda(No filhoEsquerda) {
		this.filhoEsquerda = filhoEsquerda;
	}

	public No getFilhoDireita() {
		return filhoDireita;
	}

	public void setFilhoDireita(No filhoDireita) {
		this.filhoDireita = filhoDireita;
	}

	@Override
	public String toString() {
		return elemento.toString();
	}

}
