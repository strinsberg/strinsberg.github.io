# Steven's Webpage

**TODO** Change this to reflect the new tech and build process. Maybe add some examples of how the changes make life easier.

**NOTE** Dev work for this project is happening on a development branch. The templating setup I used here is nice if content is mostly just markdown, but when I want to do things even a little bit more advanced it fights me. I am rewriting it with Clojure using Hiccup for HTML generation and Clojure functions for templating and transformations.

This is my personal webpage repository. At the moment it will serve mostly
as a portfolio, but I have some ideas for at least adding some of my projects
as extra pages.

In the future I may add some kind of blog/write-up for some of the things that
interest me for future reference or as tutorials for other interested people.
I may also try at some point to put together some notebook style pages designed
to teach programming or allow simple contest like practice problems in a single
page, using one of my interpreters built in Rust and compiled to WASM to execute
code. We will see.


# Project Layout

Page content will be structured here as it would be in the final project. So,
all files and folders in the `src` dir are the top level index page and any
other pages that can be in the top level domain. Any nested domains and pages
will have their own folder, which may include their own CSS and JS directories.

There will be a snippets folder in `src` for HTML snippets that are not
templates or written in Markdown. For example, we might want a shared header
or footer for a set of pages. These can go in the snippets dir as simple HTML
files and will be inserted into the template HTML pages where desired. There
may also be nested snippet dirs, but only if absolutely necessary.

# Project Build

The build process will find all HTML template files and expand them to contain
any additions they need. Markdown files will be converted to insert their HTML
into the templates. Snippets will be inserted verbatim. Each
expanded file will be placed into docs replacing previous copies.
