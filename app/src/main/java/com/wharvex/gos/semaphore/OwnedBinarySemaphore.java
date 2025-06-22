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
          "About to call semaphore acquire from thread: " + threadName);
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
