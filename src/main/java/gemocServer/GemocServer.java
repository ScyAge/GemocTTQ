package main.java.gemocServer;

import main.java.gemocServer.routes.AllTraceRoute;
import main.java.gemocServer.routes.StepRoute;
import main.java.gemocServer.routes.TestRuntimeRoute;

import io.javalin.Javalin;

public class GemocServer {

    private final Javalin app = Javalin.create();
    private final AllTraceRoute allTraceRoute = new AllTraceRoute();
    private final StepRoute stepRoute = new StepRoute();
    private final TestRuntimeRoute runRoute = new TestRuntimeRoute();
    private static final int port = 8740;

    public GemocServer() {
        app.get("/", ctx -> ctx.result("test"))
                .get("/alltrace", allTraceRoute::result)
                .get("/step", stepRoute::result)
                .get("/runTime", runRoute::result);
    }

    public void start() {
        app.start(port);
    }

    public void stop() {
        app.stop();
    }

    public void start(int port) {
        app.start(port);
    }
}
