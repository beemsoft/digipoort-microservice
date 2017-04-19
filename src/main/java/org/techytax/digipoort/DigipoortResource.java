package org.techytax.digipoort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.techytax.ws.GetBerichtsoortenResponse;
import org.techytax.wus.status.StatusinformatieServiceFault;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.security.GeneralSecurityException;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Produces(APPLICATION_JSON)
@Component
@Path("api/digipoort")
public class DigipoortResource {

  @Autowired
  private DigipoortService digipoortService;

  @GET
  @Path("bericht-soorten")
  public GetBerichtsoortenResponse berichtSoorten(@QueryParam("fiscalNumber") String fiscalNumber) {
    try {
      return digipoortService.getBerichtsoorten(fiscalNumber);
    } catch (IOException | GeneralSecurityException | StatusinformatieServiceFault e) {
      e.printStackTrace();
    }
    return null;
  }
}
