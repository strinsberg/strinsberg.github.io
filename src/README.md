# Layout

Page content will be structured here as it would be in the final project. So,
all files and folders in the `src` dir are the top level index page and any
other pages that can be in the top level domain. Any nested domains and pages
will have their own folder, which may include their own css and js directories.

There will be a snippets folder in `src` for html snippets that are not
templates or written in markdown. For example, we might want a shared header
or footer for a set of pages. These can go in the snippets dir as simple html
files and will be inserted into the template html pages where desired. There
may also be nested snippet dirs, but only if absolutely necessary.

# Build

The build process will find all html template files and expand them to contain
any additions they need. Markdown files will be converted so their html can
be inserted into the templates. Snippets will be inserted verbatim. Each
expanded file will be placed into pages replacing previous copies.
