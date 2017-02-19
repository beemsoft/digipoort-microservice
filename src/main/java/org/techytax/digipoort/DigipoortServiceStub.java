package org.techytax.digipoort;

import org.techytax.domain.VatDeclarationData;
import org.techytax.ws.AanleverResponse;
import org.techytax.ws.AanleverServiceFault;
import org.techytax.ws.AanleverServiceV12_AanleverServiceV12_Client;
import org.techytax.ws.ArrayOfProcesResultaat;
import org.techytax.ws.ArrayOfStatusResultaat;
import org.techytax.ws.FoutType;
import org.techytax.ws.GetBerichtsoortenResponse;
import org.techytax.ws.GetNieuweStatussenProcesResponse;
import org.techytax.ws.GetNieuweStatussenResponse;
import org.techytax.ws.GetProcessenResponse;
import org.techytax.ws.GetStatussenProcesResponse;
import org.techytax.ws.ProcesResultaat;
import org.techytax.ws.StatusResultaat;
import org.techytax.wus.status.StatusinformatieServiceFault;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class DigipoortServiceStub implements DigipoortService {

	@Override
	public AanleverResponse aanleveren(String xbrlInstance, String fiscalNumber) throws FileNotFoundException, IOException, GeneralSecurityException,
			AanleverServiceFault {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetNieuweStatussenResponse getNieuweStatussen(VatDeclarationData vatDeclarationData) throws IOException, GeneralSecurityException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetNieuweStatussenProcesResponse getNieuweStatussenProces(VatDeclarationData vatDeclarationData, String kenmerk)
			throws FileNotFoundException, IOException, GeneralSecurityException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetProcessenResponse getProcessen(VatDeclarationData vatDeclarationData) throws FileNotFoundException, IOException,
			GeneralSecurityException, StatusinformatieServiceFault {
		GetProcessenResponse response = new GetProcessenResponse();
		ArrayOfProcesResultaat array = new ArrayOfProcesResultaat();
		ProcesResultaat resultaat = new ProcesResultaat();
		resultaat.setKenmerk("Test");
		array.getProcesResultaat().add(resultaat);
		response.setGetProcessenReturn(array);
		return response;
	}

	@Override
	public GetStatussenProcesResponse getStatussenProces(VatDeclarationData vatDeclarationData, String kenmerk) throws FileNotFoundException,
			IOException, GeneralSecurityException {
		GetStatussenProcesResponse response = new GetStatussenProcesResponse();
		StatusResultaat statusResultaat = new StatusResultaat();
		FoutType foutType = new FoutType();
		foutType.setFoutcode("T1");
		foutType.setFoutbeschrijving(AanleverServiceV12_AanleverServiceV12_Client.getXbrlValidationError());
		statusResultaat.setStatusFoutcode(foutType);
		statusResultaat.setKenmerk("Test");
		ArrayOfStatusResultaat procesReturn = new ArrayOfStatusResultaat();
		procesReturn.getStatusResultaat().add(statusResultaat);
		response.setGetStatussenProcesReturn(procesReturn );
		return response;
	}

	@Override
	public GetBerichtsoortenResponse getBerichtsoorten(VatDeclarationData vatDeclarationData) throws FileNotFoundException, IOException,
			GeneralSecurityException {
		// TODO Auto-generated method stub
		return null;
	}

}
