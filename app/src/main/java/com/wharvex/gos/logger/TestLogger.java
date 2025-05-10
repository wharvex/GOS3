package com.wharvex.gos.logger;

import com.google.inject.Inject;
import com.wharvex.gos.window.ICPUWindow;

public class TestLogger implements ILogger {
  @Inject
  private ICPUWindow cpuWindow;

  @Override
  public void logCPU(String message) {
    System.out.println("TestLogger: " + message);
    cpuWindow.writeToConsole("yo");
  }
}
