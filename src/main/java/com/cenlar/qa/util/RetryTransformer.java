package com.cenlar.qa.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryTransformer implements IAnnotationTransformer {

	public void transform(ITestAnnotation aannotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		aannotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
