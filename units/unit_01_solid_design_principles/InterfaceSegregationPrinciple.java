package unit_01_solid_design_principles;

class Document{
	
}

interface IMachine{
	void print(Document document);
	void fax(Document document);
	void scan(Document document);
}

class ModernMachine implements IMachine{

	@Override
	public void print(Document document) {
	}

	@Override
	public void fax(Document document) {
	}

	@Override
	public void scan(Document document) {
	}
}

class OldMachine implements IMachine{

	@Override
	public void print(Document document) {
	}

	@Override
	public void fax(Document document) {	
	}

	// For instance, if I don't want to implement this method I need to place a print or throw exception
	@Override
	public void scan(Document document) {
	}
}

interface IPrinter{
	void print(Document document);
}

interface IFax{
	void fax(Document document);
}

interface IScanner{
	void scan(Document document);
}

class Printer implements IPrinter{

	@Override
	public void print(Document document) {
	}
}

class Fax implements IFax{

	@Override
	public void fax(Document document) {
	}
}

class Scanner implements IScanner{

	@Override
	public void scan(Document document) {
	}
}

class MultiFunctionalPrinter implements IPrinter, IFax, IScanner {

	@Override
	public void scan(Document document) {	
	}

	@Override
	public void fax(Document document) {
	}

	@Override
	public void print(Document document) {
	}	
}

public class InterfaceSegregationPrinciple {

	public static void main(String[] args) {
	}
}