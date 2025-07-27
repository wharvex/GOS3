package com.wharvex.gos.window;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.wharvex.gos.os.IOS;

import javax.swing.*;
import java.util.ArrayList;

@Singleton
public class CPUWindow extends AbstractWindow implements ICPUWindow {
  // TODO: Can we convert this to constructor injection?
  @Inject
  private IOS os;

  @Override
  protected void setButtons() {
    // Create the buttons
    var startButton = new JButton("Start OS");
    var stopButton = new JButton("Stop OS");
    var suspendButton = new JButton("Suspend OS");
    var resumeButton = new JButton("Resume OS");

    // Add action listeners to the buttons
    startButton.addActionListener(e -> os.startup());
    stopButton.addActionListener(e -> {
      writeToWestConsole("Stop button clicked");
    });
    suspendButton.addActionListener(e -> {
      os.suspend();
    });
    resumeButton.addActionListener(e -> {
      os.resume();
    });

    // Add buttons to the list
    buttons = new ArrayList<>();
    buttons.add(startButton);
    buttons.add(stopButton);
    buttons.add(suspendButton);
    buttons.add(resumeButton);
  }

  @Override
  protected void callSetTitle() {
    setTitle("CPU Window");
  }

  @Override
  public void makeVisible() {
    setVisible(true);
  }
}
