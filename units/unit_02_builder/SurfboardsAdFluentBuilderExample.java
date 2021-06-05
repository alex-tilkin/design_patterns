package unit_02_builder;

import java.util.ArrayList;

class FluentSurfboard {
	public String shaper;
	public int length;
	public int volume;
	public String color;
	
	@Override
	public String toString() {
		return String.format("Shaper: %s; Length: %d; Volume: %d; Color: %s\n", shaper, length, volume, color);
	}
}

class FluentSurfboardBuilder {
	private FluentSurfboard surfboard;

	FluentSurfboardBuilder newSufboard() {
		surfboard = new FluentSurfboard();
		
		return this;
	}
	
	FluentSurfboardBuilder addShaper(String shaper) {
		surfboard.shaper = shaper;
		
		return this;
	}
	
	FluentSurfboardBuilder addLength(int length) {
		surfboard.length = length;

		return this;
	}
	
	FluentSurfboardBuilder addVolume(int volume) {
		surfboard.volume = volume;

		return this;
	}
	
	FluentSurfboardBuilder addColor(String color) {
		surfboard.color = color;

		return this;
	}
	
	FluentSurfboard build() {
		return surfboard;
	}
}

class FluentSurfboardsAdBuilder {
	private String title;
	private ArrayList<FluentSurfboard> surfboards = new ArrayList<FluentSurfboard>();
	
	public FluentSurfboardsAdBuilder(String title) {
		this.title = title;
	}
	
	public void addSurfboard(FluentSurfboard surfboard) {
		surfboards.add(surfboard);
	}
	
	void clear() {
		surfboards.clear();
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append(title + "\n");
		String sRepeated = new String(new char[title.length()]).replace('\0', '=');

		stringBuffer.append(sRepeated + "\n");
		surfboards.stream().forEach(surfboard -> stringBuffer.append(surfboard));
		
		return stringBuffer.toString();
	}
}

public class SurfboardsAdFluentBuilderExample {

	public static void main(String[] args) {
		FluentSurfboardsAdBuilder surfboards = new FluentSurfboardsAdBuilder("Surfboards TLV");
		FluentSurfboardBuilder fluentSurfboardBuilder = new FluentSurfboardBuilder();
		
		FluentSurfboard channelIslandSurfboard = fluentSurfboardBuilder.newSufboard().addColor("blue").addLength(6).addVolume(20).addShaper("Channel Islands").build();
		FluentSurfboard harleySurfboard = fluentSurfboardBuilder.newSufboard().addColor("red").addLength(7).addVolume(22).addShaper("Hurley").build();
		
		surfboards.addSurfboard(channelIslandSurfboard);
		surfboards.addSurfboard(harleySurfboard);
		
		System.out.println(surfboards);
	}
}