package com.wharvex.gos.semaphore;

import java.text.MessageFormat;
import java.util.concurrent.Semaphore;

public abstract class AbstractSemaphore extends Semaphore
    implements ISemaphore {
  protected String threadName;

  public AbstractSemaphore(String threadName) {
    super(0);
    this.threadName = threadName;
  }

  protected void validatePermits() {
    if (availablePermits() > 0) {
      throw new IllegalStateException(
          "Semaphore has too many permits: " + availablePermits());
    }
  }

  protected void validateThread() {
    if (!Thread.currentThread().getName().equals(threadName)) {
      throw new IllegalStateException(MessageFormat.format(
          "Semaphore expected owner thread {0}, found {1}.",
          threadName, Thread.currentThread().getName()));
    }
  }
}
