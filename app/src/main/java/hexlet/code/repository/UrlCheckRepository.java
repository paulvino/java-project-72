package hexlet.code.repository;

import hexlet.code.model.UrlCheck;
import hexlet.code.util.Time;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UrlCheckRepository extends BaseRepository {
    public static void save(UrlCheck urlCheck) throws SQLException {
        var sql = "INSERT INTO url_checks (url_id, status_code, h1, title, description, created_at)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (var conn = dataSource.getConnection();
                var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, urlCheck.getUrlId());
            preparedStatement.setInt(2, urlCheck.getStatusCode());
            preparedStatement.setString(3, urlCheck.getH1());
            preparedStatement.setString(4, urlCheck.getTitle());
            preparedStatement.setString(5, urlCheck.getDescription());
            preparedStatement.setTimestamp(6, Time.getTime());
            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                urlCheck.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static List<UrlCheck> getEntitiesByUrlId(Long urlId) throws SQLException {
        var sql = "SELECT * FROM url_checks WHERE url_id = ? ORDER BY id DESC";
        try (var conn = dataSource.getConnection();
                var preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setLong(1, urlId);
            var resultSet = preparedStatement.executeQuery();
            var result = new ArrayList<UrlCheck>();

            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var statusCode = resultSet.getInt("status_code");
                var h1 = resultSet.getString("h1");
                var title = resultSet.getString("title");
                var description = resultSet.getString("description");
                var createdAt = resultSet.getTimestamp("created_at");
                var urlCheck = new UrlCheck(statusCode, title, h1, description, id);
                urlCheck.setCreatedAt(createdAt);
                urlCheck.setId(id);
                result.add(urlCheck);
            }
            return result;
        }
    }

    public static Map<Long, UrlCheck> getListOfLastChecks() throws SQLException {
        var sql = "SELECT DISTINCT ON (url_id) * from url_checks ORDER BY url_id, id DESC";
        try (var conn = dataSource.getConnection();
            var preparedStatement = conn.prepareStatement(sql)) {
            var resultSet = preparedStatement.executeQuery();
            var latestChecks = new HashMap<Long, UrlCheck>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var statusCode = resultSet.getInt("status_code");
                var h1 = resultSet.getString("h1");
                var title = resultSet.getString("title");
                var description = resultSet.getString("description");
                var createdAt = resultSet.getTimestamp("created_at");
                var urlCheck = new UrlCheck(statusCode, title, h1, description, id);

                urlCheck.setId(id);
                urlCheck.setCreatedAt(createdAt);
                latestChecks.put(id, urlCheck);
            }

            return latestChecks;
        }
    }
}
