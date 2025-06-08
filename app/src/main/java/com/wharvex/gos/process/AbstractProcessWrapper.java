package com.wharvex.gos.process;

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
                                ISemaphoreFactory semaphoreFactory) {
    var threadName = getClass().getSimpleName() + "_" +
        UUID.randomUUID().toString().substring(0, 8);
    process = new GOSProcess(runLogic, semaphoreFactory, threadName);
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
    process.stop();
  }

  private final class GOSProcess implements Runnable {
    private final Supplier<Integer> runLogic;
    private Thread thread;
    private boolean stopRequested;
    private final ISemaphore semaphore;

    public GOSProcess(Supplier<Integer> runLogic,
                      ISemaphoreFactory semaphoreFactory,
                      String threadName) {
      this.runLogic = runLogic;
      this.semaphore = semaphoreFactory.createSemaphore(threadName);
    }

    public void setThread(Thread thread) {
      this.thread = thread;
    }

    public void init() {
      thread.start();
    }

    public void start() {
      semaphore.callRelease();
    }

    public void stop() {
      if (thread != null && thread.isAlive()) {
        thread.interrupt();
      }
    }

    public void requestStop() {
      stopRequested = true;
    }

    public void cooperate() {
      if (stopRequested) {
        stop();
      }
    }

    @Override
    public void run() {
      runLogic.get();
    }
  }
}
