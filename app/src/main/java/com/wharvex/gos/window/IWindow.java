package com.wharvex.gos.window;

public interface IWindow {
  void writeToWestConsole(String message);
  void writeToCenterConsole(String message);
  void writeToEastConsole(String message);

  void makeVisible();
}