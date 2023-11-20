package Bilhete;

import modelo.Bagagem;

public class Executiva extends Bilhete {
	private Bagagem bagagens;

	public final Bagagem getBagagens() {
		return bagagens;
	}

	public final void setBagagens(Bagagem bagagens) {
		this.bagagens = bagagens;
	}

	public Executiva(Bagagem bagagens) {
		super();
		this.bagagens = bagagens;
	}

	public Executiva() {
		super();
	}

	@Override
	protected Integer maximoBagagens() {
		return 2;
	}
	
	
}
