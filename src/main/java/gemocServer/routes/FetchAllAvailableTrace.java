package main.java.gemocServer.routes;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.javalin.http.Context;

public class FetchAllAvailableTrace extends AbstractRoute{
	
	private final Path traceFolder = Paths.get("./traceContainer");
	
	public FetchAllAvailableTrace() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void result(Context context) {
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(traceFolder)){
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			stream.forEach(entry -> builder.append(String.format("\"%s\",",entry.getFileName())));
			builder.deleteCharAt(builder.length()-1);
			builder.append("]");
			stream.close();
			context.status(200).json(builder.toString());
		}
		catch(IOException | DirectoryIteratorException e) {
			context.status(300);
			e.printStackTrace();
		}
		
	}

}
