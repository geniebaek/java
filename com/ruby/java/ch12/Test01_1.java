package com.ruby.java.ch12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test01_1 {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("usage");
			return;
		}
		System.out.println(args[0] + "\n" + args[1]);
		long start=System.currentTimeMillis();
		copyfile(args[0], args[1]);
		System.out.println("copyFile :"+(System.currentTimeMillis()-start));
	    start=System.currentTimeMillis();
		copyfile1(args[0], args[1]);
		System.out.println("copyFile :"+(System.currentTimeMillis()-start));


	}

	private static void copyfile1(String string, String string2) {

		try (BufferedInputStream fi = new BufferedInputStream(new FileInputStream(string)); 
				BufferedOutputStream fo = new BufferedOutputStream(new FileOutputStream(string2));) {
			int c = 0;
			while ((c = fi.read()) != -1) {
				fo.write(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
		
	

	private static void copyfile(String string, String string2) {

		try (FileInputStream fi = new FileInputStream(string); 
				FileOutputStream fo = new FileOutputStream(string2);) {
			int c = 0;
			while ((c = fi.read()) != -1) {
				fo.write(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
