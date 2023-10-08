# Steven's Webpage

This is my personal webpage repository. At the moment it will serve mostly
as a portfolio, but I have some ideas for at least adding some of my projects
as extra pages.

In the future I may add some kind of blog/write-up for some of the things that
interest me for future reference or as tutorials for other interested people.
I may also try at some point to put together some notebook style pages designed
to teach programming or allow simple contest like practice problems in a single
page, using one of my interpreters built in rust and compiled to wasm to execute
code. We will see.

# Ideas

For the moment the most important thing is to get some representation of the
work I have done over the past 5 years.

I want a project section on the main page. It needs to showcase more important
and possibly impressive projects first. These should have a short blurb about
what and why. They should also be accompanied by images/screenshots/gifs to give
a better idea than a person having to read the code of all of them. This should
include a link to github and if applicable a link to a demo page.

While I don't think an interviewer will scroll very far I also want a simple list
of other projects that I have done. I have several things that are perhaps not
as impressive, but fill out my list of work and some are even practical.

# TODOs

- [ ] Add program info
- [ ] add gifs
- [ ] video for masters presentation

# Project Layout

Page content will be structured here as it would be in the final project. So,
all files and folders in the `src` dir are the top level index page and any
other pages that can be in the top level domain. Any nested domains and pages
will have their own folder, which may include their own css and js directories.

There will be a snippets folder in `src` for html snippets that are not
templates or written in markdown. For example, we might want a shared header
or footer for a set of pages. These can go in the snippets dir as simple html
files and will be inserted into the template html pages where desired. There
may also be nested snippet dirs, but only if absolutely necessary.

# Project Build

The build process will find all html template files and expand them to contain
any additions they need. Markdown files will be converted so their html can
be inserted into the templates. Snippets will be inserted verbatim. Each
expanded file will be placed into pages replacing previous copies.
