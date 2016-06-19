package org.iterator.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Arquivo implements Iterable<String> {

	private File file;

	public Arquivo(File file) {
		this.file = file;
	}

	private String lerLinha(long indice) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader
					(new FileInputStream(file)));
			br.skip(indice);
			String linha = br.readLine();
			br.close();
			return linha;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Iterator<String> iterator() {
		return new IteratorArquivoPorLinha();
	}

	private class IteratorArquivoPorLinha implements Iterator<String> {

		private long indice = 0;

		@Override
		public boolean hasNext() {
			if (lerLinha(indice) == null) {
				return false;
			}
			return true;
		}

		@Override
		public String next() {
			if (hasNext()) {
				String linha = lerLinha(indice);
				indice += linha.length() + 1;
				return linha;
			}
			return null;
		}

	}

}
