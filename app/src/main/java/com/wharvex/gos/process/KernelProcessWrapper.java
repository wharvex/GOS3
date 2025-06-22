package com.wharvex.gos.process;

import com.google.inject.Inject;
import com.wharvex.gos.logger.ILogger;
import com.wharvex.gos.semaphore.ISemaphoreFactory;

public class KernelProcessWrapper extends AbstractProcessWrapper
    implements IKernelProcessWrapper {
  @Inject
  public KernelProcessWrapper(ISemaphoreFactory semaphoreFactory,
                              ILogger logger) {
    super(() -> {
      logger.logCPU("KernelProcessWrapper running");
      return 0;
    }, semaphoreFactory, logger);
  }
}
