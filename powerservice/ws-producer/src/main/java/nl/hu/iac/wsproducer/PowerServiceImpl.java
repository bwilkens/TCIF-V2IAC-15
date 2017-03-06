package nl.hu.iac.wsproducer;

import java.math.BigInteger;

import javax.jws.WebService;

import com.sun.xml.ws.developer.SchemaValidation;

import nl.hu.iac.wsinterface.Fault;
import nl.hu.iac.wsinterface.ObjectFactory;
import nl.hu.iac.wsinterface.PowerFault;
import nl.hu.iac.wsinterface.PowerRequest;
import nl.hu.iac.wsinterface.PowerResponse;
import nl.hu.iac.wsinterface.PowerServiceInterface;

@WebService(endpointInterface = "nl.hu.iac.wsinterface.PowerServiceInterface")
@SchemaValidation(handler = SchemaValidationErrorHandler.class)
public class PowerServiceImpl implements PowerServiceInterface {

	@Override
	public PowerResponse calculatePower(PowerRequest request) throws Fault {
		System.out.println("Request object "+request.getX()+ " " +request.getPower());
		ObjectFactory factory = new ObjectFactory();
		PowerResponse response = factory.createPowerResponse();
		try {
			Double result = Math.pow(request.getX().doubleValue(), request
					.getPower().doubleValue());
			// x en power zijn altijd gehele getallen dan is er geen afronding
			response.setResult(BigInteger.valueOf(result.longValue()));
		} catch (RuntimeException e) {
			PowerFault x = factory.createPowerFault();
			x.setErrorCode((short) 1);
			x.setMessage("Kan de macht van " + request.getX()
					+ " tot de macht " + request.getPower().toString()
					+ " niet berekenen.");
			Fault fault = new Fault(
					"Er ging iets mis met het berekenen van de macht", x);
			throw fault;
		}
		return response;
	}

}
