package main.java.runtimeStepExplorer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import main.java.gemocServer.metamodelElementWrapper.MetamodelElementWrapper;

public class MetaModelElementExplorer {
	
	private Set<MetamodelElementWrapper> setElement;
	
	
	public MetaModelElementExplorer(Set<MetamodelElementWrapper> element) {
		setElement = element;
	}
	
	public Optional<MetamodelElementWrapper> getWrapper(Object var) {
		Iterator<MetamodelElementWrapper> s = setElement.iterator();
		Optional<MetamodelElementWrapper> found = Optional.empty();
		while(s.hasNext() && !found.isPresent()) {
			found = s.next().test(var);
		}
		if(found.isPresent()) {
			MetamodelElementWrapper test = found.get();
			try {
				List<Object> test2 = this.getSubModelElement(var);
				if(!test2.isEmpty()) {
					List<MetamodelElementWrapper> res = this.getWrappers(test2);
					test.addAllAttribute(res);
					return Optional.of(test);
				}
				return Optional.empty();
				
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Optional.empty();
		
		
	}
	
	public List<MetamodelElementWrapper> getWrappers(List<Object> var) {
		
		List<MetamodelElementWrapper> test = var.stream().map(el -> this.getWrapper(el)).filter(el -> el.isPresent()).map(el -> el.get()).toList();
		return test;
	}
	
	public List<Object> getSubModelElement(Object var) throws IllegalAccessException, InvocationTargetException{
		Class<? extends EObject> classT = var.getClass();
		Method[] tabMethod = classT.getDeclaredMethods();
		List<Object> res = new ArrayList<>();
        for (Method f : tabMethod) {
            if(this.isGetter(f)) {
            	try {
            		res.add(f.invoke(var));
            	}
            	catch(Exception e) {
            		
            	}
                
            }
        }
        return res;
	}
	
	public boolean isGetter(Method method) {
		//TODO: verify that the name of the method contain the name of one of the instance attribute.
		return !method.isVarArgs() && (method.getReturnType() != void.class) && method.getName().startsWith("get");
	}
	
	
}
