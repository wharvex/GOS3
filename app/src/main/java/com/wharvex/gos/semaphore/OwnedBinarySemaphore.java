package com.wharvex.gos.semaphore;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class OwnedBinarySemaphore extends AbstractSemaphore {
  @Inject
  public OwnedBinarySemaphore(@Assisted String threadName) {
    super(threadName);
  }

  @Override
  public void callAcquire() {
    validateThread();
    validatePermits();
    try {
      super.acquire();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void callRelease() {
    while (!hasQueuedThreads()) {
    }
    validatePermits();
    super.release();
  }
}
