package hexlet.code.util;

import hexlet.code.model.UrlCheck;
import hexlet.code.repository.UrlCheckRepository;
import hexlet.code.repository.UrlRepository;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class NormalizedData {
    public static String getNormalizedUrl(URL url) {
        var protocol = url.getProtocol();
        var colonsAndSlashes = "://";
        var host = url.getHost();
        var port = url.getPort();
        return port != -1 ? protocol + colonsAndSlashes + host + ":" + port : protocol + colonsAndSlashes + host;
    }

    public static Map<Long, UrlCheck> getListOfLastChecks() throws SQLException {
        var urls = UrlRepository.getEntities();
        Map<Long, UrlCheck> result = new HashMap<>();

        for (var url: urls) {
            var id = url.getId();
            UrlCheck lastCheck;
            if (UrlCheckRepository.getLastCheck(id).isPresent()) {
                lastCheck = UrlCheckRepository.getLastCheck(id).get();
            } else {
                lastCheck = null;
            }
            result.put(id, lastCheck);
        }

        return result;
    }
}
