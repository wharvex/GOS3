package com.wharvex.gos.os;

import com.wharvex.gos.process.IProcessWrapper;

public interface IOS {
  void createProcess(IProcessWrapper process);

  void startup();

  void shutdown();
}
