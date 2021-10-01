package com.pk.engineering.consumer.service;

import java.util.List;
import com.pk.engineering.consumer.model.db.ErrorLog;


public interface ErrorLogService {

  ErrorLog createErrorLog(ErrorLog auditLog);

  ErrorLog updateErrorLog(ErrorLog auditLog);

  ErrorLog getErrorLog(Long id);

  List<ErrorLog> getAllErrorLog();

  void deleteErrorLog(Long id);

}
