package main.java.gemocServer.metamodelElementWrapper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.trace.simple.RuntimeStep;
import org.eclipse.gemoc.trace.simple.impl.RuntimeContainmentValueImpl;
import org.eclipse.gemoc.trace.simple.impl.RuntimeStateImpl;
import org.eclipse.gemoc.trace.simple.impl.RuntimeStepImpl;
import org.tetrabox.minijava.model.miniJava.semantics.impl.ContextImpl;
import org.tetrabox.minijava.model.miniJava.semantics.impl.FrameImpl;
import org.tetrabox.minijava.model.miniJava.semantics.impl.StateImpl;

import main.java.gemocServer.wrapperVisitor.MetamodelElementWrapperVisitor;

public abstract class MetamodelElementWrapper<T extends EObject> {
	
	protected RuntimeStepImpl runtimeStep;
	protected T wrappedElement;
	
	public MetamodelElementWrapper(T elementToWrap) {
		wrappedElement = elementToWrap;
	}
	
	/**
	 * This method crosses the hierarchy of a RuntimeStateImpl object to be able to retrieve the RootFrame.
	 * @param runtimeState
	 * @return a FrameImpl representing the rootFrame
	 */
	private FrameImpl getRootFrameOfARuntimeState(RuntimeStateImpl runtimeState) {
		if(runtimeState == null) {
			return null;
		}
		RuntimeContainmentValueImpl first = (RuntimeContainmentValueImpl) runtimeState
				.getRuntimeExtensions()
				.get(0)
				.getRuntimeBindings().get(0)
				.getRuntimeValue();
		StateImpl second = (StateImpl) first.getRuntimeObject();
		return (FrameImpl) second.getRootFrame();
	}
	
	
	/**
	 * using the getRootFrameOfARuntimeState method, this method returns the ChildFrame from a rootStep
	 * @param runtimeState
	 * @return a FrameImpl representing the childFrame
	 */
	protected FrameImpl getChildFrameFromRootFrame(RuntimeStateImpl runtimeState) {
		FrameImpl res = this.getRootFrameOfARuntimeState(runtimeState);
		if(res == null) {
			return null;
		}
		return (FrameImpl) res.getChildFrame();
	}
	
	/**
	 * using the getRootFrameOfARuntimeState method, this method returns the rootContext from a rootStep
	 * @param runtimeState
	 * @return a ContextImpl representing the rootContext
	 */
	protected ContextImpl getRootContextFromRootFrame(RuntimeStateImpl runtimeState) {
		FrameImpl res = this.getRootFrameOfARuntimeState(runtimeState);
		if(res == null) {
			return null;
		}
		return (ContextImpl) res.getRootContext();
	}
	
	public void setRuntimeStep(RuntimeStepImpl runtimeStep) {
		this.runtimeStep = runtimeStep;
	}
	public RuntimeStep getRuntimeStep() {
		return this.runtimeStep;
	}


	public abstract String accept(MetamodelElementWrapperVisitor visitor);
	
	public T getWrappedElement() {
		return wrappedElement;
	}
	

}
