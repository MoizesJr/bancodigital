package com.bancodio.bancoDio;

public class Main {

  public static void main(String[] args) {
    Cliente moizes = new Cliente();
    moizes.setNome("Moizés Jr");
    moizes.setCpf("09863210325");

    Conta cc = new ContaCorrente(moizes);
    Conta poupanca = new ContaPoupanca(moizes);

    cc.depositar(100);
    cc.transferir(10, poupanca);
    cc.imprimirExtrato();
    poupanca.imprimirExtrato();
  }

}