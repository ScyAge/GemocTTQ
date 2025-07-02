package main.java.gemocServer.metamodelElementWrapper;

import org.eclipse.gemoc.trace.simple.impl.RuntimeContainmentValueImpl;
import org.eclipse.gemoc.trace.simple.impl.RuntimeStateImpl;
import org.eclipse.gemoc.trace.simple.impl.RuntimeStepImpl;
import org.tetrabox.minijava.model.miniJava.semantics.impl.ContextImpl;
import org.tetrabox.minijava.model.miniJava.semantics.impl.FrameImpl;
import org.tetrabox.minijava.model.miniJava.semantics.impl.StateImpl;

public class MetamodelElementWrapper {
	
	private RuntimeStepImpl runtimeStep;

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
	
	protected FrameImpl getChildFrameFromRootFrame(RuntimeStateImpl runtimeState) {
		FrameImpl res = this.getRootFrameOfARuntimeState(runtimeState);
		if(res == null) {
			return null;
		}
		return (FrameImpl) res.getChildFrame();
	}
	
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

}
