package com.wharvex.gos.semaphore;

import java.util.concurrent.Semaphore;

public abstract class AbstractSemaphore extends Semaphore {
  protected String threadName;

  public AbstractSemaphore(String threadName) {
    super(0);
    this.threadName = threadName;
  }
}
