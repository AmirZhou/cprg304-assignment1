package shapes;


/**
 * The super class of {@link Prism}, {@link Cone}, {@link Pyramid}, and {@link Cylinder}
 * 
 * @author Yue (Amir) Zhou
 * @version 0.1 
 * 
 */
public abstract class Shape implements Comparable<Shape>{
	
	private final double height;
	public double getHeight() {
		return this.height;
	}
	
	protected Shape(Builder<?> builder) {
		this.height = builder.height;
	}
	
	
	/**
	 * 
	 * @param <T> T is the subclass's type, so that the self() method returns correct type: the subclasses' builder.
	 */
	public abstract static class Builder<T extends Builder<T>> {
		public double height;
		
		public T setHeight(double height) {
			this.height = height;
			return self();
		}
		
		@SuppressWarnings("unchecked")
		public T self() {
			return (T) this;
		}
		
		public abstract Shape build();
		
	}
	
	
	public abstract double calcVolumn();
	public abstract double calcBaseArea();
	
	@Override
	public int compareTo(Shape shape) {
		return Double.compare(this.getHeight(), shape.getHeight());
	}
	
	
	@Override
	public String toString() {
		return "Shape: Height" + this.getHeight();
	}
}
