import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

	public static void main(String[] args) throws JAXBException {
		File file = new File("customer.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		javax.xml.bind.Marshaller jaxbMarshaller = jaxbContext
				.createMarshaller();
		// output mooi uitgelijnd
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
//		jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

		Customer customer = new Customer();
		customer.setDateOfBirth("10 juni 1996");
		customer.setName("Berend Wilkens");
		Address shippingAddress = new Address();
		shippingAddress.setStreet("Nijenoord 1");
		shippingAddress.setZip("3535 AA");
		shippingAddress.setCity("Utrecht");
		Address billingAddress = new Address();
		billingAddress.setStreet("Nijenoord 2");
		billingAddress.setZip("3535 AA");
		billingAddress.setCity("Utrecht");
		customer.setAddress(billingAddress);
//		customer.getAddresses().put("Billing", billingAddress);
//		customer.getAddresses().put("Shipping", shippingAddress);
		
		jaxbMarshaller.marshal(customer, file);
		System.out.println(customer);
		// Marshal the employee object to JSON and print the output to console
		jaxbMarshaller.marshal(customer, System.out);
	}

}
