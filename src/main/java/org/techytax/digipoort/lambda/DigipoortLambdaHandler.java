package org.techytax.digipoort.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.techytax.digipoort.DigipoortService;
import org.techytax.digipoort.DigipoortServiceImpl;
import org.techytax.digipoort.lambda.event.LambdaEvent;
import org.techytax.ws.AanleverResponse;
import org.techytax.ws.AanleverServiceFault;
import org.techytax.ws.GetStatussenProcesResponse;
import org.techytax.ws.StatusResultaat;
import org.techytax.wus.status.StatusinformatieServiceFault;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class DigipoortLambdaHandler implements RequestHandler<LambdaEvent, String> {

  private DigipoortService digipoortService = new DigipoortServiceImpl();

  @Override
  public String handleRequest(LambdaEvent input, Context context) {
    if (input.getSendInvoice() != null) {
      return handleSendInvoice(input);
    } else if (input.getCheckStatus() != null) {
      return handleCheckStatus(input);
    }
    return "Invalid request";
  }

  private String handleCheckStatus(LambdaEvent input) {
    try {
      GetStatussenProcesResponse response = digipoortService.getStatussenProces(input.getMode(), input.getCheckStatus().getReferenceId());
      for (StatusResultaat resultaat : response.getGetStatussenProcesReturn().getStatusResultaat()) {
        if (resultaat.getStatuscode().equals("400")) {
          return "OK";
        }
      }
      return "NOT OK";
    } catch (IOException | StatusinformatieServiceFault | GeneralSecurityException e) {
      e.printStackTrace();
      return e.getMessage();
    }
  }

  private String handleSendInvoice(LambdaEvent input) {
    try {
      AanleverResponse response = digipoortService.aanleveren(input);
      return response.getKenmerk();
    } catch (IOException | GeneralSecurityException | AanleverServiceFault e) {
      e.printStackTrace();
      return e.getMessage();
    }
  }
}