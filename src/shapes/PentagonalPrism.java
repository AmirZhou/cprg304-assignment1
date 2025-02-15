package shapes;

public class PentagonalPrism extends Prism {
	
	private PentagonalPrism(PentagonalPrismBuilder builder) {
		super(builder);
	}
	
	public static class PentagonalPrismBuilder extends PrismBuilder<PentagonalPrismBuilder> {
		@Override
		public PentagonalPrism build() {
			return new PentagonalPrism(this);
		}
	}
	
	@Override
	public double calcBaseArea() {
		return (5 * Math.pow(this.getSide(), 2) * Math.tan( 54 * Math.PI / 180)) / 4;
	}
	
	@Override
	public double calcVolumn() {
		return this.calcBaseArea() * this.getHeight();
	}
	
	@Override
	public String toString() {
		return "\u001B[32m" + "PentagonalPrism: " + "\u001b[0m" ;
	}
}
