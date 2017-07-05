package org.techytax.digipoort;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.techytax.util.JwtTokenUtil;
import org.techytax.ws.GetBerichtsoortenResponse;
import org.techytax.wus.status.StatusinformatieServiceFault;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@Slf4j
public class DigipoortRestController {

  @Value("${jwt.header}")
  private String tokenHeader;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private DigipoortService digipoortService;

  @RequestMapping(value = "api/digipoort/bericht-soorten", method = RequestMethod.GET)
  public GetBerichtsoortenResponse berichtSoorten(HttpServletRequest request, @QueryParam("fiscalNumber") String fiscalNumber) {
    log.info("berichtSoorten called by user: {} for fiscal number: {}", getUser(request), fiscalNumber);
    try {
      return digipoortService.getBerichtsoorten(fiscalNumber);
    } catch (IOException | GeneralSecurityException | StatusinformatieServiceFault e) {
      e.printStackTrace();
    }
    return null;
  }

  private String getUser(HttpServletRequest request) {
    String token = request.getHeader(tokenHeader);
    String username = jwtTokenUtil.getUsernameFromToken(token);
    if (username == null) {
      throw new RuntimeException("Authentication error");
    }
    return username;
  }
}
