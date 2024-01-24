package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import hexlet.code.util.NamedRoutes;
import hexlet.code.repository.BaseRepository;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,22,22,22,22,22,22,22,22,22,22,36,36,36,37,37,37,53,53,53,4,5,6,6,6,6};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, BaseRepository page, Content header) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n    <head>\n        <meta charset=\"utf-8\" />\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\"\n              rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\"\n              crossorigin=\"anonymous\">\n        <title>project_72</title>\n    </head>\n    <body>\n        <div>\n            <nav class=\"navbar navbar-expand-lg bg-body-tertiary\" data-bs-theme=\"dark\">\n                <div class=\"container-fluid\">\n                    <a class=\"navbar-brand\"");
		var __jte_html_attribute_0 = NamedRoutes.rootPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Анализатор страниц</a>\n                    <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n                        <ul class=\"navbar-nav\">\n                            <li class=\"nav-item\">\n                                <a class=\"nav-link\" aria-current=\"page\" href=\"#\">Главная</a>\n                            </li>\n                            <li class=\"nav-item\">\n                                <a class=\"nav-link\" aria-current=\"page\" href=\"#\">Сайты</a>\n                            </li>\n                        </ul>\n                    </div>\n                </div>\n            </nav>\n            <div>\n                ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(header);
		jteOutput.writeContent("\n                ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n            </div>\n            <div>\n                <nav class=\"navbar fixed-bottom bg-body-tertiary\" data-bs-theme=\"dark\">\n                    <div class=\"container-fluid d-flex justify-content-center\">\n                        <p class=\"fw-lighter text-body-emphasis\">\n                            featured by\n                            <a href=\"https://github.com/paulvino\">Pavel Vinogradov</a>\n                            with\n                            <a href=\"https://ru.hexlet.io\">Hexlet</a>\n                        </p>\n                    </div>\n                </nav>\n            </div>\n        </div>\n    </body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		BaseRepository page = (BaseRepository)params.getOrDefault("page", null);
		Content header = (Content)params.getOrDefault("header", null);
		render(jteOutput, jteHtmlInterceptor, content, page, header);
	}
}
