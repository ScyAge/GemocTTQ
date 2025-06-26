package main.java.gemocServer.routes;

import io.javalin.http.Context;

public class AllTraceRoute extends AbstractRoute {
    @Override
    public void result(Context context) {
        context.status(200).json("Test All Trace Route");
    }
}
