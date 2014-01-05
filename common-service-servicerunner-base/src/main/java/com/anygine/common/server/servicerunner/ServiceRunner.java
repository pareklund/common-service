package com.anygine.common.server.servicerunner;


public interface ServiceRunner {
  void startServices(ServiceConfig config);
  void stopServices();
}
