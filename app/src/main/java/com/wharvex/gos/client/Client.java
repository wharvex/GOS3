package com.wharvex.gos.client;

import com.google.inject.Inject;
import com.wharvex.gos.logger.ILogger;
import com.wharvex.gos.window.AbstractWindow;

import javax.swing.*;

public class Client {
  @Inject
  private ILogger logger;
  @Inject
  private AbstractWindow window;

  public void startApp() {
    SwingUtilities.invokeLater(() -> {
      window.setVisible(true);
    });
  }
}
