package org.techytax.digipoort.lambda.event;

import lombok.Data;

@Data
public class LambdaEvent {
  String mode;
  String environment;
  SendInvoice sendInvoice;
  CheckStatus checkStatus;

  @Data
  public class SendInvoice {
    String senderId;
    String receiverId;
    String sourceBucket;
    String sourceKeyname;
  }

  @Data
  public class CheckStatus {
    String referenceId;
  }
}
