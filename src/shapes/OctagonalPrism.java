package shapes;

public class OctagonalPrism extends Prism {
	
	private OctagonalPrism (OctagonalPrismBuilder builder) {
		super(builder);
	}
	
	public static class OctagonalPrismBuilder extends PrismBuilder<OctagonalPrismBuilder> {
		
		@Override
		public OctagonalPrism build() {
			return new OctagonalPrism(this);
		}
	}
	
	@Override
	public double calcBaseArea() {
		return 2 * ( 1 + Math.sqrt(2)) * Math.pow(this.getSide(), 2);
	}
	
	@Override
	public double calcVolumn() {
		return this.calcBaseArea() * this.getHeight();
	}
	
	@Override
	public String toString() {
		return "\u001B[32m" + "OctagonalPrism: " + "\u001b[0m" ;
	}
}
