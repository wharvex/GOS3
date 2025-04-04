package com.wharvex.gos.semaphore;

public interface ISemaphoreFactory {
  AbstractSemaphore createSemaphore(String threadName);
}
