package com.atsakuraky.ioc_01;

public class ClientService {
  private static ClientService clientService = new ClientService();
  ClientService() {}

  public static ClientService createInstance() {
  
    return clientService;
  }
}