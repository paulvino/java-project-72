package gg.jte.generated.ondemand.urls;
import hexlet.code.util.NamedRoutes;
import hexlet.code.dto.urls.UrlsPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,11,11,13,13,24,24,26,26,26,28,28,28,28,28,28,28,28,28,28,28,28,33,33,36,36,39,39,39,39,39,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"container-lg mt-3\">\n        <div class=\"row justify-content-center\">\n            <h3 class=\"display-5\">Сайты</h3>\n            ");
				if (page.getUrls().isEmpty()) {
					jteOutput.writeContent("\n                <p class=\"lead mt-3\">Пока не было добавлено ни одного URL</p>\n            ");
				} else {
					jteOutput.writeContent("\n                <table class=\"table table-bordered table-hover mt-3\">\n                    <thead>\n                        <tr>\n                            <th scope=\"col\">ID</th>\n                            <th scope=\"col\">Имя</th>\n                            <th scope=\"col\">Последняя проверка</th>\n                            <th scope=\"col\">Код ответа</th>\n                        </tr>\n                    </thead>\n                    <tbody>\n                    ");
					for (var url : page.getUrls()) {
						jteOutput.writeContent("\n                        <tr>\n                            <th scope=\"row\">");
						jteOutput.setContext("th", null);
						jteOutput.writeUserContent(url.getId());
						jteOutput.writeContent("</th>\n                            <td>\n                                <a");
						var __jte_html_attribute_0 = NamedRoutes.urlPath(url.getId().toString());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_0);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(url.getName());
						jteOutput.writeContent("</a>\n                            </td>\n                            <td></td>\n                            <td></td>\n                        </tr>\n                    ");
					}
					jteOutput.writeContent("\n                    </tbody>\n                </table>\n            ");
				}
				jteOutput.writeContent("\n        </div>\n    </div>\n");
			}
		}, page, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlsPage page = (UrlsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
