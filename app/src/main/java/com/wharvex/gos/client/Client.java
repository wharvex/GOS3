package com.wharvex.gos.client;

import com.google.inject.Inject;
import com.wharvex.gos.window.ICPUWindow;

import javax.swing.*;

public class Client {
  private final ICPUWindow cpuWindow;

  @Inject
  public Client(ICPUWindow cpuWindow) {
    this.cpuWindow = cpuWindow;
  }

  public void startApp() {
    SwingUtilities.invokeLater(() -> {
      cpuWindow.makeVisible();
    });
  }
}
