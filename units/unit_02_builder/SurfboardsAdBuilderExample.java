package unit_02_builder;

import java.util.ArrayList;

import unit_02_builder.Surfboard.SurfboardBuilder;

class Surfboard {
	private String shaper;
	private int length;
	private int volume;
	private String color;

	private Surfboard() {
	}
	
	@Override
	public String toString() {
		return String.format("Shaper: %s; Length: %d; Volume: %d; Color: %s\n", shaper, length, volume, color);
	}

	static class SurfboardBuilder {
		private static Surfboard surfboard;
	
		static void newSufboard() {
			surfboard = new Surfboard();
		}
		
		static void addShaper(String shaper) {
			surfboard.shaper = shaper;
		}
		
		static void addLength(int length) {
			surfboard.length = length;
		}
		
		static void addVolume(int volume) {
			surfboard.volume = volume;
		}
		
		static void addColor(String color) {
			surfboard.color = color;
		}
		
		static Surfboard build() {
			return surfboard;
		}
		
		static void clear() {
			surfboard = new Surfboard();
		}
	}
}

class SurfboardsAdBuilder {
	private String title;
	private ArrayList<Surfboard> surfboards = new ArrayList<Surfboard>();
	
	public SurfboardsAdBuilder(String title) {
		this.title = title;
	}
	
	public void addSurfboard(Surfboard surfboard) {
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

public class SurfboardsAdBuilderExample {

	public static void main(String[] args) {
		SurfboardsAdBuilder surfboards = new SurfboardsAdBuilder("Surfboards TLV");
		
		Surfboard.SurfboardBuilder.newSufboard();
		Surfboard.SurfboardBuilder.addColor("blue");
		Surfboard.SurfboardBuilder.addLength(6);
		Surfboard.SurfboardBuilder.addVolume(20);
		Surfboard.SurfboardBuilder.addShaper("Channel Islands");
		Surfboard channelIslandsSurfboard = SurfboardBuilder.build();
		
		SurfboardBuilder.clear();
		Surfboard.SurfboardBuilder.addColor("red");
		Surfboard.SurfboardBuilder.addLength(7);
		Surfboard.SurfboardBuilder.addVolume(22);
		Surfboard.SurfboardBuilder.addShaper("Hurley");
		Surfboard harleySurfboard = SurfboardBuilder.build();
		
		surfboards.addSurfboard(channelIslandsSurfboard);
		surfboards.addSurfboard(harleySurfboard);
		
		System.out.println(surfboards);
	}
}