package com.anygine.common.server.servicerunner;

import java.util.Arrays;
import java.util.List;

public class ServiceRunnerDependentBase extends ServiceRunnerBase {

  protected List<Class<? extends ServiceRunner>> usedServices;
  
  public ServiceRunnerDependentBase(
      Class<? extends ServiceRunner>... usedServices) {
    this.usedServices = Arrays.asList(usedServices);
  }

  // TODO: Configure which services to run and at which address and port
  public synchronized void startServices(ServiceConfig config) {
    if (!running) {
      for (Class<? extends ServiceRunner> usedService : usedServices) {
        getInstance(usedService).startServices(config);
      }
      running = true;
    }
  }

  // TODO: Configure which services to run and at which address and port
  public synchronized void stopServices() {
    if (running) {
      for (Class<? extends ServiceRunner> usedService : usedServices) {
        getInstance(usedService).stopServices();
      }
      running = false;
    }
  }
}
