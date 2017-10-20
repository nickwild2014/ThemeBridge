package com.bs.themebridge.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.Document;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.jdom.input.SAXBuilder;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

import com.ibm.ws.http.Logger;

public class CSVToMapping {
	
	// private final static Logger logger = Logger.getLogger(CSVToMapping.class);

	private static final CsvPreference PIPE_DELIMITED = new CsvPreference.Builder('"', '|', "").build();

	public static CsvPreference getPipeDelimited() {
		return PIPE_DELIMITED;
	}

	/*
	 * public static void readWithCsvBeanReader() throws Exception {
	 * 
	 * ICsvBeanReader beanReader = null;
	 * 
	 * try {
	 * 
	 * String fileToLoad = readFile("fxrate.csv");
	 * 
	 * // System.out.println(fileToLoad);
	 * 
	 * // fileToLoad = fileToLoad.replaceAll("\\|\\|", "§");
	 * 
	 * // System.out.println(fileToLoad);
	 * 
	 * beanReader = new CsvBeanReader(new StringReader(fileToLoad),
	 * CsvPreference.STANDARD_PREFERENCE);
	 * 
	 * // the header elements are used to map the values to the bean (names
	 * 
	 * // must match)
	 * 
	 * final String[] header = beanReader.getHeader(true);
	 * 
	 * final CellProcessor[] processors = getProcessors();
	 * 
	 * TIFxRate TIFxRate;
	 * 
	 * while ((TIFxRate = beanReader.read(TIFxRate.class, header,processors)) !=
	 * null) {
	 * 
	 * System.out.println(TIFxRate.getFxRateCode());
	 * 
	 * TIFxRate.generateTokenMap();
	 * 
	 * String XML = TIFxRate.getXMLString();
	 * 
	 * System.out.println(XML);
	 * 
	 * }
	 * 
	 * } finally {
	 * 
	 * if (beanReader != null) {
	 * 
	 * beanReader.close();
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */
	public static CellProcessor[] getProcessors(int csvRecordCount) {

		ArrayList<CellProcessor> cpList = new ArrayList<CellProcessor>();

		for (int i = 0; i < csvRecordCount; i++) {

			cpList.add(new org.supercsv.cellprocessor.ConvertNullTo(""));

		}

		return cpList.toArray(new CellProcessor[cpList.size()]);

	}

	public static List<Map<String, String>> generateCSVMap(String csvFilePath, String propertiesFilePath)
			throws Exception {

		ICsvMapReader mapReader = null;
		int csvRecordCount;
		try {

			// System.out.println("properties file path:"+propertiesFilePath);
			InputStream input = new ByteArrayInputStream(csvFilePath.getBytes());
			mapReader = new CsvMapReader(new BufferedReader(new InputStreamReader(input)), getPipeDelimited());
			// the header columns are used as the keys to the Map
			final String[] header = mapReader.getHeader(true);
			Set<Object> propertiesKey = CSVProperties.getPropertiesKey(propertiesFilePath);
			csvRecordCount = Integer.parseInt(CSVProperties.getPropertiesvalue("column"));
			System.out.println(csvRecordCount);

			final CellProcessor[] processors = getProcessors(csvRecordCount);
			Map<String, Object> generationMap;
			List<Map<String, String>> returnMaplist = new ArrayList();
			Map<String, String> returnMap = null;

			while ((generationMap = mapReader.read(header, processors)) != null) {
				returnMap = new HashMap<String, String>();

				for (Object keys : propertiesKey) {
					String key = (String) keys;
					// System.out.println(key);
					String MapKey = CSVProperties.getPropertiesvalue(key);

					// System.out.println(key+":"+generationMap.get(MapKey).toString());
					if (!key.equals("column"))
						returnMap.put(key, generationMap.get(MapKey).toString());

				}
				// System.out.println(returnMap);
				returnMaplist.add(returnMap);
				// System.out.println(returnMaplist);
			}
			// for (Map<String,String> map : returnMaplist) {
			// System.out.println(map);
			// }

			return returnMaplist;

		} finally {
			if (mapReader != null) {
				mapReader.close();
			}
		}

	}

	public static void main(String args[]) {

		try {
			// readWithCsvBeanReader();
			generateCSVMap("fxrate.csv", "fxrate.properties");

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	public static String readFile(String filePath) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}
		return stringBuilder.toString();
	}

	public static String RemoveEmptyTagXML(String emptyTagXML) {

		Source xmlInput = new StreamSource(new StringReader(emptyTagXML));
		InputStream input = CSVToMapping.class.getClassLoader().getResourceAsStream("removeemptytag.xsl");
		Source xsl = new StreamSource(input);
		StringWriter writer = new StringWriter();
		StreamResult xmlOutput = new StreamResult(writer);
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer(xsl);
			transformer.transform(xmlInput, xmlOutput);
		} catch (TransformerException e) {
			System.out.println("Remove empty tag exceptions " + e.getMessage());
			e.printStackTrace();
		}
		// System.out.println(writer.toString());
		return writer.toString();
	}

}