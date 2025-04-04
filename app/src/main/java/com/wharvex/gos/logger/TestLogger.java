package com.wharvex.gos.logger;

import com.google.inject.Inject;
import com.wharvex.gos.window.AbstractWindow;

import javax.swing.*;

public class TestLogger implements ILogger {
  private AbstractWindow window;

  @Inject
  public void setWindow(AbstractWindow window) {
    this.window = window;
  }

  @Override
  public void log(String message) {
    System.out.println("TestLogger: " + message);
    SwingUtilities.invokeLater(() -> {
      window.writeToConsole("yo");
    });
  }
}
