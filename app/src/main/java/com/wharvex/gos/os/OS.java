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
    // Implementation for creating a process
    // This is a placeholder for the actual process creation logic
    // Replace with the actual implementation
    process.init();
    process.start();
  }

  @Override
  public void startup() {
    kernelProcessWrapper.init();
  }
}
