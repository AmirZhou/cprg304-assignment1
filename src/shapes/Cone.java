package shapes;

public class Cone extends Shape {
	
	private final double radius;
	public double getRadius() {
		return this.radius;
	}
	
	private Cone(ConeBuilder builder) {
		super(builder);
		this.radius = builder.radius;
	}
	
	public static class ConeBuilder extends Builder<ConeBuilder> {
		public double radius;
		
		public ConeBuilder setRadius(double radius) {
			this.radius = radius;
			return self();
		}
		
		@Override
		public Cone build() {
			return new Cone(this);
		}
	}
	
	@Override
	public double calcBaseArea() {
		return this.getRadius() * this.getRadius() * Math.PI;
	}
	
	@Override
	public double calcVolumn() {
		return (this.getRadius() * this.getRadius() * Math.PI * this.getHeight()) / 3;
	}
	
	@Override
	public String toString() {
		return "\u001B[32m" + "Cone: " + "\u001b[0m" ;
	}
}
