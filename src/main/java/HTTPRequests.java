import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPRequests {
    private Post post=null;
    Gson gson = new Gson();
    HttpClient client = HttpClient.newHttpClient();
    public void get(){
        synchronized (this) {
            try {
                HttpRequest getRequest = HttpRequest.newBuilder().
                        GET().
                        uri(new URI("https://jsonplaceholder.typicode.com/posts/1")).build();
                HttpResponse httpResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
                post = gson.fromJson(httpResponse.body().toString(), Post.class);
                notify();
                System.out.println(post);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void post() {
        synchronized (this) {
            try {
                wait();
                String objectToAdd = gson.toJson(post);
                HttpRequest postRequest = HttpRequest.newBuilder().
                        header("content-type", "application/json").
                        POST(HttpRequest.BodyPublishers.ofString(objectToAdd)).
                        uri(new URI("https://jsonplaceholder.typicode.com/posts")).build();
                HttpResponse httpResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
                System.out.println(httpResponse);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
