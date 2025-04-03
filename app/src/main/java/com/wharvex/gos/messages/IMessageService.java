package com.wharvex.gos.messages;

public interface IMessageService {
  String getMessage();

  void setThread(Thread thread);

  Thread getThread();

  void runThread();
}
