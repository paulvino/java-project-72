package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.urls.UrlPage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "urls/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,9,9,9,15,15,15,19,19,19,23,23,23,31,35,51,51,51,51,51,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"container-lg mt-3\">\n        <div class=\"row justify-content-center\">\n            <h3 class=\"display-5\">Сайт: ");
				jteOutput.setContext("h3", null);
				jteOutput.writeUserContent(page.getName());
				jteOutput.writeContent("</h3>\n                <table class=\"table table-bordered table-hover mt-3\">\n                    <thread>\n                        <tbody>\n                            <tr>\n                                <td>ID</td>\n                                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getId());
				jteOutput.writeContent("</td>\n                            </tr>\n                            <tr>\n                                <td>Имя</td>\n                                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getName());
				jteOutput.writeContent("</td>\n                            </tr>\n                            <tr>\n                                <td>Дата добавления</td>\n                                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getFormattedCreatedAt());
				jteOutput.writeContent("</td>\n                            </tr>\n                        </tbody>\n                    </thread>\n                </table>\n\n            <h4 class=\"display-5 mt-5\">Проверки:</h4>\n\n");
				jteOutput.writeContent("\n                <div class=\"justify-content-md-end mt-3\">\n                    <button type=\"submit\" class=\"btn btn-primary\">Запустить проверку</button>\n                </div>\n");
				jteOutput.writeContent("\n\n            <table class=\"table table-bordered table-hover mt-4\">\n                <thead>\n                    <tr>\n                        <th scope=\"col\">ID</th>\n                        <th scope=\"col\">Код ответа</th>\n                        <th scope=\"col\">title</th>\n                        <th scope=\"col\">h1</th>\n                        <th scope=\"col\">description</th>\n                        <th scope=\"col\">Дата проверки</th>\n                    </tr>\n                </thead>\n            </table>\n        </div>\n    </div>\n");
			}
		}, page, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
