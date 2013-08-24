import com.sun.net.httpserver.HttpServer
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.json.JSONException;
import org.json.JSONObject;

@Path("helloworld")
public class HelloWorldResource { // Must be public

	@GET
	@Path("json")
	@Produces("application/json")
	public String json() throws JSONException {
		JSONObject json = new JSONObject();
		json.put("foo", "bar");
		return json.toString();
	}
}

HttpServer server = JdkHttpServerFactory.createHttpServer(
		new URI("http://localhost:9099/"), new ResourceConfig(HelloWorldResource.class));
