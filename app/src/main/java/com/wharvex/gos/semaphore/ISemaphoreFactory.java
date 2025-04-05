package com.wharvex.gos.semaphore;

public interface ISemaphoreFactory {
  ISemaphore createSemaphore(String threadName);
}
