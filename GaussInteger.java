package e1;


	public class GaussInteger {
	private int real, imag;
	
	GaussInteger() {
		this.real = 0;
		this.imag = 0;
	}
	
	GaussInteger(int real, int imag) {
		// your code goes here
		this.real = real;
		this.imag = imag;
	}
	
	public int getReal() {
		return real;
	}

	public void setReal(int real) {
		this.real = real;
	}

	public int getImag() {
		return imag;
	}

	public void setImag(int imag) {
		this.imag = imag;
	}

	// define and code the add method below
	
	// define and code the moduleSquared method below
	
	// define and code the isInvertible method below
	
	// Add the necessary formal parameter
	public GaussInteger add(GaussInteger operand){
		return new GaussInteger(this.real+operand.real,this.imag+operand.imag);
		
	}
	
	public int moduleSquared(){
		return real*real + imag*imag;
	}
	
	public boolean isInvertible(){
		return moduleSquared() == 1;
	}//only when module squared is 1
	
	public boolean equals(Object operand) {
		boolean result = true;
	   // write code that assigns the correct value to result
	   if(this.getClass() == operand.getClass())
		   result = this.real == ((GaussInteger)operand).real
		   && this.imag == ((GaussInteger)operand).imag;
	   // only can return true in this situation
	   else result = false;//others are false
	   return result;
	}
	
	public String toString() {
		String result = "";
		// your code goes here
		if(real==0 && imag==0)
			result += 0;// when real and imag are both 0
		else if(real ==0)
			result = imag + "i";//only real is 0
		else if(imag == 0)
			result += real;//only imag is 0
		else
			result = real + " + " + imag + "i";//both are not 0
		return result;
	}

}


