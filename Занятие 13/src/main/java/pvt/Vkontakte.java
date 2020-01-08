package pvt;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class Vkontakte {

    public void postOnTheWall(CloseableHttpClient client) throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.post?");
        builder.setParameter("access_token", "7ee18d68dd8090fd52300a03eb3cf234445d4c5f7400a8e259138fae07cc5a44db14267bbd0a3b01306ef")
                .setParameter("owner_id", "268840289")
                .setParameter("message", "123456")
                .setParameter("v", "5.103");
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    public String getLastPostId(CloseableHttpClient client) throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.get?");
        builder.setParameter("access_token", "7ee18d68dd8090fd52300a03eb3cf234445d4c5f7400a8e259138fae07cc5a44db14267bbd0a3b01306ef")
                .setParameter("owner_id", "268840289")
                .setParameter("v", "5.103");
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        String s = EntityUtils.toString(response.getEntity());
        String lastId = null;
        int countIdSize = 0;
        for (int i = 0; i <= s.length(); i++) {
            if ("id".equals(s.substring(i, i + 2))) {
                for (int x = i + 4; x <= i + 100; x++) {
                    if (',' != s.charAt(x)) {
                        countIdSize++;
                    } else {
                        break;
                    }
                }
                lastId = s.substring(i + 4, i + 4 + countIdSize);
                break;
            } else {
                lastId = "not found";
            }
        }
        return lastId;
    }

    public String getLastPostText(CloseableHttpClient client) throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.get?");
        builder.setParameter("access_token", "7ee18d68dd8090fd52300a03eb3cf234445d4c5f7400a8e259138fae07cc5a44db14267bbd0a3b01306ef")
                .setParameter("owner_id", "268840289")
                .setParameter("v", "5.103");
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        String s = EntityUtils.toString(response.getEntity());
        String postText = null;
        int countTextSize = 0;
        for (int i = 0; i <= s.length(); i++) {
            if ("text".equals(s.substring(i, i + 4))) {
                for (int x = i + 7; x <= i + 100; x++) {
                    if ('"' != s.charAt(x)) {
                        countTextSize++;
                    } else {
                        break;
                    }
                }
                postText = s.substring(i + 7, i + 7 + countTextSize);
                break;
            } else {
                postText = "not found";
            }
        }
        return postText;
    }

    public String getDeleteResponse(CloseableHttpClient client) throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.get?");
        builder.setParameter("access_token", "7ee18d68dd8090fd52300a03eb3cf234445d4c5f7400a8e259138fae07cc5a44db14267bbd0a3b01306ef")
                .setParameter("owner_id", "268840289")
                .setParameter("v", "5.103");
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        return EntityUtils.toString(response.getEntity());
    }

    public boolean postIsFine(CloseableHttpClient client) throws URISyntaxException, IOException {
        return "123456".equals(getLastPostText(client));
    }

    public boolean postEdited(CloseableHttpClient client) throws URISyntaxException, IOException {
        return "1234567".equals(getLastPostText(client));
    }

    public void editPost(CloseableHttpClient client) throws URISyntaxException, IOException {
        URIBuilder builder2 = new URIBuilder("https://api.vk.com/method/wall.edit?");
        builder2.setParameter("access_token", "7ee18d68dd8090fd52300a03eb3cf234445d4c5f7400a8e259138fae07cc5a44db14267bbd0a3b01306ef")
                .setParameter("post_id", getLastPostId(client))
                .setParameter("owner_id", "268840289")
                .setParameter("message", "1234567")
                .setParameter("v", "5.103");
        HttpGet request2 = new HttpGet(builder2.build());
        HttpResponse response2 = client.execute(request2);
        System.out.println(EntityUtils.toString(response2.getEntity()));
    }

    public void deletePost(CloseableHttpClient client) throws URISyntaxException, IOException {
        URIBuilder builder3 = new URIBuilder("https://api.vk.com/method/wall.delete?");
        builder3.setParameter("access_token", "7ee18d68dd8090fd52300a03eb3cf234445d4c5f7400a8e259138fae07cc5a44db14267bbd0a3b01306ef")
                .setParameter("post_id", getLastPostId(client))
                .setParameter("owner_id", "268840289")
                .setParameter("v", "5.103");
        HttpGet request3 = new HttpGet(builder3.build());
        HttpResponse response3 = client.execute(request3);
        System.out.println(EntityUtils.toString(response3.getEntity()));
    }
}
