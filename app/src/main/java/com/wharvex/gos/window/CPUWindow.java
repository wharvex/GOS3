package com.wharvex.gos.window;

import com.google.inject.Singleton;

import javax.swing.*;
import java.util.ArrayList;

@Singleton
public class CPUWindow extends AbstractWindow {
  @Override
  protected void setButtons() {
    // Create the buttons
    var startButton = new JButton("Start OS");
    var stopButton = new JButton("Stop OS");

    // Add action listeners to the buttons
    startButton.addActionListener(e -> {
      writeToConsole("Start button clicked");
      // Add logic to start the CPU
    });
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
