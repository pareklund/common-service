package com.anygine.common.server.servicerunner;

import java.util.HashMap;
import java.util.Map;

public abstract class ServiceRunnerBase {

  private static Map<Class<? extends ServiceRunner>, ServiceRunner> serviceRunners =
      new HashMap<>();

  protected volatile boolean running;
  
  public static synchronized <T extends ServiceRunner> T getInstance(
      Class<T> serviceRunnerClass) {
    T serviceRunner = (T) serviceRunners.get(serviceRunnerClass);
    if (serviceRunner == null) {
      try {
        try {
          serviceRunner = serviceRunnerClass.newInstance();
        } catch (IllegalAccessException e) {
          throw new RuntimeException(e);
        }
      } catch (InstantiationException e) {
        throw new RuntimeException(e);
      }
      serviceRunners.put(serviceRunnerClass, serviceRunner);
    }
    return serviceRunner;
  }
  
  
}
