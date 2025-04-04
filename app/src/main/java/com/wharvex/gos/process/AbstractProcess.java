package com.wharvex.gos.process;

public abstract class AbstractProcess implements IProcess {
  private Thread thread;

  @Override
  public void setThread() {
    this.thread = new Thread(this, getClass().getSimpleName());
  }
}
