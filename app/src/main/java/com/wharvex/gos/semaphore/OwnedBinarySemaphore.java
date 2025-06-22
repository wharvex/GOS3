package com.wharvex.gos.semaphore;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.wharvex.gos.logger.ILogger;

public class OwnedBinarySemaphore extends AbstractSemaphore {
  @Inject
  public OwnedBinarySemaphore(@Assisted String threadName,
                              @Assisted ILogger logger) {
    super(threadName, logger);
  }

  @Override
  public void callAcquire() {
    validateThread();
    validatePermits();
    try {
      logger.logCPU(
          "About to call semaphore acquire on thread " + threadName +
              " from thread " +
              Thread.currentThread().getName());
      super.acquire();
      logger.logCPU(threadName + " continuing.");
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
