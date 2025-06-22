package com.wharvex.gos.os;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.wharvex.gos.process.IKernelProcessWrapper;
import com.wharvex.gos.process.IProcessWrapper;

@Singleton
public class OS implements IOS {
  private final IKernelProcessWrapper kernelProcessWrapper;

  @Inject
  public OS(IKernelProcessWrapper kernelProcessWrapper) {
    this.kernelProcessWrapper = kernelProcessWrapper;
  }

  @Override
  public void createProcess(IProcessWrapper process) {
    process.init();
  }

  @Override
  public void startup() {
    kernelProcessWrapper.init();
  }

  @Override
  public void shutdown() {
    kernelProcessWrapper.stop();
  }
}
