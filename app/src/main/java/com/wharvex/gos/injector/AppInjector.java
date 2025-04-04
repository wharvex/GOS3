package com.wharvex.gos.injector;

import com.google.inject.AbstractModule;
import com.wharvex.gos.logger.ILogger;
import com.wharvex.gos.logger.TestLogger;
import com.wharvex.gos.window.AbstractWindow;
import com.wharvex.gos.window.CPUWindow;

public class AppInjector extends AbstractModule {

  @Override
  protected void configure() {
    bind(ILogger.class).to(TestLogger.class);
    bind(AbstractWindow.class).to(CPUWindow.class);

    // Uncomment to switch to MessageServiceB
    // bind(IMessageService.class).to(MessageServiceB.class);
  }
}
