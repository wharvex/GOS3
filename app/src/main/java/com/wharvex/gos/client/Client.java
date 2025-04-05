package com.wharvex.gos.client;

import com.google.inject.Inject;
import com.wharvex.gos.window.IWindow;
//import com.wharvex.gos.logger.ILogger;

import javax.swing.*;

public class Client {
  //  @Inject
//  private ILogger logger;
  @Inject
  private IWindow window;

  public void startApp() {
    SwingUtilities.invokeLater(() -> {
      window.makeVisible();
    });
  }
}
