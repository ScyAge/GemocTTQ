package main.java;

import org.eclipse.gemoc.trace.simple.RuntimeStep;

import test.java.TTQTestResources;






public class GemocTest {
	public static void main(String[] args) {
		RuntimeStep methodCallStep = TTQTestResources.miniJavaMethodCallStepExample();
		System.out.println(methodCallStep);
	}
}
