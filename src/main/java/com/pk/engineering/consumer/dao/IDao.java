package com.pk.engineering.consumer.dao;

import java.util.List;

public interface IDao<T> {

  public T findOne(long id);

  public List<T> findAll();

  public void create(T entity);

  public T update(T entity);

  public void delete(T entity);

  public void deleteById(long entityId);

}
