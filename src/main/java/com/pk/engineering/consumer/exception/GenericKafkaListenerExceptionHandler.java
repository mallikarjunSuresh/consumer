package com.pk.engineering.consumer.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import com.pk.engineering.consumer.model.db.ErrorLog;
import com.pk.engineering.consumer.service.ErrorLogService;

@Component
public class GenericKafkaListenerExceptionHandler implements KafkaListenerErrorHandler {

  @Autowired
  private ErrorLogService errorLogService;
  
  @Override
  public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
    ErrorLog errorLog = new ErrorLog();
    errorLog.setErrorDescription(exception.getMessage());
    errorLogService.createErrorLog(errorLog);
    return null;
  }

}
