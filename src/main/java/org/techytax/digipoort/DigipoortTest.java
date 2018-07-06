package org.techytax.digipoort;

import org.techytax.domain.FiscalPeriod;
import org.techytax.domain.VatDeclarationData;
import org.techytax.domain.VatPeriodType;
import org.techytax.util.DateHelper;
import org.techytax.ws.AanleverResponse;
import org.techytax.ws.GetBerichtsoortenResponse;
import org.techytax.ws.GetNieuweStatussenResponse;
import org.techytax.ws.GetProcessenResponse;
import org.techytax.ws.GetStatussenProcesResponse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class DigipoortTest {

  public static void main(String[] args) throws Exception {
    DigipoortServiceImpl digipoortService = new DigipoortServiceImpl();

    VatDeclarationData vatDeclarationData = new VatDeclarationData();
    vatDeclarationData.setFiscalNumber("<fiscal number");
    vatDeclarationData.setStartDate(LocalDate.now().withMonth(1).withDayOfMonth(1));
    vatDeclarationData.setEndDate(LocalDate.now().withMonth(3).withDayOfMonth(31));
//    digipoortService.getNieuweStatussen(vatDeclarationData);
//    doAanleveren();
//    getNieuweStatussen();
//    getStatussenProces();
//    getProcessen();
    getBerichtsoorten();
  }

  static AanleverResponse doAanleveren() throws Exception {
    DigipoortServiceImpl digipoortService = new DigipoortServiceImpl();
    return digipoortService.aanleveren(readXmlInvoice(), "174006275B01");
  }

  private static GetNieuweStatussenResponse getNieuweStatussen() throws Exception {
    VatDeclarationData vatDeclarationData = createVatDeclarationData();
    DigipoortServiceImpl digipoortService = new DigipoortServiceImpl();
    return digipoortService.getNieuweStatussen(vatDeclarationData);
  }

  private static GetStatussenProcesResponse getStatussenProces() throws Exception {
    VatDeclarationData vatDeclarationData = createVatDeclarationData();
    vatDeclarationData.setEndDate(LocalDate.now().plusDays(1));
    DigipoortServiceImpl digipoortService = new DigipoortServiceImpl();
    return digipoortService.getStatussenProces(vatDeclarationData, "");
  }

  private static GetProcessenResponse getProcessen() throws Exception {
    VatDeclarationData vatDeclarationData = createVatDeclarationData();
    vatDeclarationData.setEndDate(LocalDate.now().plusDays(1));
    DigipoortServiceImpl digipoortService = new DigipoortServiceImpl();
    return digipoortService.getProcessen(vatDeclarationData);
  }

  public static GetBerichtsoortenResponse getBerichtsoorten() throws Exception {
    DigipoortServiceImpl digipoortService = new DigipoortServiceImpl();
    return digipoortService.getBerichtsoorten("174006275B01");
  }

  private static VatDeclarationData createVatDeclarationData() throws Exception {
    VatDeclarationData vatDeclarationData = new VatDeclarationData();
    FiscalPeriod period = DateHelper.getLatestVatPeriod(VatPeriodType.PER_QUARTER);
    vatDeclarationData.setStartDate(period.getBeginDate());
    vatDeclarationData.setEndDate(period.getEndDate());
    vatDeclarationData.setFiscalNumber("B01");
    vatDeclarationData.setInitials("");
    vatDeclarationData.setSurname("");
    vatDeclarationData.setPhoneNumber("");
    vatDeclarationData.setValueAddedTaxOnInput(BigDecimal.valueOf(0));
    vatDeclarationData.setValueAddedTaxPrivateUse(BigDecimal.valueOf(0));
    vatDeclarationData.setValueAddedTaxSuppliesServicesGeneralTariff(BigDecimal.valueOf(0));
    vatDeclarationData.setValueAddedTaxOwed(BigDecimal.valueOf(0));
    vatDeclarationData.setValueAddedTaxOwedToBePaidBack(BigDecimal.valueOf(0));
    vatDeclarationData.setTaxedTurnoverSuppliesServicesGeneralTariff(BigDecimal.valueOf(0));
    return vatDeclarationData;
  }

  private static String createXbrlInstanceForEnvironment(VatDeclarationData vatDeclarationData) throws Exception {
    String xbrlInstance = XbrlNtp12Helper.createXbrlInstance(vatDeclarationData);
    return xbrlInstance;
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
