package Bilhete;

import modelo.Bagagem;

public class Economica extends Bilhete{
	private Bagagem bagagem;

	public final Bagagem getBagagem() {
		return bagagem;
	}

	public final void setBagagem(Bagagem bagagem) {
		this.bagagem = bagagem;
	}

	public Economica(Bagagem bagagem) {
		super();
		this.bagagem = bagagem;
	}

	public Economica() {
		super();
	}

	@Override
	protected Integer maximoBagagens() {
		// TODO Auto-generated method stub
		return 1;
	}	
}
