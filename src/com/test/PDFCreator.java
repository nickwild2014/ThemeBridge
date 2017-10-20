package com.test;

import java.io.FileOutputStream;

import org.apache.log4j.Logger;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class PDFCreator {
	private final static Logger logger = Logger.getLogger(PDFCreator.class.getName());

	// private static String USER_PASSWORD = "password";
	// private static String OWNER_PASSWORD = "lokesh";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pdfDocumentCreator();
	}

	public static void pdfDocumentCreator() {
		Document document = new Document();
		try {
			logger.debug("Initiated !!!");

			// Rectangle pageSize = new Rectangle(780, 525);

			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("D:\\_Prasath\\Personal\\Kotak-Logo\\AddImageExample.pdf"));

			// writer.setEncryption(USER_PASSWORD.getBytes(),
			// OWNER_PASSWORD.getBytes(), PdfWriter.ALLOW_PRINTING,
			// PdfWriter.ENCRYPTION_AES_128);

			document.open();
			// Set attributes here
			document.addAuthor("TI Plus2-a:G.4.2.2 v. 2.7");
			document.addCreationDate();
			document.addCreator("TI Plus2-a");
			document.addTitle("SFMS advice copy");// BGSWIFT:1.24:226_4
			document.addSubject("Advice");

			document.add(new Paragraph("Image Example1"));

			// Add Image
			Image image1 = Image.getInstance("D:\\_Prasath\\Personal\\Kotak-Logo\\converted.jpg");

			// Fixed Positioning
			// image1.setAbsolutePosition(100f, 550f);
			image1.setAbsolutePosition(30f, 750f);

			// Scale to new height and new width of image
			image1.scaleAbsolute(100, 30);

			// Add to document
			document.add(image1);
			logger.debug("Processing !!!");

			// document.add(new Paragraph("Image Example2"));

			document.add(Chunk.NEWLINE);
			LineSeparator ls = new LineSeparator();
			document.add(new Chunk(ls));

			// content
			document.add(new Paragraph("Image Example3"));

			logger.debug("Completed !!!");

			document.close();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
