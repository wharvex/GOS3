package com.wharvex.gos.window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWindow extends JFrame implements IWindow {
  private JTextArea westTextArea;
  private JTextArea centerTextArea;
  private JTextArea eastTextArea;

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

    // Create panes.
    JScrollPane westScrollPane = createScrollPane(getWestTextArea());
    JScrollPane centerScrollPane = createScrollPane(getCenterTextArea());
    JScrollPane eastScrollPane = createScrollPane(getEastTextArea());

    // Create control panel.
    JPanel controlPanel = new JPanel();
    setButtons();
    getButtons().forEach(button -> {
      controlPanel.add(button);
    });

    // Add components to frame.
    add(controlPanel, BorderLayout.NORTH);
    add(westScrollPane, BorderLayout.WEST);
    add(centerScrollPane, BorderLayout.CENTER);
    add(eastScrollPane, BorderLayout.EAST);
  }

  private void writeToConsole(JTextArea console, String message) {
    SwingUtilities.invokeLater(() -> {
      console.append(message + "\n");
      console.setCaretPosition(console.getDocument().getLength());
    });
  }

  @Override
  public void writeToWestConsole(String message) {
    writeToConsole(getWestTextArea(), message);
  }

  @Override
  public void writeToCenterConsole(String message) {
    writeToConsole(getCenterTextArea(), message);
  }

  @Override
  public void writeToEastConsole(String message) {
    writeToConsole(getEastTextArea(), message);
  }

  protected List<JButton> getButtons() {
    if (buttons == null) {
      buttons = new ArrayList<>();
    }
    return buttons;
  }

  private JScrollPane createScrollPane(JTextArea textArea) {
    textArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize(new Dimension(200, 400));
    return scrollPane;
  }

  private JTextArea getWestTextArea() {
    if (westTextArea == null) {
      westTextArea = new JTextArea();
    }
    return westTextArea;
  }

  private JTextArea getCenterTextArea() {
    if (centerTextArea == null) {
      centerTextArea = new JTextArea();
    }
    return centerTextArea;
  }

  private JTextArea getEastTextArea() {
    if (eastTextArea == null) {
      eastTextArea = new JTextArea();
    }
    return eastTextArea;
  }

}
