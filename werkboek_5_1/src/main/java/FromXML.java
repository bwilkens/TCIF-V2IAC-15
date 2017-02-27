import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import nl.hu.iac.jaxb.bookshelf.Bookshelf;
import nl.hu.iac.jaxb.bookshelf.CategoryType;

public class FromXML {
	public static void main(String[] args) {
		/*
		 * Je moet eerste de classes genereren met Maven
		 * mvn jaxb2:xjc
		 */
		File input = new File("bookshelf.xml");

		try {
			JAXBContext jc = JAXBContext.newInstance(Bookshelf.class);
			Unmarshaller umsh = jc.createUnmarshaller();
			
			Bookshelf c1 = (Bookshelf)umsh.unmarshal(input);
			System.out.println(c1);
			/*
			 * De code hieronder doet iets speciaals. Waarom krijg je de category te zien?
			 */
			CategoryType c = (CategoryType)c1.getBooks().getBook().get(0).getCategories().getCategory().get(0).getRefid();
			System.out.println(c.getName());
			
		} catch (JAXBException e){
			e.printStackTrace();
		}
	}
}