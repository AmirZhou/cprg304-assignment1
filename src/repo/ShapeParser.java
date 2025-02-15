package repo;

import java.util.List;
import java.util.ArrayList;

import shapes.*;

/**
 * This class consists of methods that parse Strings into Shape[];
 * 
 * <p> static methods
 */
public class ShapeParser {
	
	public Shape[] parse(List<String> lines) {
		
		List<Shape> shapes = new ArrayList<Shape>();
		
		for (int i = 1; i < lines.size(); i++ ) {
			
			// get rid of empty line first.
			
			String[] parts = lines.get(i).split(" ");
			if (parts.length == 3) {
				String type = parts[0];
				double value1 = Double.parseDouble(parts[1]);
				double value2 = Double.parseDouble(parts[2]);
				
				// check type first there're several options.
				switch (type) {
				
					case "Cone":
						// Value1: Height
						// Value2: Radius
						Cone cone = new Cone.ConeBuilder()
							.setHeight(value1)
							.setRadius(value2)
							.build();
						shapes.add(cone);
						break;
					case "Cylinder":
						// Value1: Height
						// Value2: Radius
						Cylinder cylinder = new Cylinder.CylinderBuilder()
							.setHeight(value1)
							.setRadius(value2)
							.build();
						shapes.add(cylinder);
						break;
					case "Pyramid":
						// Value1: Height
						// Value2: Edge Length
						Pyramid pyramid = new Pyramid.PyramidBuilder()
							.setHeight(value1)
							.setSide(value2)
							.build();
						shapes.add(pyramid);
						break;
					
					// All Prism: Value1: height, Value2: side
					case "SquarePrism":
						SquarePrism squarePrism = new SquarePrism.SquarePrismBuilder()
							.setHeight(value1)
							.setSide(value2)
							.build();
						shapes.add(squarePrism);
						break;
					case "TriangularPrism":
						TriangularPrism triangularPrism = new TriangularPrism.TriangularPrismBuilder()
							.setHeight(value1)
							.setSide(value2)
							.build();
						shapes.add(triangularPrism);
						break;
					case "PentagonalPrism":
						PentagonalPrism pentagonalPrism = new PentagonalPrism.PentagonalPrismBuilder()
							.setHeight(value1)
							.setSide(value2)
							.build();
						shapes.add(pentagonalPrism);
						break;
					case "OctagonalPrism":
						OctagonalPrism octagonalPrism = new OctagonalPrism.OctagonalPrismBuilder()
							.setHeight(value1)
							.setSide(value2)
							.build();
						shapes.add(octagonalPrism);
						break;
				}
			}	
		}
		
		return shapes.toArray(new Shape[0]);
	}
	
	
}
