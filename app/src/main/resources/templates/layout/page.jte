@import gg.jte.Content
@import hexlet.code.util.NamedRoutes
@import hexlet.code.dto.BasePage

@param Content content
@param BasePage page = null
@param Content header = null

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-xGlQDL6z6i1UpvxcCc09uR2blmJSNUEPA8eCzA9H/Y21oUmiQ7J16juR/GYB2xqt"
                crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
        <title>project_72</title>
    </head>

    <body>
        <div class="bg-body-tertiary text-white vh-100" data-bs-theme="dark">
            <nav class="navbar navbar-expand-lg bg-dark text-white" data-bs-theme="dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="${NamedRoutes.rootPath()}">Анализатор страниц</a>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="${NamedRoutes.rootPath()}">Главная</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="${NamedRoutes.urlsPath()}">Сайты</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <div class="container mt-3" data-bs-theme="dark">
                @if (page != null)
                <div class="alert alert-${page.getFlashType()} alert-dismissible fade show" role="alert" id="flashMessage">
                    @if (page.getFlash() != null)
                        ${page.getFlash()}
                        <a href="${NamedRoutes.urlsPath()}">
                            <button type="button" class="btn-close"
                                    data-bs-target="#flashMessage"
                                    data-bs-dismiss="alert"
                                    aria-label="Close">
                            </button>
                        </a>
                    @endif
                </div>
                @endif
            </div>

        <main>
            ${content}
        </main>

            <div>
                <nav class="navbar fixed-bottom bg-dark text-white" data-bs-theme="dark">
                    <div class="container-fluid d-flex justify-content-center">
                        <p class="fw-lighter text-body-emphasis">
                            featured by
                            <a href="https://github.com/paulvino">Pavel Vinogradov</a>
                            with
                            <a href="https://ru.hexlet.io">Hexlet</a>
                        </p>
                    </div>
                </nav>
            </div>
        </div>
    </body>
</html>