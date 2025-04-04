package com.wharvex.gos.client;

import com.google.inject.Inject;
import com.wharvex.gos.logger.ILogger;
import com.wharvex.gos.window.AbstractWindow;

import javax.swing.*;

public class Client {
  private ILogger logger;
  private AbstractWindow window;

  @Inject
  public void setLogger(ILogger logger) {
    this.logger = logger;
  }

  @Inject
  public void setWindow(AbstractWindow window) {
    this.window = window;
  }

  public void printMessage() {
    SwingUtilities.invokeLater(() -> {
      window.setVisible(true);
    });
    logger.log("hey");
  }
}
