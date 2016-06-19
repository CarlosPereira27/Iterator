package org.iterator.arquivo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArquivoTeste {

	private static File file = new File("teste.txt");
	private static final String[] LINHAS_ARQUIVO = { "Olá mundo", 
			"Padrões de projeto", "Design Patterns",
			"Behavioral Patterns", "Iterator", "Java" };

	@BeforeClass
	public static void criarArquivo() throws IOException {
		file.createNewFile();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
				(new FileOutputStream(file)));
		for (String linha : LINHAS_ARQUIVO) {
			bw.write(linha);
			bw.newLine();
		}
		bw.close();
	}

	@AfterClass
	public static void deletarArquivo() {
		file.delete();
	}

	@Test
	public void iterarTeste() {
		Arquivo arquivo = new Arquivo(file);
		Iterator<String> iteratorArquivo = arquivo.iterator();
		for (String linha : LINHAS_ARQUIVO) {
			assertTrue(iteratorArquivo.hasNext());
			assertEquals(linha, iteratorArquivo.next());
		}
		assertFalse(iteratorArquivo.hasNext());
		assertEquals(null, iteratorArquivo.next());
	}

	@Test
	public void foreachTeste() {
		Arquivo arquivo = new Arquivo(file);
		int indice = 0;
		for (String linha : arquivo) {
			assertEquals(LINHAS_ARQUIVO[indice++], linha);
		}
	}

}
