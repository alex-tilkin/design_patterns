package unit_02_builder.solution;

class CodeBuilder {
	private String className;
	private StringBuilder fields; 
	final String FIELD = "    public %s %s;\n"; 
	final String CLASS = "public class %s\n{\n%s}";
	
	public CodeBuilder(String className) {
		this.className = className;
		fields = new StringBuilder(); 
	}

	public CodeBuilder addField(String name, String type) {
		fields.append(String.format(FIELD, type, name));
		return this;
	}

	@Override
	public String toString() {
		return String.format(CLASS, className, fields);
	}
}

public class BuilderExerciseSolution {
	public static void main(String[] args) {
		CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
		System.out.println(cb);
	}
}