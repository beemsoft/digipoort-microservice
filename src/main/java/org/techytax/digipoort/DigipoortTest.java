package org.techytax.digipoort;

import org.techytax.domain.VatDeclarationData;

import java.time.LocalDate;

public class DigipoortTest {

  public static void main(String[] args) throws Exception {
    DigipoortServiceImpl service = new DigipoortServiceImpl();

    VatDeclarationData vatDeclarationData = new VatDeclarationData();
    vatDeclarationData.setFiscalNumber("<fiscal number");
    vatDeclarationData.setStartDate(LocalDate.now().withMonth(1).withDayOfMonth(1));
    vatDeclarationData.setEndDate(LocalDate.now().withMonth(3).withDayOfMonth(31));
    service.getNieuweStatussen(vatDeclarationData);
  }
}
