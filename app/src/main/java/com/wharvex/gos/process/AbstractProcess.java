package com.wharvex.gos.process;

import com.google.inject.Inject;
import com.wharvex.gos.logger.ILogger;
import com.wharvex.gos.semaphore.AbstractSemaphore;
import com.wharvex.gos.semaphore.ISemaphoreFactory;

import java.util.UUID;

public abstract class AbstractProcess implements IProcess {
  private Thread thread;
  private String threadName;
  private AbstractSemaphore semaphore;
  @Inject
  private ISemaphoreFactory semaphoreFactory;
  private boolean stopRequested;
  @Inject
  protected ILogger logger;

  @Override
  public void setThread() {
    threadName = getClass().getSimpleName() + "_" +
        UUID.randomUUID().toString().substring(0, 8);
    thread = new Thread(this, threadName);
    semaphore = semaphoreFactory.createSemaphore(threadName);
  }

  @Override
  public void init() {
    thread.start();
  }

  @Override
  public void stop() {
    try {
      semaphore.acquire();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  @Override
  public void start() {
    semaphore.release();
  }

  @Override
  public void requestStop() {
    stopRequested = true;
  }
}
