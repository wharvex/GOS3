package com.wharvex.gos.semaphore;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import java.text.MessageFormat;

public class OwnedBinarySemaphore extends AbstractSemaphore {
  @Inject
  public OwnedBinarySemaphore(@Assisted String threadName) {
    super(threadName);
  }

  @Override
  public void acquire() throws InterruptedException {
    validateThread();
    validatePermits();
    super.acquire();
  }

  @Override
  public void release() {
    while (!hasQueuedThreads()) {
    }
    validatePermits();
    super.release();
  }

  private void validatePermits() {
    if (availablePermits() > 0) {
      throw new IllegalStateException(
          "Semaphore has too many permits: " + availablePermits());
    }
  }

  private void validateThread() {
    if (!Thread.currentThread().getName().equals(threadName)) {
      throw new IllegalStateException(MessageFormat.format(
          "Semaphore expected owner thread {0}, found {1}.",
          threadName, Thread.currentThread().getName()));
    }
  }
}
