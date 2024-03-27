# Steven's Webpage

This is my personal webpage repository. At the moment it will serve mostly as a portfolio, but I have some ideas for adding blog content, tutorials, and online demos for new projects when possible.

Check it out [strinsberg.github.io](http://strinsberg.github.io/index.html).


# Design

The project uses Clojure and Hiccup to produce a static website while allowing for custom templates and more complex page building logic. For example, my headings are all linked to a table of contents. To create these I have a function that adds the required HTML for the element's ID. I also have a function that can walk over the page body, provided it is laid out properly, and generate a table of contents for all headings up to a specific depth and link to them using the previously generated IDs. This is not super fancy, but it is not possible if I were to only use Markdown.

I have some simple Babashka tasks to build, serve, and deploy the page. It is not perfect, but it gets the job done in a nice simple way. It also prevents me from needing to use a heavy framework like React for such a simple page. I also don't have to install node/npm just to publish some text online.
