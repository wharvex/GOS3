/*
 * This source file was generated by the Gradle 'init' task
 */
package com.wharvex.gos.app;

import com.google.inject.Guice;
import com.wharvex.gos.client.Client;
import com.wharvex.gos.injector.AppInjector;

public class App {
  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String[] args) {
    var injector = Guice.createInjector(new AppInjector());
    var client = injector.getInstance(Client.class);
    client.startApp();
  }
}
