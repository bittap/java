package test;

import java.util.Arrays;

public class StringE {
    private final char value[];
    
    public StringE() {
    	this.value = null;
        //this.value = "".value;
	}
    
    public StringE(char value[]) {
    	this.value = Arrays.copyOf(value, value.length);
    }
    
    public StringE(char value[], int offset, int count) {
    	if(offset < 0 ) {
    		throw new StringIndexOutOfBoundsException(offset);
    	}
    	
    }
}
