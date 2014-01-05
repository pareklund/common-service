package com.anygine.common.server.servicerunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ServiceConfig {

  public static final ServiceConfig EMPTY = 
      new ServiceConfig(Collections.<String, Object>emptyMap());
  
  public static class Builder {

    private Map<String, Object> configElements;
    
    public Builder() {
      configElements = new HashMap<String, Object>();
    }
    
    public Builder addConfigValue(String name, Object value) {
      configElements.put(name, value);
      return this;
    }
    
    public ServiceConfig build() {
      return new ServiceConfig(configElements);
    }
  }
  
  private final Map<String, Object> configElements;
  
  private ServiceConfig(Map<String, Object> configElements) {
    this.configElements = Collections.unmodifiableMap(configElements);
  }
  
  public <T> T getConfigValue(String name, T defaultValue) {
    Object o = configElements.get(name);
    if (o == null) {
      return defaultValue;
    }
    return (T) o;
  }
}
