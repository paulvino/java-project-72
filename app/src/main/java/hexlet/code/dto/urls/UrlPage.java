package hexlet.code.dto.urls;

import hexlet.code.dto.BasePage;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

import static hexlet.code.util.Time.getSimpleTime;

@AllArgsConstructor
@Getter
public class UrlPage extends BasePage {
    private Long id;
    private String name;
    private Timestamp createdAt;

    public String getFormattedCreatedAt() {
        if (createdAt == null) {
            return "";
        }
        return createdAt == null ? "" : getSimpleTime(createdAt);
    }
}
