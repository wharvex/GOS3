package com.wharvex.gos.logger;

import com.google.inject.Inject;
import com.wharvex.gos.window.IWindow;

public class TestLogger implements ILogger {
  @Inject
  private IWindow window;

  @Override
  public void log(String message) {
    System.out.println("TestLogger: " + message);
    window.writeToConsole("yo");
  }
}
