package org.techytax.rest;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.binding.soap.SoapFault;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.techytax.digipoort.DigipoortServiceImpl;
import org.techytax.digipoort.XbrlNtp12Helper;
import org.techytax.domain.VatDeclarationData;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class VatRestController {

    @RequestMapping(value = "digipoort/vat", method = { RequestMethod.PUT, RequestMethod.POST })
    public void sendVatReportToDigipoort(HttpServletRequest request, @RequestBody VatDeclarationData vatDeclarationData) throws Exception {
        String xbrlInstance = createXbrlInstanceForEnvironment(vatDeclarationData);
        DigipoortServiceImpl digipoortService = new DigipoortServiceImpl();
        try {
            digipoortService.aanleveren(xbrlInstance, vatDeclarationData.getFiscalNumber());
        } catch (SoapFault soapFault) {
            log.error(soapFault.getReason());
        }
    }

    private static String createXbrlInstanceForEnvironment(VatDeclarationData vatDeclarationData) {
        return XbrlNtp12Helper.createXbrlInstance(vatDeclarationData);
    }
}
