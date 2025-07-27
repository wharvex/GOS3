package com.wharvex.gos.logger;

import com.google.inject.Inject;
import com.wharvex.gos.window.ICPUWindow;

public class TestLogger implements ILogger {
  private final ICPUWindow cpuWindow;

  @Inject
  public TestLogger(ICPUWindow cpuWindow) {
    this.cpuWindow = cpuWindow;
  }

  @Override
  public void log(String message) {
    System.out.println("TestLogger: " + message);
  }

  @Override
  public void logCPU(String message) {
    log(message);
    cpuWindow.writeToWestConsole(message);
  }
}
