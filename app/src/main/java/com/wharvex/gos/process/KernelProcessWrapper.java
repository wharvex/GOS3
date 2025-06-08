package com.wharvex.gos.process;

import com.google.inject.Inject;
import com.wharvex.gos.logger.ILogger;
import com.wharvex.gos.semaphore.ISemaphoreFactory;

public class KernelProcessWrapper extends AbstractProcessWrapper
    implements IKernelProcessWrapper {
  @Inject
  public KernelProcessWrapper(ISemaphoreFactory semaphoreFactory,
                              ILogger logger) {
    // Maybe pass the logger in here as well?
    super(() -> {
      logger.logCPU("Kernel process running");
      return 0;
    }, semaphoreFactory);
  }
}
