package main.java.runtimeStepExplorer;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import main.java.gemocServer.metamodelElementWrapper.MetamodelElementAdapter;

public class MetaModelElementExplorer {
	
	private Set<MetamodelElementAdapter> setElement;
	
	
	public MetaModelElementExplorer(Set<MetamodelElementAdapter> element) {
		setElement = element;
	}
	
	public Optional<MetamodelElementAdapter> getWrapper(Object var) {
		if(var == null) {
			return Optional.empty();
		}
		Iterator<MetamodelElementAdapter> s = setElement.iterator();
		Optional<MetamodelElementAdapter> found = Optional.empty();
		while(s.hasNext() && !found.isPresent()) {
			found = s.next().createAdapterIfInstanceOf(var);
		}
		if(found.isPresent()) {
			return this.getSubWrapper(var, found.get());
		}
		return Optional.empty();
		
		
	}

	private Optional<MetamodelElementAdapter> getSubWrapper(Object var, MetamodelElementAdapter wrapper) {
		List<Object> test2 = this.getSubModelElement(var);
		if(!test2.isEmpty()) {
			Map<Class<? extends Object>, MetamodelElementAdapter> res = this.getWrappers(test2);
			wrapper.addAllAttribute(res);
			return Optional.of(wrapper);
		}
		return Optional.empty();
	}
	
	public Map<Class<? extends Object>, MetamodelElementAdapter> getWrappers(List<Object> listSubAttribute) {
		Map<Class<? extends Object>, MetamodelElementAdapter> res = new HashMap<>();
		for(Object attr : listSubAttribute) {
			Optional<MetamodelElementAdapter> adapter = this.getWrapper(attr);
			if(adapter.isPresent()) {
				res.put(attr.getClass(), adapter.get());
			}
		}
		return res;
	}
	
	
	public List<Object> getSubModelElement(Object var){
		Class<?> classT = var.getClass();
		Method[] tabMethod = classT.getDeclaredMethods();
		List<Object> res = new ArrayList<>();
        for (Method f : tabMethod) {
            if(this.isGetter(f)) {
            	try {
            		res.add(f.invoke(var));
            	}
            	catch(Exception e) {
            		System.out.println("test erreur cast");
            	}
                
            }
        }
        return res;
	}
	
	private boolean isGetter(Method method) {
		//TODO: verify that the name of the method contain the name of one of the instance attribute.
		return !method.isVarArgs() && (method.getReturnType() != void.class) && method.getName().startsWith("get");
	}
	
	
}
