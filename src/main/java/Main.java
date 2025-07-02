package main.java;

import java.lang.reflect.*;
import java.util.List;

import org.tetrabox.minijava.model.miniJava.impl.MethodCallImpl;

import main.java.gemocServer.GemocServer;
import main.java.gemocServer.metamodelElementWrapper.MetamodelElementAdapter;
import main.java.gemocServer.metamodelElementWrapper.MetamodelElementWrapper;
import main.java.gemocServer.metamodelElementWrapper.MethodCallWrapper;
import main.java.gemocServer.metamodelElementWrapper.generatedWrapper.MethodCallImplWrapper;

public class Main {
    public static void main(String[] args) {
    	MetamodelElementWrapper test = new MethodCallWrapper("caca");
   
    	Class <? extends MetamodelElementAdapter> metadata2 = MethodCallImplWrapper.class;
    	Field[] var = metadata2.getDeclaredFields();
    	for(Field i : var  ) {
    		System.out.println(i.getType());
    	}
    	System.out.println(test.getClass());
    }
}