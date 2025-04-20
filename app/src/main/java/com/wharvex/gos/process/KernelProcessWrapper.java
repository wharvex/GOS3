package com.wharvex.gos.process;

import java.util.function.Supplier;

public class KernelProcessWrapper extends AbstractProcessWrapper
    implements IKernelProcessWrapper {
  public KernelProcessWrapper() {
    super(() -> {
      // Kernel process logic goes here
      // This is a placeholder for the actual kernel process logic
      // Replace with the actual implementation
      return 0; // Return an integer as a result of the process
    });
  }

  @Override
  public void init() {

  }

  @Override
  public void start() {

  }

  @Override
  public void stop() {

  }
}
