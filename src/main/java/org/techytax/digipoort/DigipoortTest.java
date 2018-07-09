package org.techytax.digipoort;

import org.techytax.digipoort.lambda.event.LambdaEvent;
import org.techytax.ws.AanleverResponse;
import org.techytax.ws.GetBerichtsoortenResponse;
import org.techytax.ws.GetNieuweStatussenResponse;
import org.techytax.ws.GetProcessenResponse;
import org.techytax.ws.GetStatussenProcesResponse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class DigipoortTest {

  public static void main(String[] args) throws Exception {
//    digipoortService.getNieuweStatussen(vatDeclarationData);
//    doAanleveren();
//    getNieuweStatussen();
    getStatussenProces();
//    getProcessen();
//    getBerichtsoorten();
  }

  static AanleverResponse doAanleveren() throws Exception {
    DigipoortServiceImpl digipoortService = new DigipoortServiceImpl();
    LambdaEvent lambdaEvent = new LambdaEvent();
    return digipoortService.aanleveren(lambdaEvent);
  }

  private static GetNieuweStatussenResponse getNieuweStatussen() throws Exception {
    DigipoortServiceImpl digipoortService = new DigipoortServiceImpl();
    return digipoortService.getNieuweStatussen("", "");
  }

  static GetStatussenProcesResponse getStatussenProces() throws Exception {
    DigipoortServiceImpl digipoortService = new DigipoortServiceImpl();
    return digipoortService.getStatussenProces("test", "e1aa497a-03dc-4392-8deb-11e5534a505f");
  }

  private static GetProcessenResponse getProcessen() throws Exception {
    DigipoortServiceImpl digipoortService = new DigipoortServiceImpl();
    return digipoortService.getProcessen("", "");
  }

  public static GetBerichtsoortenResponse getBerichtsoorten() throws Exception {
    DigipoortServiceImpl digipoortService = new DigipoortServiceImpl();
    return digipoortService.getBerichtsoorten("test", "174006275B01");
  }

  private static String readXmlInvoice() {
    String xmlInvoice = getResourceFileAsString("xml/UBL-NL-Invoice-1.9-Example07.xml");
    return xmlInvoice;
  }

  private static String getResourceFileAsString(String fileName) {
    InputStream is = DigipoortTest.class.getClassLoader().getResourceAsStream(fileName);
    if (is != null) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(is));
      return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
    return null;
  }

}
