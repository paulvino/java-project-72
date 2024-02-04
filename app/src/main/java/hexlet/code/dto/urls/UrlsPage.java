package hexlet.code.dto.urls;

import java.util.List;

import hexlet.code.dto.BasePage;
import hexlet.code.model.Url;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UrlsPage extends BasePage {
    private List<Url> urls;
}
