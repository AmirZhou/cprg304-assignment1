package appDomain;

import java.io.IOException;
import java.util.function.Function;
import java.util.function.Supplier;
import java.nio.file.Path;
import java.nio.file.Paths;

import repo.*;
import ui.*;
import utilities.*;
import shapes.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class App {
	
	private Repo repo; 
	private final UI ui;
	private SortingStrategy<Shape> sorter;
	private Comparator<Shape> comparator;
	private Function<Shape, String> sortByInfo;
	
	private App(Builder builder) {
		this.repo = builder.repo;
		this.ui = builder.ui;
		this.sorter = builder.sorter;
		this.comparator = builder.comparator;
		this.sortByInfo = builder.sortByInfo;
	}
	
	public void run() {
		try {
			Shape[] shapes = repo.getShapes();
			Shape[] result = sorter.sort(shapes, comparator);
			ui.display("complete"); // format area, volumn, height, base on the select sorting

			// this should take in strategy
			// app should know how to display the result
			// which format, which method get called in the formated string.
			
			// the way App know this is in the sorter and comparator,
			// I need a way, to store the infomation, that based on comparator
			// and the sorting algorithm,
			
			
			for (int i = 0; i < result.length; i++) {
				
				if (i==0 || i == result.length -1 || i % 1000 ==0 ) {					
					String info = result[i].toString();
					String sortby = sortByInfo.apply(result[i]);

				    // Define fixed column widths
				    int infoWidth = 30;  // Adjust as needed
				    int sortByWidth = 40; // Adjust as needed

				    System.out.printf("%-18s %"+infoWidth+"s %-"+sortByWidth+"s%n", 
				        (i == 0) ? "First element is:" :
				        (i == result.length - 1) ? "Last element is:" :
				        i + "-th element:", 
				        info, 
				        sortby
				    );
				    
				}

			}
			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	
	public static class Builder {
		private Repo repo;
		private UI ui;
		private Comparator<Shape> comparator;
		private SortingStrategy<Shape> sorter;
		private Function<Shape,String> sortByInfo;
		
		public Builder of(String[] args) {
			Map<String, String> settings = parseArguments(args);
			
			// set repo
			Path filePath = Paths.get(settings.get("-f"));
			this.repo = Repo.of(filePath);
			
			// set comparator, default to volume
			String compareType = settings.getOrDefault("-t", "v").toLowerCase();
			switch (compareType) {
				case "v":
					this.comparator = (Shape a, Shape b) -> Double.compare(a.calcVolumn(),b.calcVolumn());
					this.sortByInfo = (Shape shape) -> {
						return "Volumn: " + Double.toString(shape.calcVolumn());
					};
					break;
					
				case "a":
					this.comparator = (Shape a, Shape b) -> Double.compare(a.calcBaseArea(), b.calcBaseArea());
					this.sortByInfo = (Shape shape) -> {
						return "Area: " + Double.toString(shape.calcBaseArea());
					};
					break;
					
				case "h":
					this.comparator = (Shape a, Shape b) -> Double.compare(a.getHeight(), b.getHeight());
					this.sortByInfo = (Shape shape) -> {
						return "Height: " + Double.toString(shape.getHeight());
					};
					break;
				
				default:
					this.comparator = (Shape a, Shape b) -> Double.compare(a.getHeight(), b.getHeight());
					this.sortByInfo = (Shape shape) -> {
						return "Height: " + Double.toString(shape.getHeight());
					};
					break;
			}
			
			// set sorting algorithm
			String sortType = settings.getOrDefault("-s", "q");
			switch (sortType) {
				case "b":
					this.sorter = new BubbleSortStrategy<Shape>();
					break;
				case "s":
					this.sorter = new SelectionSortStrategy<Shape>();
					break;
				case "i":
					this.sorter = new InsertionSortStrategy<Shape>();
					break;
				case "m":
					break;
				case "q":
					this.sorter = new QuickSortStrategy<Shape>();
					break;
				case "z":
					break;
					
				default:
					break;
			}
			
			return this;
		}
		
		public App build() {
			this.ui = new ConsoleUI();
			return new App(this);
		}
		
		private static Map<String, String> parseArguments(String[] args) {
			Map<String, String> map = new HashMap<>();
			
			for (String arg: args) {
				if(arg.startsWith("-f") || arg.startsWith("-F")) {
					map.put("-f", arg.substring(2));
				}
				if(arg.startsWith("-s") || arg.startsWith("-S")) {
					map.put("-s", arg.substring(2).toLowerCase());
				}
				if(arg.startsWith("-t") || arg.startsWith("-T")) {
					map.put("-t", arg.substring(2).toLowerCase());
				}
			}
			
			return map;
		}
		
	}
	
	@Override
	public String toString() {
		String info = "App: version 0.1 \n" + "Dependencies: " + this.repo + "\n" + this.ui;
		return info;
	}
}
