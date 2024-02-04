@import hexlet.code.dto.urls.UrlPage
@param UrlPage page

@template.layout.page(
page = page,
content = @`
    <div class="container-lg mt-3">
        <div class="row justify-content-center">
            <h3 class="display-5">Сайт: ${page.getName()}</h3>
                <table class="table table-bordered table-hover mt-3">
                    <thread>
                        <tbody>
                            <tr>
                                <td>ID</td>
                                <td>${page.getId()}</td>
                            </tr>
                            <tr>
                                <td>Имя</td>
                                <td>${page.getName()}</td>
                            </tr>
                            <tr>
                                <td>Дата добавления</td>
                                <td>${page.getFormattedCreatedAt()}</td>
                            </tr>
                        </tbody>
                    </thread>
                </table>

            <h4 class="display-5 mt-5">Проверки:</h4>

<%--            <form method="post" action="${}"> --%><%--будет добавлена переадресация на проверку--%>
                <div class="justify-content-md-end mt-3">
                    <button type="submit" class="btn btn-primary">Запустить проверку</button>
                </div>
<%--            </form>--%>

            <table class="table table-bordered table-hover mt-4">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Код ответа</th>
                        <th scope="col">title</th>
                        <th scope="col">h1</th>
                        <th scope="col">description</th>
                        <th scope="col">Дата проверки</th>
                    </tr>
                </thead>
            </table>
        </div>
    </div>
`
)