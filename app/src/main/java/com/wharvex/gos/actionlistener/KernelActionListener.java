package com.wharvex.gos.actionlistener;

import com.google.inject.Inject;
import com.wharvex.gos.process.AbstractKernelProcess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KernelActionListener implements ActionListener {
  private AbstractKernelProcess kernelProcess;

  @Inject
  public void setKernelProcess(AbstractKernelProcess kernelProcess) {
    kernelProcess.setThread();
    this.kernelProcess = kernelProcess;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    kernelProcess.init();
  }
}
