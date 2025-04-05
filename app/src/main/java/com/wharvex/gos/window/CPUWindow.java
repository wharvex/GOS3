package com.wharvex.gos.window;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.wharvex.gos.process.AbstractKernelProcess;

import javax.swing.*;
import java.util.ArrayList;

@Singleton
public class CPUWindow extends AbstractWindow {
  private AbstractKernelProcess kernelProcess;

  @Inject
  public CPUWindow(AbstractKernelProcess kernelProcess) {
    kernelProcess.setThread();
    this.kernelProcess = kernelProcess;
  }

  @Override
  protected void setButtons() {
    // Create the buttons
    var startButton = new JButton("Start OS");
    var stopButton = new JButton("Stop OS");

    // Add action listeners to the buttons
    startButton.addActionListener(e -> kernelProcess.init());
    stopButton.addActionListener(e -> {
      writeToConsole("Stop button clicked");
      // Add logic to stop the CPU
    });

    // Add buttons to the list
    buttons = new ArrayList<>();
    buttons.add(startButton);
    buttons.add(stopButton);
  }

  @Override
  protected void callSetTitle() {
    setTitle("CPU Window");
  }
}
