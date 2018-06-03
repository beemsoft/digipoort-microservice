package org.techytax.digipoort;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloWorldLambdaHandler implements RequestHandler<Object, String> {

  @Override
  public String handleRequest(Object input, Context context) {
    System.out.println(input);
    try {
      DigipoortTest.getBerichtsoorten();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "Hello";
  }
}