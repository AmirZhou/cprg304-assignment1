package shapes;

public class TriangularPrism extends Prism {
	
	private TriangularPrism(TriangularPrismBuilder builder) {
		super(builder);
	}
	
	public class TriangularPrismBuilder extends Prism.PrismBuilder<TriangularPrismBuilder> {
		
		@Override
		public TriangularPrism build() {
			return new TriangularPrism(this);
		}
	}
	
	@Override
	public double calcBaseArea() {
		return (Math.pow(this.getSide(), 2) * Math.sqrt(3)) /4;
	}
	
	@Override
	public double calcVolumn() {
		return this.calcBaseArea() * this.getHeight();
	}
	
	@Override
	public String toString() {
		return "TriangularPrism" + this.getHeight() + " Side: " + this.getHeight();
	}
}
