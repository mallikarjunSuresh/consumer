package com.pk.engineering.consumer.exception;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.stereotype.Component;
import com.pk.engineering.consumer.model.db.ErrorLog;
import com.pk.engineering.consumer.service.ErrorLogService;

@Component
public class GenericKafkaContainerExceptionHandler implements ErrorHandler {

  private static final Logger log = LoggerFactory.getLogger(GenericKafkaContainerExceptionHandler.class);
  
  @Autowired
  private ErrorLogService errorLogService;
  
  public GenericKafkaContainerExceptionHandler(ErrorLogService errorLogService) {
    this.errorLogService = errorLogService;
  }
  
  @Override
  public void handle(Exception thrownException, ConsumerRecord<?, ?> data) {
    ErrorLog errorLog = new ErrorLog();
    errorLog.setErrorDescription(thrownException.getMessage());
    errorLogService.createErrorLog(errorLog);
    
    log.info("Kafka listener error persisted into db :{}", errorLog);

  }

}
