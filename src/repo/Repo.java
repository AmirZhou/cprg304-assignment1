package repo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import shapes.*;

public class Repo {
	
	private final ShapeParser parser;
	private final Path path;
	private Shape[] shapes;
	
	public Shape[] getShapes() throws IOException{
		load();
		return shapes;
	}
	
	private Repo(Path path) {
		this.path = path;
		this.parser = new ShapeParser();
	}
	
	public static Repo of(Path path) {
		return new Repo(path);
	}
	
	private void load() throws IOException{
		this.shapes = parser.parse(getStrings());
	}
	
	private List<String> getStrings() throws IOException {
		return Files.readAllLines(path);
	}	
}
