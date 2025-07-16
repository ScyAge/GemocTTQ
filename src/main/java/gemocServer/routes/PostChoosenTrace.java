package main.java.gemocServer.routes;

import io.javalin.http.Context;

public class PostChoosenTrace extends AbstractRoute {
	
	private TraceNameContainer cont;	
	public PostChoosenTrace(TraceNameContainer containerName) {
		super();
		this.cont = containerName;
	}

	@Override
	public void result(Context context) {
		String nom = context.body();
		cont.setTraceName(nom);
		System.out.println(cont.getTraceName());
	}

}
