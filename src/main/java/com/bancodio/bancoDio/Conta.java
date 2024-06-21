package com.bancodio.bancoDio;

import lombok.Getter;

@Getter
public abstract class Conta implements IConta {

  private static final int AGENCIA_PADRAO = 1;
  private static int SEQUENCIAL = 1;

  protected int agencia;
  protected int conta;
  protected double saldo;
  protected Cliente cliente;

  public Conta(Cliente cliente) {
    this.agencia = Conta.AGENCIA_PADRAO;
    this.conta = SEQUENCIAL++;
    this.saldo = 0;
    this.cliente = cliente;

  }

  @Override
  public void sacar(double valor) {
    if (valor <= this.saldo) {
      saldo -= valor;
    } else {
      System.out.println("Você não tem saldo suficiente para saque!");
    }
  }

  @Override
  public void depositar(double valor) {
    this.saldo += valor;
  }

  @Override
  public void transferir(double valor, IConta contaDestino) {
    if (valor <= this.saldo) {
      this.sacar(valor);
      contaDestino.depositar(valor);
    } else {
      System.out.println("Saldo insuficiente!");
    }
  }

  @Override
  public void pagarMensalidade() {
    saldo -= 12;
    System.out.println("Pagamento mensalidade realido com sucesso");
  }

  protected void imprimirInfosComuns() {
    System.out.println(String.format("Titular: %s", this.cliente.getNome()));
    System.out.println(String.format("Agencia: %d", this.agencia));
    System.out.println(String.format("Numero: %d", this.conta));
    System.out.println(String.format("Saldo: %.2f", this.saldo));

  }
}
