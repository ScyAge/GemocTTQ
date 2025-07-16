package main.java.gemocServer;

import main.java.gemocServer.routes.AllTraceRoute;
import main.java.gemocServer.routes.FetchAllAvailableTrace;
import main.java.gemocServer.routes.GetChoosenTrace;
import main.java.gemocServer.routes.PostChoosenTrace;
import main.java.gemocServer.routes.StepRoute;
import main.java.gemocServer.routes.TestRuntimeRoute;
import main.java.gemocServer.routes.TraceNameContainer;
import io.javalin.Javalin;

public class GemocServer {

    private final Javalin app = Javalin.create();
    private final AllTraceRoute allTraceRoute = new AllTraceRoute();
    private final StepRoute stepRoute = new StepRoute();
    private final TestRuntimeRoute runRoute = new TestRuntimeRoute();
    private final FetchAllAvailableTrace fetch = new FetchAllAvailableTrace();
    private PostChoosenTrace postTrace;
    private final TraceNameContainer container = new TraceNameContainer();
    private GetChoosenTrace getTrace;
    private static final int port = 8740;

    public GemocServer() {
    	this.postTrace = new PostChoosenTrace(container);
    	this.getTrace = new GetChoosenTrace(container);
        app.get("/", ctx -> ctx.result("test"))
                .get("/fetchAllAvailableTrace", fetch::result)
                .get("/runTime", runRoute::result)
        		.post("/postTraceName",postTrace::result )
        		.get("/getParsedTrace", getTrace::result);
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
