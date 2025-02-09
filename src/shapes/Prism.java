package shapes;


/**
 * The super class of 4 different prisms:{@link SquarePrism}, {@link TriangularPrism}, {@link pentagonalPrism}, and {@link OctagonaPrism}</br></br>
 * It Extends {@link Shape}.
 * 
 * @author Yue (Amir) Zhou
 * @version 0.1
 */
public abstract class Prism extends Shape{
	
	private final double side;
	public double getSide() {
		return this.side;
	}
	
	protected Prism(PrismBuilder<?> builder) {
		super(builder);
		this.side = builder.side;
	}

	
	public static abstract class PrismBuilder<T extends PrismBuilder<T>> extends Shape.Builder<T> {
		public double side;
		
		public T setSide(double side) {
			this.side = side;
			return self();
		}
		
		public abstract Prism build();
		
	}
	
}
