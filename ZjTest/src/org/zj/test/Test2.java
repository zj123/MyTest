package org.zj.test;

public class Test2 {

	public static void main(String[] args) {

	}

	public static String abc(String string) {
		if (string.length() <= 1) {
			return string;
		}
		int mod = string.length() / 2;
		String aString = string.substring(0, mod);
		String bString = string.substring(mod);
		return abc(bString) + abc(aString);
	}
}
