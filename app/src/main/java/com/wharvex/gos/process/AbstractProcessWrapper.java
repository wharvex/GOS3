package com.wharvex.gos.process;

import com.wharvex.gos.logger.ILogger;
import com.wharvex.gos.semaphore.ISemaphore;
import com.wharvex.gos.semaphore.ISemaphoreFactory;

import java.util.UUID;
import java.util.function.Supplier;

public abstract class AbstractProcessWrapper implements IProcessWrapper {
  private final GOSProcess process;

  /**
   * We won't be subclassing GOSProcess, so accept unique process logic here.
   *
   * @param runLogic
   */
  public AbstractProcessWrapper(Supplier<Integer> runLogic,
                                ISemaphoreFactory semaphoreFactory,
                                ILogger logger
  ) {
    var threadName = getClass().getSimpleName() + "_" +
        UUID.randomUUID().toString().substring(0, 8);
    process = new GOSProcess(runLogic, semaphoreFactory, threadName, logger);
    process.setThread(new Thread(process, threadName));
  }

  @Override
  public void init() {
    process.init();
  }

  @Override
  public void start() {
    process.start();
  }

  @Override
  public void stop() {
    process.requestStop();
  }

  private static final class GOSProcess implements Runnable {
    private final Supplier<Integer> runLogic;
    private Thread thread;
    private boolean stopRequested;
    private final ISemaphore semaphore;
    private final ILogger logger;

    public GOSProcess(Supplier<Integer> runLogic,
                      ISemaphoreFactory semaphoreFactory,
                      String threadName, ILogger logger) {
      this.runLogic = runLogic;
      this.semaphore = semaphoreFactory.createSemaphore(threadName, logger);
      this.logger = logger;
    }

    public void setThread(Thread thread) {
      this.thread = thread;
    }

    public void init() {
      logger.logCPU(
          "About to directly start thread " + thread.getName() +
              " from thread: " +
              Thread.currentThread().getName());
      thread.start();
    }

    public void start() {
      semaphore.callRelease();
    }

    private void stop() {
      semaphore.callAcquire();
    }

    private void resetRequestStop() {
      stopRequested = false;
    }

    public void requestStop() {
      stopRequested = true;
    }

    public void cooperate() {
      if (stopRequested) {
        resetRequestStop();
        stop();
      }
    }

    @Override
    public void run() {
      while (true) {
        runLogic.get();
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        cooperate();
      }
    }
  }
}
