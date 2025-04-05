package com.wharvex.gos.process;

import com.google.inject.Inject;
import com.wharvex.gos.logger.ILogger;
import com.wharvex.gos.semaphore.ISemaphore;
import com.wharvex.gos.semaphore.ISemaphoreFactory;

import java.util.UUID;

public abstract class AbstractProcess implements IProcess {
  private Thread thread;
  private String threadName;
  private ISemaphore semaphore;
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
    semaphore.callAcquire();
  }

  @Override
  public void start() {
    semaphore.callRelease();
  }

  @Override
  public void requestStop() {
    stopRequested = true;
  }
}
