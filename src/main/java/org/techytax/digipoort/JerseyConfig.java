package org.techytax.digipoort;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    register(DigipoortResource.class);
    // Available at /<Jersey's servlet path>/application.wadl
    register(WadlResource.class);
  }

}
