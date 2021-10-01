package com.pk.engineering.consumer.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pk.engineering.consumer.dao.JpaDaoImpl;
import com.pk.engineering.consumer.model.db.ErrorLog;

@Service
@Transactional
public class ErrorLogServiceImpl implements ErrorLogService {

  private JpaDaoImpl<ErrorLog> dao;

  @Autowired
  public ErrorLogServiceImpl(JpaDaoImpl<ErrorLog> dao) {
    this.dao = dao;
    this.dao.setClazz(ErrorLog.class);
  }

  @Override
  public ErrorLog createErrorLog(ErrorLog errorLog) {
    dao.create(errorLog);
    return errorLog;
  }

  @Override
  public ErrorLog updateErrorLog(ErrorLog errorLog) {
    return dao.update(errorLog);
  }

  @Override
  public ErrorLog getErrorLog(Long id) {
    return dao.findOne(id);
  }

  @Override
  public List<ErrorLog> getAllErrorLog() {
    return dao.findAll();
  }

  @Override
  public void deleteErrorLog(Long id) {
    dao.deleteById(id);
  }
}
