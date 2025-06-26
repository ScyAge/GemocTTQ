package main.java.gemocServer.routes;


import io.javalin.http.Context;

public abstract class AbstractRoute {


    /**
     * the result of a request on the specifed route
     */
    public abstract void result(Context context);
}
