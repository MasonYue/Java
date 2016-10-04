package e1;


public class TestGaussInteger {

	public static void main(String[] args) {
		GaussInteger x = new GaussInteger();
		GaussInteger y = new GaussInteger(2,3);
		System.out.println(x);
		System.out.println(y);
		System.out.println(x.getReal());
		System.out.println(y.getReal());
		System.out.println(x.getImag());
		System.out.println(y.getImag());
		
		GaussInteger z = new GaussInteger(1,2);
		System.out.println(z);
		z.setReal(3);
		System.out.println(z);
		z.setImag(3);
		System.out.println(z);
		System.out.println(y.add(z));
		System.out.println(y.moduleSquared());
		System.out.println(y.equals(z));
		GaussInteger m = new GaussInteger(2,3);
		System.out.println(y.equals(m));
		System.out.println(y.equals(y));
		System.out.println(y.equals("x"));

	}

}
