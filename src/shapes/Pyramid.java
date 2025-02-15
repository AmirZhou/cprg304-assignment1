package shapes;

public class Pyramid extends Shape {
	
	private final double side;
	public double getSide() {
		return this.side;
	}
	
	private Pyramid(PyramidBuilder builder) {
		super(builder);
		this.side = builder.side;
	}
	
	public static class PyramidBuilder extends Builder<PyramidBuilder> {
		public double side;
		
		public PyramidBuilder setSide(double side) {
			this.side = side;
			return self();
		}
		
		@Override
		public Pyramid build() {
			return new Pyramid(this);
		}
	}
	
	@Override
	public double calcBaseArea() {
		return this.side * this.side;
	}
	
	@Override
	public double calcVolumn() {
		return (this.calcBaseArea() * this.getHeight())/3;
	}
	
	@Override
	public String toString() {
		return "\u001B[32m" + "Pyramid: " + "\u001b[0m" ;
	}

}
