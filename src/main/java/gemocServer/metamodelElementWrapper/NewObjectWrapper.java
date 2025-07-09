package main.java.gemocServer.metamodelElementWrapper;

import org.tetrabox.minijava.model.miniJava.impl.NewObjectImpl;

import main.java.gemocServer.wrapperVisitor.MetamodelElementWrapperVisitor;

public class NewObjectWrapper extends MetamodelElementWrapper<NewObjectImpl>{

	public NewObjectWrapper(NewObjectImpl wrapped) {
		super(wrapped);
	}

	@Override
	public String accept(MetamodelElementWrapperVisitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}
	
	public String getNewObjectType() {
		return this.wrappedElement.getType().getName();
	}

}
