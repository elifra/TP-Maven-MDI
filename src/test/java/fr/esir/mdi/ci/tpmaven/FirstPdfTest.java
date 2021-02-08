package fr.esir.mdi.ci.tpmaven;

import static org.junit.Assert.assertTrue;

import java.io.FileOutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

public class FirstPdfTest {
	
	String FILE = "FirstPdf.pdf";
	Document document = new Document();
	
	@Before
	public void setUp() throws Exception {
		try {
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			FirstPdf.addMetaData(document, 0);
			FirstPdf.addTitlePage(document);
			FirstPdf.addContent(document);
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@After
	public void tearDown() throws Exception {
		try {
			document.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test de la méthode isOpen()
	 */
	@Test
	public void testPdf() {
		assertTrue(document.isOpen());
	}
}
