package hexlet.code;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    private static Javalin app;

    @BeforeEach
    public final void setUp() throws IOException, SQLException {
        app = App.getApp();
    }

    @Test
    public void testRootPage() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/");
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains(
                    "Анализатор страниц",
                    "Бесплатно проверяйте сайты на",
                    "<a href=\"https://ru.wikipedia.org/wiki/Поисковая_оптимизация\">SEO</a>",
                    "пригодность");
        });
    }

    @Test
    public void testUrlsPage() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/urls");
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("Сайты");
        });
    }

    @Test
    public void testCreateUrl() {
        JavalinTest.test(app, (server, client) -> {
            var requestBody = "url=[https://example,com]";
            var response = client.post("/urls", requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string().contains("https://example,com"));
        });
    }

    @Test
    public void testCreateUrlOnlyDomainProtocolAndPort() {
        JavalinTest.test(app, (server, client) -> {
            var requestBody = "url=[https://some-domain.org:8080/example/path]";
            var response = client.post("/urls", requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string().contains("https://some-domain.org:8080"));
        });
    }
}
