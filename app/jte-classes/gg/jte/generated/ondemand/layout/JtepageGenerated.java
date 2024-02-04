package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import hexlet.code.util.NamedRoutes;
import hexlet.code.dto.BasePage;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,27,27,27,27,27,27,27,27,27,27,31,31,31,31,31,31,31,31,31,34,34,34,34,34,34,34,34,34,42,42,43,43,43,43,44,44,45,45,45,46,46,46,46,46,46,46,46,46,53,53,55,55,59,59,59,76,76,76,4,5,6,6,6,6};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, BasePage page, Content header) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n    <head>\n        <meta charset=\"utf-8\" />\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"\n                integrity=\"sha384-xGlQDL6z6i1UpvxcCc09uR2blmJSNUEPA8eCzA9H/Y21oUmiQ7J16juR/GYB2xqt\"\n                crossorigin=\"anonymous\"></script>\n        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\"\n              rel=\"stylesheet\"\n              integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\"\n              crossorigin=\"anonymous\">\n        <title>project_72</title>\n    </head>\n\n    <body>\n        <div class=\"bg-body-tertiary text-white vh-100\" data-bs-theme=\"dark\">\n            <nav class=\"navbar navbar-expand-lg bg-dark text-white\" data-bs-theme=\"dark\">\n                <div class=\"container-fluid\">\n                    <a class=\"navbar-brand\"");
		var __jte_html_attribute_0 = NamedRoutes.rootPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Анализатор страниц</a>\n                    <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n                        <ul class=\"navbar-nav\">\n                            <li class=\"nav-item\">\n                                <a class=\"nav-link\" aria-current=\"page\"");
		var __jte_html_attribute_1 = NamedRoutes.rootPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Главная</a>\n                            </li>\n                            <li class=\"nav-item\">\n                                <a class=\"nav-link\" aria-current=\"page\"");
		var __jte_html_attribute_2 = NamedRoutes.urlsPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_2);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Сайты</a>\n                            </li>\n                        </ul>\n                    </div>\n                </div>\n            </nav>\n\n            <div class=\"container mt-3\" data-bs-theme=\"dark\">\n                ");
		if (page != null) {
			jteOutput.writeContent("\n                <div class=\"alert alert-");
			jteOutput.setContext("div", "class");
			jteOutput.writeUserContent(page.getFlashType());
			jteOutput.setContext("div", null);
			jteOutput.writeContent(" alert-dismissible fade show\" role=\"alert\" id=\"flashMessage\">\n                    ");
			if (page.getFlash() != null) {
				jteOutput.writeContent("\n                        ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getFlash());
				jteOutput.writeContent("\n                        <a");
				var __jte_html_attribute_3 = NamedRoutes.urlsPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_3);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n                            <button type=\"button\" class=\"btn-close\"\n                                    data-bs-target=\"#flashMessage\"\n                                    data-bs-dismiss=\"alert\"\n                                    aria-label=\"Close\">\n                            </button>\n                        </a>\n                    ");
			}
			jteOutput.writeContent("\n                </div>\n                ");
		}
		jteOutput.writeContent("\n            </div>\n\n        <main>\n            ");
		jteOutput.setContext("main", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n        </main>\n\n            <div>\n                <nav class=\"navbar fixed-bottom bg-dark text-white\" data-bs-theme=\"dark\">\n                    <div class=\"container-fluid d-flex justify-content-center\">\n                        <p class=\"fw-lighter text-body-emphasis\">\n                            featured by\n                            <a href=\"https://github.com/paulvino\">Pavel Vinogradov</a>\n                            with\n                            <a href=\"https://ru.hexlet.io\">Hexlet</a>\n                        </p>\n                    </div>\n                </nav>\n            </div>\n        </div>\n    </body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		BasePage page = (BasePage)params.getOrDefault("page", null);
		Content header = (Content)params.getOrDefault("header", null);
		render(jteOutput, jteHtmlInterceptor, content, page, header);
	}
}
