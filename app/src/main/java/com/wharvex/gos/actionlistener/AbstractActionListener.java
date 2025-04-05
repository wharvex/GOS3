package com.wharvex.gos.actionlistener;

import com.wharvex.gos.process.AbstractProcess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BiConsumer;

/**
 * I made this so I can automatically put whatever the button does on the AWT
 * thread (see my use of SwingUtilities.InvokeLater below).
 * <p>
 * For example, if I want to disable a button when it is clicked, do that in
 * the BiConsumer and pass it to the ActionListenerFactory.
 */
public abstract class AbstractActionListener implements ActionListener {
  private BiConsumer<AbstractProcess, ActionEvent> actionConsumer;
  private AbstractProcess process;

  public AbstractActionListener(
      BiConsumer<AbstractProcess, ActionEvent> actionConsumer,
      AbstractProcess process) {
    this.actionConsumer = actionConsumer;
    this.process = process;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    SwingUtilities.invokeLater(() -> {
      actionConsumer.accept(
          process, e
      );
    });
  }
}
