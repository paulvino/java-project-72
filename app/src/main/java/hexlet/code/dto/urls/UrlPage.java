package hexlet.code.dto.urls;

import hexlet.code.dto.BasePage;

import hexlet.code.model.UrlCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

import static hexlet.code.util.Time.getSimpleTime;

@AllArgsConstructor
@Getter
public class UrlPage extends BasePage {
    private Long id;
    private String name;
    private Timestamp createdAt;
    private List<UrlCheck> urlChecks;

    public String getFormattedCreatedAt() {
        if (createdAt == null) {
            return "";
        }
        return createdAt == null ? "" : getSimpleTime(createdAt);
    }
}
