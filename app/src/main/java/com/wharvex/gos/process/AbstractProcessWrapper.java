package com.wharvex.gos.process;

import com.google.inject.Inject;
import com.wharvex.gos.logger.ILogger;
import com.wharvex.gos.semaphore.ISemaphore;
import com.wharvex.gos.semaphore.ISemaphoreFactory;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public abstract class AbstractProcessWrapper implements IProcessWrapper {
  private String threadName;
  private GOSProcess process;

  public AbstractProcessWrapper(Supplier<Integer> runLogic) {
    threadName = getClass().getSimpleName() + "_" +
        UUID.randomUUID().toString().substring(0, 8);
    process = new GOSProcess();
    process.setThread(new Thread(process, threadName));
    process.setRunLogic(runLogic);
  }

  private class GOSProcess implements Runnable {
    private Supplier<Integer> runLogic;
    private Thread thread;
    private ISemaphore semaphore;
    @Inject
    private ISemaphoreFactory semaphoreFactory;
    private boolean stopRequested;
    @Inject
    protected ILogger logger;

    public void GOSProcess() {
      semaphore = semaphoreFactory.createSemaphore(threadName);
    }

    public void setThread(Thread thread) {
      this.thread = thread;
    }

    public void setRunLogic(Supplier<Integer> runLogic) {
      this.runLogic = runLogic;
    }

    public void init() {
      thread.start();
    }

    public void stop() {
      semaphore.callAcquire();
    }

    public void start() {
      semaphore.callRelease();
    }

    @Override
    public void run() {
      runLogic.get();
    }
  }
}
