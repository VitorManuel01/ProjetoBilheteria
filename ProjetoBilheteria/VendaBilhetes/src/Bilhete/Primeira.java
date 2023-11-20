package Bilhete;

import modelo.Bagagem;

public class Primeira extends Bilhete{
	private Bagagem bagagens;

	public final Bagagem getBagagens() {
		return bagagens;
	}

	public final void setBagagens(Bagagem bagagens) {
		this.bagagens = bagagens;
	}

	public Primeira(Bagagem bagagens) {
		super();
		this.bagagens = bagagens;
	}

	public Primeira() {
		super();
	}

	@Override
	protected Integer maximoBagagens() {
		return 3;
	}
}
