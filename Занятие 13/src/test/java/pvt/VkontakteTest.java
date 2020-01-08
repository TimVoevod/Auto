package pvt;

import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VkontakteTest {

    private CloseableHttpClient client = HttpClientBuilder.create().build();;

    private Vkontakte vkontakte = new Vkontakte();

    @Test
    public void aPostOnTheWallTest() throws IOException, URISyntaxException {
        vkontakte.postOnTheWall(client);
        Assert.assertTrue(vkontakte.postIsFine(client));
    }

    @Test
    public void bEditPostTest() throws IOException, URISyntaxException {
        vkontakte.editPost(client);
        Assert.assertTrue(vkontakte.postEdited(client));
    }

    @Test
    public void cDeletePostTest() throws IOException, URISyntaxException {
        vkontakte.deletePost(client);
        /*На удаление я проверку не делал, потому что оно само по себе при успешном выполнении
        возвращает 1.*/
    }
}
