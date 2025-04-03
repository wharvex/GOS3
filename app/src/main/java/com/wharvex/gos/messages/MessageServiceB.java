package com.wharvex.gos.messages;

public class MessageServiceB implements IMessageService {
  private Thread thread;

  @Override
  public String getMessage() {
    return "Hello from MessageServiceB";
  }

  @Override
  public void setThread(Thread thread) {
    this.thread = thread;
    System.out.println("Thread set to: " + thread.getName());
  }

  @Override
  public Thread getThread() {
    return thread;
  }

  @Override
  public void runThread() {
    if (thread != null) {
      thread.start();
    } else {
      System.out.println("Thread is not set.");
    }
  }
}
