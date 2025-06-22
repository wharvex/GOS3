package com.wharvex.gos.semaphore;

import com.wharvex.gos.logger.ILogger;

public interface ISemaphoreFactory {
  ISemaphore createSemaphore(String threadName, ILogger logger);
}
