package main.java.gemocServer.routes;

import io.javalin.http.Context;

public class StepRoute extends AbstractRoute{

    private int step_number;

    public StepRoute() {
        step_number = 0;
    }

    @Override
    public synchronized  void result(Context context) {
        context.status(200).json(String.format("{\"step_number\": %d}", step_number));
        this.addOneStep();
        System.out.println(step_number);
    }

    private synchronized void addOneStep() {
        step_number++;
    }
}
