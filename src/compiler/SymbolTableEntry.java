package compiler;

import compiler.TokenFinder.Type;

class SymbolTableEntry {
    private Type myType;
    private String myName;
    private double myValue;

    public String getName() {
	return myName;
    }

    public Type getType() {
	return myType;
    }

    public double getValue() {
	return myValue;
    }

    public void setName(String name) {
	myName = name;
    }

    void setType(Type type) {
	myType = type;
    }

    public void setValue(double value) {
	myValue = value;
    }

}