package com.wharvex.gos.semaphore;

import java.util.concurrent.Semaphore;

public abstract class AbstractSemaphore extends Semaphore {
  public AbstractSemaphore(int permits) {
    super(permits);
  }
}
