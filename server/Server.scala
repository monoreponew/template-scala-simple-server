import java.net.InetSocketAddress
import java.util.concurrent.Executors
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer

object Server extends App {
  val executor = Executors.newSingleThreadExecutor()
  val server = HttpServer.create(new InetSocketAddress(8080), 0)
  server.createContext("/", new HttpHandler() {
    override def handle(exchange: HttpExchange) = {
      val msg = "Hello, world!"
      exchange.sendResponseHeaders(200, msg.length())
      val os = exchange.getResponseBody()
      os.write(msg.getBytes())
      os.flush()
      os.close()
    }
  })

  server.setExecutor(executor);
  server.start();
}
