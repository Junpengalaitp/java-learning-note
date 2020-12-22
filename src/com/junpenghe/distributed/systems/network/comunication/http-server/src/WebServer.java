import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * @author Junpeng He
 */
public class WebServer {
    private static final String TASK_ENDPOINT = "/task";
    private static final String STATUS_ENDPOINT = "/status";

    private final int port;
    private HttpServer server;

    public WebServer(int port) {
        this.port = port;
    }

    public void startServer() {
        try {
            this.server = HttpServer.create(new InetSocketAddress(port), 0);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        HttpContext statusContext = server.createContext(STATUS_ENDPOINT);
        HttpContext taskContext = server.createContext(TASK_ENDPOINT);

        statusContext.setHandler(this::handlerStatusCheckRequest);
    }

    private void handleTaskRequest(HttpExchange exchange) {
        if (!"post".equalsIgnoreCase(exchange.getRequestMethod())) {
            exchange.close();
            return;
        }
        Headers headers = exchange.getResponseHeaders();
        if (headers.containsKey("X-Test") && "true".equalsIgnoreCase(headers.get("X-Test").get(0))) {

        }
    }

    private void handlerStatusCheckRequest(HttpExchange httpExchange) throws IOException {
        if (!"get".equalsIgnoreCase(httpExchange.getRequestMethod())) {
            httpExchange.close();
            return;
        }
        String responseMessage = "Server is alive";
        sendResponse(responseMessage.getBytes(), httpExchange);
    }

    private void sendResponse(byte[] responseBytes, HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, responseBytes.length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(responseBytes);
        outputStream.flush();
        outputStream.close();
    }
}
