package com.wharvex.gos.window;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class AbstractWindow extends JFrame implements IWindow {
  private JTextArea westConsole;
  private JTextArea centerConsole;
  private JTextArea eastConsole;
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
    westConsole = new JTextArea();
    westConsole.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(westConsole);
    setButtons();

    // Create/configure/add control panel; add scroll pane.
    JPanel controlPanel = new JPanel();
    buttons.forEach(button -> {
      controlPanel.add(button);
    });
    add(controlPanel, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);
  }

  private void initializeConsoles() {

  }

  private void writeToConsole(JTextArea console, String message) {
    SwingUtilities.invokeLater(() -> {
      console.append(message + "\n");
      console.setCaretPosition(console.getDocument().getLength());
    });
  }

  @Override
  public void writeToWestConsole(String message) {
    writeToConsole(westConsole, message);
  }

  @Override
  public void writeToCenterConsole(String message) {
    writeToConsole(centerConsole, message);
  }

  @Override
  public void writeToEastConsole(String message) {
    writeToConsole(eastConsole, message);
  }
}
