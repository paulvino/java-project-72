package hexlet.code.controller;

import hexlet.code.dto.UrlPage;
import hexlet.code.model.Url;
import io.javalin.http.Context;

//import java.sql.Timestamp;
import java.util.Collections;

public class RootController {
    public static void index(Context ctx) {
        var url = new Url("name");
        var header = "Тестовый header для проверки";
        var page = new UrlPage(url, header);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }
}
