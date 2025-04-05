package com.wharvex.gos.injector;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.wharvex.gos.logger.ILogger;
import com.wharvex.gos.logger.TestLogger;
import com.wharvex.gos.process.IKernelProcess;
import com.wharvex.gos.process.KernelProcess;
import com.wharvex.gos.semaphore.ISemaphore;
import com.wharvex.gos.semaphore.ISemaphoreFactory;
import com.wharvex.gos.semaphore.OwnedBinarySemaphore;
import com.wharvex.gos.window.CPUWindow;
import com.wharvex.gos.window.IWindow;

public class AppInjector extends AbstractModule {

  @Override
  protected void configure() {
    bind(ILogger.class).to(TestLogger.class);
    bind(IWindow.class).to(CPUWindow.class);
    bind(IKernelProcess.class).to(KernelProcess.class);
    install(new FactoryModuleBuilder().implement(ISemaphore.class,
        OwnedBinarySemaphore.class).build(ISemaphoreFactory.class));
//    install(
//        new FactoryModuleBuilder().implement(AbstractActionListener.class,
//                ProcessButtonActionListener.class)
//            .build(IActionListenerFactory.class));

    // Uncomment to switch to MessageServiceB
    // bind(IMessageService.class).to(MessageServiceB.class);
  }
}
