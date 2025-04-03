package com.wharvex.gos.injectors;

import com.google.inject.AbstractModule;
import com.wharvex.gos.logging.ILogger;
import com.wharvex.gos.logging.TestLogger;
import com.wharvex.gos.messages.IMessageService;
import com.wharvex.gos.messages.MessageServiceA;
import com.wharvex.gos.windowing.AbstractWindow;
import com.wharvex.gos.windowing.CPUWindow;

public class AppInjector extends AbstractModule {

  @Override
  protected void configure() {
    bind(IMessageService.class).to(MessageServiceA.class);
    bind(ILogger.class).to(TestLogger.class);
    bind(AbstractWindow.class).to(CPUWindow.class);

    // Uncomment to switch to MessageServiceB
    // bind(IMessageService.class).to(MessageServiceB.class);
  }
}
