package hexlet.code.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

import static hexlet.code.util.Time.getSimpleTime;

@Getter
@Setter
@ToString
public class UrlCheck {
    private Long id;
    private Timestamp createdAt;
    private Integer statusCode;
    private String title;
    private String h1;
    private String description;
    private Long urlId;

    public UrlCheck(int statusCode, String title, String h1, String description, Timestamp createdAt, Long urlId) {
        this.statusCode = statusCode;
        this.title = title;
        this.h1 = h1;
        this.description = description;
        this.createdAt = createdAt;
        this.urlId = urlId;
    }

    public String getFormattedCreatedAt() {
        if (createdAt == null) {
            return "";
        }
        return createdAt == null ? "" : getSimpleTime(createdAt);
    }
}
