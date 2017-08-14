package com.genesis.exam.enums;

public enum EscalateType {
	FULLL("full"), UNRESOLVED("UNRESOLVED");
	
    private final String text;

    private EscalateType(final String text) {
        this.text = text;
    }
    
    @Override
    public String toString() {
        return text;
    }
}
