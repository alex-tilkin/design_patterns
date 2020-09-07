package unit_02_builder;

import java.util.ArrayList;

class SurfboardFluentBuilder {
	private String shaper;
	private int length;
	private int volume;
	private String color;

	public SurfboardFluentBuilder addShaper(String shaper) {
		this.shaper = shaper;
		
		return this;
	}
	
	public SurfboardFluentBuilder addLength(int length) {
		this.length = length;
		
		return this;
	}
	
	public SurfboardFluentBuilder addVolume(int volume) {
		this.volume = volume;
	
		return this;
	}
	
	public SurfboardFluentBuilder addColor(String color) {
		this.color = color;
		
		return this;
	}
	
	@Override
	public String toString() {
		return String.format("Shaper: %s; Length: %d; Volume: %d; Color: %s\n", shaper, length, volume, color);
	}
}

class SurfboardsAdFluentBuilder {
	private String title;
	private ArrayList<SurfboardFluentBuilder> surfboardFluentBuilders = new ArrayList<SurfboardFluentBuilder>();
	
	public SurfboardsAdFluentBuilder(String title) {
		this.title = title;
	}
	
	public SurfboardsAdFluentBuilder addSurfboard(SurfboardFluentBuilder surfboardFluentBuilder) {
		surfboardFluentBuilders.add(surfboardFluentBuilder);
		
		return this;
	}
	
	void clear() {
		surfboardFluentBuilders.clear();
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append(title + "\n");
		String sRepeated = new String(new char[title.length()]).replace('\0', '=');

		stringBuffer.append(sRepeated + "\n");
		surfboardFluentBuilders.stream().forEach(surfboardBuilder -> stringBuffer.append(surfboardBuilder));
		
		return stringBuffer.toString();
	}
}

public class SurfboardsAdFluentBuilderExample {

	public static void main(String[] args) {
		SurfboardsAdFluentBuilder surfboardsAdFluentBuilder = new SurfboardsAdFluentBuilder("Surfboards TLV");
		
		SurfboardFluentBuilder surfboardFluentBuilder1 = new SurfboardFluentBuilder();
		SurfboardFluentBuilder surfboardFluentBuilder2 = new SurfboardFluentBuilder();
		
		surfboardFluentBuilder1.addColor("blue").addLength(6).addVolume(20).addShaper("Channel Islands");
		surfboardFluentBuilder2.addColor("red").addLength(7).addVolume(22).addShaper("Hurley");
		
		surfboardsAdFluentBuilder.addSurfboard(surfboardFluentBuilder1).addSurfboard(surfboardFluentBuilder2);
		
		System.out.println(surfboardsAdFluentBuilder);
	}
}