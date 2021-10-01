package com.pk.engineering.consumer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJpaDao<T> implements IDao<T> {

  protected Class<T> clazz;

  @PersistenceContext
  EntityManager entityManager;

  public final void setClazz(Class<T> clazzToSet) {
    this.clazz = clazzToSet;
  }


}
