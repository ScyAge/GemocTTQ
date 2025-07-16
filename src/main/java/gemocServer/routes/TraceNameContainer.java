package main.java.gemocServer.routes;

public class TraceNameContainer {

	public TraceNameContainer() {
		// TODO Auto-generated constructor stub
	}
	
	private String traceName;

	public synchronized String getTraceName() {
		return traceName;
	}

	public synchronized void setTraceName(String traceName) {
		this.traceName = traceName;
	}
	
	
	

}
