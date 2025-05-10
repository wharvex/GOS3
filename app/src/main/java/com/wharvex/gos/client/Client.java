package com.wharvex.gos.client;

import com.google.inject.Inject;
import com.wharvex.gos.window.ICPUWindow;

import javax.swing.*;

public class Client {
  @Inject
  private ICPUWindow cpuWindow;

  public void startApp() {
    SwingUtilities.invokeLater(() -> {
      cpuWindow.makeVisible();
    });
  }
}
