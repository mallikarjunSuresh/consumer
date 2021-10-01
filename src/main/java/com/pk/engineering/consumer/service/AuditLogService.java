package com.pk.engineering.consumer.service;

import java.util.List;
import com.pk.engineering.consumer.model.db.AuditLog;


public interface AuditLogService {

  AuditLog createAuditLog(AuditLog auditLog);

  AuditLog updateAuditLog(AuditLog auditLog);

  AuditLog getAuditLog(Long id);

  List<AuditLog> getAllAuditLog();

  void deleteAuditLog(Long id);

}
