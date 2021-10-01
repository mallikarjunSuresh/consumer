package com.pk.engineering.consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.pk.engineering.consumer.dao.IDao;
import com.pk.engineering.consumer.model.db.AuditLog;
import com.pk.engineering.consumer.service.AuditLogServiceImpl;

@SpringBootTest
class AuditLogServiceTest {

  @Autowired
  private IDao<AuditLog> dao;

  @Autowired
  private AuditLogServiceImpl auditLogService;

  @BeforeEach
  public void setup() {
    List<AuditLog> auditLogs = dao.findAll();
    for (AuditLog auditlog : auditLogs) {
      dao.delete(auditlog);
    }
  }

  @Test
  void testAuditLogServiceWhenCreateAuditLogIsCalledWithAuditLogShouldCallCreateDao() {

    // Given
    AuditLog inputAuditLog = new AuditLog();
    inputAuditLog.setCustomerNumber("C000000001");

    // When
    auditLogService.createAuditLog(inputAuditLog);

    // Then
    List<AuditLog> outAuditLogs = dao.findAll();
    assertEquals(inputAuditLog, outAuditLogs.get(0));
  }

  @Test
  void testAuditLogServiceWhenUpdateAuditLogIsCalledWithAuditLogShouldCallUpdateDao() {

    // Given
    AuditLog inputAuditLog = new AuditLog();
    inputAuditLog.setId(123L);
    inputAuditLog.setCustomerNumber("C000000001");
    dao.create(inputAuditLog);


    // When
    AuditLog outAuditLog = new AuditLog();
    outAuditLog.setId(123L);
    outAuditLog.setCustomerNumber("C000000002");
    auditLogService.updateAuditLog(outAuditLog);

    // Then
    AuditLog acutalAuditLog = dao.findOne(123L);
    assertEquals("C000000002", acutalAuditLog.getCustomerNumber());
  }

  @Test
  void testAuditLogServiceWhenDeleteAuditLogIsCalledWithAuditLogShouldCallDeleteDao() {

    // Given
    AuditLog inputAuditLog = new AuditLog();
    inputAuditLog.setId(123L);
    inputAuditLog.setCustomerNumber("C000000001");
    dao.create(inputAuditLog);

    // When
    auditLogService.deleteAuditLog(123L);

    // Then
    AuditLog acutalAuditLog = dao.findOne(123L);
    assertNull(acutalAuditLog.getCustomerNumber());
  }


}


