package hexlet.code;

import hexlet.code.controller.RootController;
import hexlet.code.repository.BaseRepository;

import hexlet.code.util.NamedRoutes;
import io.javalin.Javalin;
import java.io.BufferedReader;
//import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
import java.sql.SQLException;
import java.util.stream.Collectors;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    private static final String DEFAULT_PORT = "7070";
    private static final String DEFAULT_JDBC_URL = "jdbc:h2:mem:project;DB_CLOSE_DELAY=-1;";
    private  static final String JDBC_DATABASE_URL = "JDBC_DATABASE_URL";
    private static final String JDBC_DATABASE_PASSWORD = "JDBC_DATABASE_PASSWORD";
    private static final String JDBC_DATABASE_USERNAME = "JDBC_DATABASE_USERNAME";
    private static final String SCHEMA_FILE = "schema.sql";

    public static void main(String[] args) throws IOException, SQLException {
        var app = getApp();
        var port = getPort();
        app.start(port);
    }

    private static int getPort() {
        String port = System.getenv().getOrDefault("PORT", DEFAULT_PORT);
        return Integer.valueOf(port);
    }

    public static String getJdbcUrl() {
        String jdbcUrl = System.getenv().getOrDefault(JDBC_DATABASE_URL, DEFAULT_JDBC_URL);
        return jdbcUrl;
    }

    private static String readResourceFile(String fileName) throws IOException {
        var inputStream = App.class.getClassLoader().getResourceAsStream(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }


    public static Javalin getApp() throws IOException, SQLException {
        var hikariConfig = new HikariConfig();
        var dataBaseUrl = getJdbcUrl();
        if (dataBaseUrl == null || dataBaseUrl.equals(DEFAULT_JDBC_URL)) {
            hikariConfig.setJdbcUrl(dataBaseUrl);
        } else {
            hikariConfig.setUsername(System.getenv(JDBC_DATABASE_USERNAME));
            hikariConfig.setPassword(System.getenv(JDBC_DATABASE_PASSWORD));
            hikariConfig.setJdbcUrl(dataBaseUrl);
        }

        var dataSource = new HikariDataSource(hikariConfig);
//        var url = App.class.getClassLoader().getResource(SCHEMA_FILE);
//        var file = new File(url.getFile());
//        var sql = Files.lines(file.toPath())
//                .collect(Collectors.joining("\n"));
        var sql = readResourceFile(SCHEMA_FILE);

        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        }

        BaseRepository.dataSource = dataSource;

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.before(ctx -> {
            ctx.contentType("text/html; charset=utf-8");
        });

        app.get(NamedRoutes.rootPath(), RootController::index);

        return app;
    }
}
