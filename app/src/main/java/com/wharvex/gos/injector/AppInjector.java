package com.wharvex.gos.injector;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.wharvex.gos.logger.ILogger;
import com.wharvex.gos.logger.TestLogger;
import com.wharvex.gos.os.IOS;
import com.wharvex.gos.os.OS;
import com.wharvex.gos.process.IKernelProcessWrapper;
import com.wharvex.gos.process.KernelProcessWrapper;
import com.wharvex.gos.semaphore.ISemaphore;
import com.wharvex.gos.semaphore.ISemaphoreFactory;
import com.wharvex.gos.semaphore.OwnedBinarySemaphore;
import com.wharvex.gos.window.CPUWindow;
import com.wharvex.gos.window.ICPUWindow;

public class AppInjector extends AbstractModule {

  @Override
  protected void configure() {
    bind(ILogger.class).to(TestLogger.class);
    bind(ICPUWindow.class).to(CPUWindow.class);
    bind(IKernelProcessWrapper.class).to(KernelProcessWrapper.class);
    bind(IOS.class).to(OS.class);
    install(new FactoryModuleBuilder().implement(ISemaphore.class,
        OwnedBinarySemaphore.class).build(ISemaphoreFactory.class));
  }
}
