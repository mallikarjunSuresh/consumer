package com.pk.engineering.consumer.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pk.engineering.consumer.dao.JpaDaoImpl;
import com.pk.engineering.consumer.model.db.AuditLog;

@Service
@Transactional
public class AuditLogServiceImpl implements AuditLogService {
  
 private JpaDaoImpl<AuditLog> dao;

 @Autowired 
 public AuditLogServiceImpl(JpaDaoImpl<AuditLog> dao) {
   this.dao = dao;
   this.dao.setClazz(AuditLog.class);
 }
 
 @Override
public AuditLog createAuditLog(AuditLog auditLog) {
     dao.create(auditLog);
     return auditLog;
 }

 @Override
public AuditLog updateAuditLog(AuditLog auditLog) {
     return dao.update(auditLog);
 }

 @Override
public AuditLog getAuditLog(Long id) {
     return dao.findOne(id);
 }

 @Override
public List<AuditLog> getAllAuditLog(){
     return dao.findAll();      
 }
 
 @Override
public void deleteAuditLog(Long id) {
     dao.deleteById(id);
 }
 
}
