package main.java;

import java.lang.reflect.*;
import java.util.List;

import org.tetrabox.minijava.model.miniJava.impl.MethodCallImpl;

import main.java.gemocServer.GemocServer;
import main.java.gemocServer.metamodelElementWrapper.MethodCallWrapper;

public class Main {
    public static void main(String[] args) {
    	MethodCallWrapper test = new MethodCallWrapper("caca");
   
    	Class <? extends MethodCallImpl> metadata2 = MethodCallImpl.class;
    	Field[] var = metadata2.getDeclaredFields();
    	for(Field i : var  ) {
    		System.out.println(i.getType());
    	}
    }
}