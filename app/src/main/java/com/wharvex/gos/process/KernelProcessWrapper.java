package com.wharvex.gos.process;

import com.google.inject.Inject;
import com.wharvex.gos.semaphore.ISemaphoreFactory;

public class KernelProcessWrapper extends AbstractProcessWrapper
    implements IKernelProcessWrapper {
  @Inject
  public KernelProcessWrapper(ISemaphoreFactory semaphoreFactory) {
    super(() -> {
      // Kernel process logic goes here
      // This is a placeholder for the actual kernel process logic
      // Replace with the actual implementation
      return 0; // Return an integer as a result of the process
    }, semaphoreFactory);
  }
}
