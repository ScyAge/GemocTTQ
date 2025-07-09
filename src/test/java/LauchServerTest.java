package test.java;

import org.junit.jupiter.api.Test;

import main.java.gemocServer.GemocServer;

public class LauchServerTest {
	
	@Test
	public void lauchServer() {
		GemocServer server = new GemocServer();
        server.start(9006);;
        
        System.out.println("server running");
		
		try {
			Thread.sleep(20000);
			server.stop();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
