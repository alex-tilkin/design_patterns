package unit_01_solid_design_principles;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

enum Size {
	SMALL, MEDIUM, LARGE, HUGE
}

enum Color {  
	WHITE, RED, GREEN, BLUE
}

class Product {
	public String name;
	public Color color;
	public Size size;
	
	public Product(String name, Color color, Size size) {
		this.name = name;
		this.color = color;
		this.size = size;
	}
}

class ProductFilter {
	public static Stream<Product> filterByColor(List<Product> products, Color color){
		return products.stream().filter(product -> product.color == color);
	}
	
	public static Stream<Product> filterBySize(List<Product> products, Size size){
		return products.stream().filter(product -> product.size == size);
	}
	
	public static Stream<Product> filterBySizeAndColor(List<Product> products, Size size, Color color){
		return products.stream().filter(product -> product.size == size && product.color == color);
	}
}

interface ISpecification<T>{
	boolean isStatisfied(T item);
}

interface IFilter<T>{
	Stream<T> filter(List<T> items, ISpecification<T> specification);
}

class ColorSpecification implements ISpecification<Product>{
	Color color;
	
	public ColorSpecification(Color color) {
		this.color = color;
	}
	
	@Override
	public boolean isStatisfied(Product item) {
		return item.color == color;
	}
}

class SizeSpecification implements ISpecification<Product>{
	Size size;
	
	public SizeSpecification(Size size) {
		this.size = size;
	}
	
	@Override
	public boolean isStatisfied(Product item) {
		return item.size == size;
	}
}

class AndSpecification implements ISpecification<Product>{
	public ISpecification<Product> specificationA;
	public ISpecification<Product> specificationB;
	
	public AndSpecification(ISpecification<Product> specificationA, ISpecification<Product> specificationB) {
		this.specificationA = specificationA;
		this.specificationB = specificationB;
	}
	
	@Override
	public boolean isStatisfied(Product item) {
		return specificationA.isStatisfied(item) && specificationB.isStatisfied(item);
	}
}

class Filter implements IFilter<Product>{

	@Override
	public Stream<Product> filter(List<Product> items, ISpecification<Product> specification) {
		return items.stream().filter(item -> specification.isStatisfied(item));
	}
}

public class OpenClosedPrinciple {
	public static void main(String[] args) {
		Product bottle = new Product("bottle", Color.GREEN, Size.SMALL);
		Product cup = new Product("cup", Color.WHITE, Size.SMALL);
		Product surfboard = new Product("surfboard", Color.WHITE, Size.MEDIUM);
		Product car = new Product("Car", Color.BLUE, Size.LARGE);
		Product truck = new Product("Truck", Color.RED, Size.HUGE);
		Product boat = new Product("Boat", Color.GREEN, Size.HUGE);
		
		List<Product> products = Arrays.asList(bottle, cup, surfboard, car, truck, boat);
		System.out.println("\nTrying the old design\n");
		
		System.out.println("Filtering all the products that " + Color.GREEN);
		ProductFilter.filterByColor(products, Color.GREEN).forEach(product -> System.out.println("* " + product.name + " is " + Color.GREEN));
		
		System.out.println("Filtering all the products that " + Size.LARGE);
		ProductFilter.filterBySize(products, Size.LARGE).forEach(product -> System.out.println("* " + product.name + " is " + Size.LARGE));
		
		System.out.println("Filtering all the products that " + Size.HUGE + " " + Color.RED);
		ProductFilter.filterBySizeAndColor(products, Size.HUGE, Color.RED).forEach(product -> System.out.println("* " + product.name + " is " + Size.HUGE + " and " + Color.RED));
		
		System.out.println("\nTrying the new design\n");
		Filter filter = new Filter();
		
		System.out.println("Filtering all the products that " + Color.RED);
		ISpecification<Product> colorSpecification = new ColorSpecification(Color.RED);
		filter.filter(products, colorSpecification).forEach(product -> System.out.println("* " + product.name + " is " + Color.WHITE));
		
		System.out.println("Filtering all the products that " + Size.HUGE);
		ISpecification<Product> sizeSpecification = new SizeSpecification(Size.HUGE);
		filter.filter(products, sizeSpecification).forEach(product -> System.out.println("* " + product.name + " is " + Size.HUGE));
		
		System.out.println("Filtering all the products that " + Size.HUGE + " " + Color.RED);
		ISpecification<Product> andSpecification = new AndSpecification(colorSpecification, sizeSpecification);
		filter.filter(products, andSpecification).forEach(product -> System.out.println("* " + product.name + " is " + Size.HUGE + " and " + Color.RED));
	}
}