package com.anygine.common.server.servicerunner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.google.inject.AbstractModule;

public class CommonModule extends AbstractModule {

  private final String persistenceUnitName;
  
  public CommonModule(String persistenceUnitName) {
    this.persistenceUnitName = persistenceUnitName;
  }
  
  @Override
  protected void configure() {
    bind(EntityManager.class).toInstance(
        Persistence.createEntityManagerFactory(
            persistenceUnitName).createEntityManager());
  }
}
