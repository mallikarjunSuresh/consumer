package com.pk.engineering.consumer.dao;

import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class JpaDaoImpl< T> extends AbstractJpaDao<T>{

  @Override
  public T findOne(long id) {
    return entityManager.find( clazz, id );
  }

  @Override
  public List<T> findAll() {
    return entityManager.createQuery( "from " + clazz.getName()).getResultList();
  }

  @Override
  public void create(T entity) {
    entityManager.persist( entity );
    
  }

  @Override
  public T update(T entity) {
    return entityManager.merge( entity );
  }

  @Override
  public void delete(T entity) {
    entityManager.remove( entity );
    
  }

  @Override
  public void deleteById(long entityId) {
    T entity = findOne( entityId );
    delete( entity );
    
  }

}
