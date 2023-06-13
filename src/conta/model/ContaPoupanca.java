package conta.model;

public class ContaPoupanca extends Conta {

	private int aniversário;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversário) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversário = aniversário;
	}

	public int getAniversário() {
		return aniversário;
	}

	public void setAniversário(int aniversário) {
		this.aniversário = aniversário;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("    |     Aniversário da conta: " + this.aniversário);
	}

}
