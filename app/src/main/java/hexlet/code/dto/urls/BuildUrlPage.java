package hexlet.code.dto.urls;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class BuildUrlPage {
    private String name;
    private Timestamp createdAt;
    private Map<String, List<ValidationError<Object>>> errors;
}
