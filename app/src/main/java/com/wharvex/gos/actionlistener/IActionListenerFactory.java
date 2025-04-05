package com.wharvex.gos.actionlistener;

import com.wharvex.gos.process.AbstractProcess;

import java.awt.event.ActionEvent;
import java.util.function.BiConsumer;

public interface IActionListenerFactory {
  AbstractActionListener createActionListener(
      BiConsumer<AbstractProcess, ActionEvent> actionConsumer,
      AbstractProcess process);
}
