package com.wharvex.gos.client;

import com.google.inject.Inject;
import com.wharvex.gos.logging.ILogger;
import com.wharvex.gos.messages.IMessageService;
import com.wharvex.gos.windowing.AbstractWindow;

import javax.swing.*;

public class Client {
  private IMessageService messageService;
  private ILogger logger;
  private AbstractWindow window;

  @Inject
  public void setService(IMessageService service) {
    service.setThread(new Thread(() -> {
      System.out.println("Thread: " + Thread.currentThread().getName());
    }, "MessageServiceThread"));
    this.messageService = service;
  }

  @Inject
  public void setLogger(ILogger logger) {
    this.logger = logger;
  }

  @Inject
  public void setWindow(AbstractWindow window) {
    this.window = window;
  }

  public void printMessage() {
    SwingUtilities.invokeLater(() -> {
      window.setVisible(true);
    });
    System.out.println(messageService.getMessage());
    messageService.runThread();
    logger.log("Message logged: " + messageService.getMessage());
  }
}
