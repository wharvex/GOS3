package com.wharvex.gos.window;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class AbstractWindow extends JFrame {
  private JTextArea console;
  protected List<JButton> buttons;

  public AbstractWindow() {
    initialize();
  }

  protected abstract void setButtons();

  protected abstract void callSetTitle();

  private void initialize() {
    // Configure frame.
    callSetTitle();
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // Create/configure components.
    console = new JTextArea();
    console.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(console);
    setButtons();

    // Create/configure/add control panel; add scroll pane.
    JPanel controlPanel = new JPanel();
    buttons.forEach(button -> {
      controlPanel.add(button);
    });
    add(controlPanel, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);
  }

  public void writeToConsole(String message) {
    SwingUtilities.invokeLater(() -> {
      console.append(message + "\n");
      console.setCaretPosition(console.getDocument().getLength());
    });
  }
}
