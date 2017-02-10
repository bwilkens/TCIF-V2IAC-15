
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DOMDemo {
	public static void main(String[] args) {
		Path xmlLocation = Paths.get("src/main/resources/customer.xml");
		if (Files.isRegularFile(xmlLocation)) {
			try (InputStream in = Files.newInputStream(xmlLocation);
					Reader reader = new InputStreamReader(in, "UTF-8")) {
				DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilderFactory.setNamespaceAware(true);
				DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
				InputSource is = new InputSource(reader);
				is.setEncoding("UTF-8");
				Document document = docBuilder.parse(in);
				document.getDocumentElement().normalize();
				System.out.println("Document ingelezen root element naam is '"
						+ document.getDocumentElement().getNodeName() + "'");
				System.out.println(
						"Aantal child elementen: " + document.getDocumentElement().getChildNodes().getLength());
				int size = document.getElementsByTagName("age").getLength();
				for (int index = 0; index < size; index++) {
					Node ageNode = document.getElementsByTagName("age").item(index);
					System.out.println(ageNode.getTextContent());
					System.out.println("ageNode " + ageNode.getNodeName() + "=" + ageNode.getFirstChild().getNodeValue());
				}
			} catch (IOException | ParserConfigurationException | SAXException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("oeps");
		}
	}
}