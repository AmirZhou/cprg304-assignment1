package shapes;

public class SquarePrism extends Prism {
	
	private SquarePrism(SquarePrismBuilder builder) {
		super(builder);
	}
	
	public static class SquarePrismBuilder extends Prism.PrismBuilder<SquarePrismBuilder> {
		
		@Override
		public SquarePrism build() {
			return new SquarePrism(this);
		}
	}
	
	@Override
	public double calcBaseArea() {
		return this.getSide() * this.getSide();
	}
	
	@Override
	public double calcVolumn() {
		return this.calcBaseArea() * this.getHeight();
	}
	
	@Override
	public String toString() {
		return "\u001B[32m" + "SquarePrism: " + "\u001b[0m" ;
	}
	
}
