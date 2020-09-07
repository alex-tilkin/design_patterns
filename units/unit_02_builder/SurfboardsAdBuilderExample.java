package unit_02_builder;

import java.util.ArrayList;

class SurfboardBuilder {
	private String shaper;
	private int length;
	private int volume;
	private String color;

	public void addShaper(String shaper) {
		this.shaper = shaper;
	}
	
	public void addLength(int length) {
		this.length = length;
	}
	
	public void addVolume(int volume) {
		this.volume = volume;
	}
	
	public void addColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return String.format("Shaper: %s; Length: %d; Volume: %d; Color: %s\n", shaper, length, volume, color);
	}
}

class SurfboardsAdBuilder {
	private String title;
	private ArrayList<SurfboardBuilder> surfboardBuilders = new ArrayList<SurfboardBuilder>();
	
	public SurfboardsAdBuilder(String title) {
		this.title = title;
	}
	
	public void addSurfboard(SurfboardBuilder surfboardBuilder) {
		surfboardBuilders.add(surfboardBuilder);
	}
	
	void clear() {
		surfboardBuilders.clear();
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append(title + "\n");
		String sRepeated = new String(new char[title.length()]).replace('\0', '=');

		stringBuffer.append(sRepeated + "\n");
		surfboardBuilders.stream().forEach(surfboardBuilder -> stringBuffer.append(surfboardBuilder));
		
		return stringBuffer.toString();
	}
}

public class SurfboardsAdBuilderExample {

	public static void main(String[] args) {
		SurfboardsAdBuilder surfboardsAdBuilder = new SurfboardsAdBuilder("Surfboards TLV");
		
		SurfboardBuilder surfboardBuilder1 = new SurfboardBuilder();
		SurfboardBuilder surfboardBuilder2 = new SurfboardBuilder();
		
		surfboardBuilder1.addColor("blue");
		surfboardBuilder1.addLength(6);
		surfboardBuilder1.addVolume(20);
		surfboardBuilder1.addShaper("Channel Islands");
		
		surfboardBuilder2.addColor("red");
		surfboardBuilder2.addLength(7);
		surfboardBuilder2.addVolume(22);
		surfboardBuilder2.addShaper("Hurley");
		
		surfboardsAdBuilder.addSurfboard(surfboardBuilder1);
		surfboardsAdBuilder.addSurfboard(surfboardBuilder2);
		
		System.out.println(surfboardsAdBuilder);
	}
}