package shapes;

public class Cylinder extends Shape {
	
	private final double radius;
	public double getRaius() {
		return this.radius;
	}
	
	private Cylinder (CylinderBuilder builder) {
		super(builder);
		this.radius = builder.radius;
	}
	
	public static class CylinderBuilder extends Builder<CylinderBuilder>{
		public double radius;
		
		public CylinderBuilder setRadius(double radius) {
			this.radius = radius;
			return self();
		}
		
		public Cylinder build() {
			return new Cylinder(this);
		}
	}
	
	@Override
	public double calcBaseArea() {
		return Math.PI * this.getRaius() * this.getRaius();
	}
	
	@Override
	public double calcVolumn() {
		return this.calcBaseArea() * this.getHeight();
	}
	
	@Override
	public String toString() {
		return "\u001B[32m" + "Cylinder: " + "\u001b[0m" ;
	}
}
