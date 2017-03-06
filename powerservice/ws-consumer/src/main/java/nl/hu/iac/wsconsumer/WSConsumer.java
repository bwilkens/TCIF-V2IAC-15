package nl.hu.iac.wsconsumer;

import java.math.BigInteger;

import nl.hu.iac.wsinterface.Fault;
import nl.hu.iac.wsinterface.ObjectFactory;
import nl.hu.iac.wsinterface.PowerRequest;
import nl.hu.iac.wsinterface.PowerResponse;
import nl.hu.iac.wsinterface.PowerServiceService;

public class WSConsumer {

	public static void main(String[] args) {
		PowerServiceService service = new PowerServiceService();
		PowerRequest request = new ObjectFactory().createPowerRequest();
		request.setX(new BigInteger("3"));
		request.setPower(new BigInteger("3"));
		System.out.println("Request object "+request.getX()+ " tot de macht " +request.getPower());
		PowerResponse response = null;
		try {
			response = service.getWSPort().calculatePower(request);
		} catch (Fault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response.getResult());

	}

}
