package hexlet.code.controller;

import hexlet.code.dto.urls.UrlPage;
import hexlet.code.dto.urls.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlCheckRepository;
import hexlet.code.repository.UrlRepository;
import hexlet.code.util.NamedRoutes;
import hexlet.code.util.NormalizedData;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Collections;

import static hexlet.code.repository.UrlRepository.isUrlExists;
import static hexlet.code.util.Time.getTime;

public class UrlController {

    public static void index(Context ctx) throws SQLException {
        var urls = UrlRepository.getEntities();
        var checks = NormalizedData.getListOfLastChecks();
        var page = new UrlsPage(urls, checks);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashType(ctx.consumeSessionAttribute("flash-type"));
        ctx.render("urls/index.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) throws SQLException {
        var incomingAddress = ctx.formParamAsClass("url", String.class)
                .get()
                .trim()
                .toLowerCase();

        String normalizedUrl;

        try {
            var addressAsUrl = new URI(incomingAddress).toURL();
            normalizedUrl = NormalizedData.getNormalizedUrl(addressAsUrl);
        } catch (MalformedURLException | URISyntaxException | IllegalArgumentException e) {
            ctx.sessionAttribute("flash", "Некорректный URL");
            ctx.sessionAttribute("flash-type", "warning");
            ctx.redirect(NamedRoutes.rootPath());
            return;
        }

        if (isUrlExists(normalizedUrl)) {
            ctx.sessionAttribute("flash", "Данный URL уже существует");
            ctx.sessionAttribute("flash-type", "info");
            ctx.redirect(NamedRoutes.urlsPath());
        } else {
            var url = new Url(normalizedUrl, getTime());
            UrlRepository.save(url);
            ctx.sessionAttribute("flash", "URL успешно добавлен");
            ctx.sessionAttribute("flash-type", "success");
            ctx.redirect(NamedRoutes.urlsPath());
        }
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var url = UrlRepository.find(Long.valueOf(id))
                .orElseThrow(() -> new NotFoundResponse("Url with id = " + id + " not found"));
        var urlChecks = UrlCheckRepository.getEntitiesById(id);
        var page = new UrlPage(id, url.getName(), url.getCreatedAt(), urlChecks);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashType(ctx.consumeSessionAttribute("flash-type"));
        ctx.render("urls/show.jte", Collections.singletonMap("page", page));
    }
}
