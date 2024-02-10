package hexlet.code;

import java.io.IOException;
import java.sql.SQLException;

import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import hexlet.code.util.NamedRoutes;
import hexlet.code.util.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    private static Javalin app;
    private static final String URL_SIMPLE = "https://example.com";
    private static final String URL_WITH_PORT = "https://example.com:8080";
    private static final String URL_LONG = "https://example.com:8080/example/unnesessary/long/url/address";
    private static final String URL_INCORRECT = "123QWE";
    private static final String URL_FOR_PASTING = "url=[%s]";


    @BeforeEach
    public final void setUp() throws IOException, SQLException {
        app = App.getApp();
    }

    @Test
    public void testRootPage() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get(NamedRoutes.rootPath());
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
            var response = client.get(NamedRoutes.urlsPath());
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("Сайты");
        });
    }

    @Test
    public void testCreateUrl() throws SQLException {
        var url = new Url(URL_SIMPLE, Time.getTime());
        UrlRepository.save(url);
        JavalinTest.test(app, (server, client) -> {
            var requestBody = String.format(URL_FOR_PASTING, URL_SIMPLE);
            var response = client.post(NamedRoutes.urlsPath(), requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string().contains(URL_SIMPLE));
            assertThat(UrlRepository.getEntities()).hasSize(1);
        });
    }

    @Test
    public void testCreateUrlOnlyDomainProtocolAndPort() throws SQLException {
        var url = new Url(URL_WITH_PORT, Time.getTime());
        UrlRepository.save(url);
        JavalinTest.test(app, (server, client) -> {
            var requestBody = String.format(URL_FOR_PASTING, URL_LONG);
            var response = client.post(NamedRoutes.urlsPath(), requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string().contains(URL_WITH_PORT));
            assertThat(UrlRepository.getEntities()).hasSize(1);
        });
    }

    @Test
    public void testCreateIncorrectUrl() {
        JavalinTest.test(app, (server, client) -> {
            var requestBody = String.format(URL_FOR_PASTING, URL_INCORRECT);
            var response = client.post(NamedRoutes.urlsPath(), requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains(
                    "Анализатор страниц",
                    "Бесплатно проверяйте сайты на",
                    "<a href=\"https://ru.wikipedia.org/wiki/Поисковая_оптимизация\">SEO</a>",
                    "пригодность");
            assertThat(UrlRepository.getEntities()).hasSize(0);
        });
    }

    @Test
    public void testUrlPage() throws SQLException {
        var time = Time.getTime();
        var url = new Url(URL_SIMPLE, time);
        UrlRepository.save(url);
        JavalinTest.test(app, (server, client) -> {
            var urlId = url.getId().toString();
            var response = client.get(NamedRoutes.urlPath(urlId));
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains(
                    "Сайт:", url.getName(), "ID", url.getId().toString(), "Имя", url.getName(), "Дата добавления",
                    Time.getSimpleTime(url.getCreatedAt()), "Проверки:"
            );
            assertThat(UrlRepository.getEntities()).hasSize(1);
        });
    }
}
