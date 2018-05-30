package org.techytax.digipoort;

import com.amazonaws.services.lambda.runtime.Context;

import java.util.Map;

public class HelloWorldLambdaHandler  {
  public String handleRequest(Map<String,Object> input, Context context) throws Exception {
    System.out.println(input);
    DigipoortTest.getBerichtsoorten();
    return "Hello";
  }
}