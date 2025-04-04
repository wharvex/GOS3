package com.wharvex.gos.process;

public interface IProcess extends Runnable {
  void init();

  void start();

  void stop();

  void requestStop();

  void setThread();
}
