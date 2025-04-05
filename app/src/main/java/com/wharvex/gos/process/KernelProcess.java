package com.wharvex.gos.process;

public class KernelProcess extends AbstractKernelProcess {
  @Override
  public void run() {
    logger.log("Kernel process started");
  }
}
