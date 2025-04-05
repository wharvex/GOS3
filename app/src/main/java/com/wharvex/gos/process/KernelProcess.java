package com.wharvex.gos.process;

public class KernelProcess extends AbstractProcess
    implements IKernelProcess {
  @Override
  public void run() {
    logger.log("Kernel process started");
  }
}
