(ns portfolio
  (:require [snippets :as snip]))

(defn page
  []
  (snip/page
   "portfolio"
   "Steven's Portfolio"

   ;; Intro ;;
   ["Below is a collection of my work and personal projects. It is still a work in progress. I will add more descriptions, screenshots, and demos where possible. In addition to finishing a bachelor's and master's degree in computer science, I have put thousands of hours into personal projects and learning."

    "You can find a little bit of everything here, including interpreters, compilers, software engineering research, and a video game or two. While my research and work experience have more practical value, I worked on most of my personal projects to learn something new and have fun. The value of these projects lies in what the process taught me about the different technologies, the many approaches to problem-solving, and what it takes to design and build software."]


   ;; Body ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/h 1 "Work Experience")
   [:p
    "My experience in formal software development is somewhat limited. I worked as an electrician for many years before returning to school and changing careers. Since then, I've had three opportunities to work in a more formal environment. Most recently, I pursued my master's degree and researched using abstract syntax trees for recording programming knowledge and experience. Before that, I held two summer positions working for researchers. In one, I added new features to an educational web-based card game. In the other, I automated the collection of programming language samples for research and stored them in a simple database. Throughout these experiences, I had the pleasure of working with several great people and learning many new things."]

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/h 2 "Master's Thesis")
   (snip/skills-key :Clojure :Python
                    :R :Machine-learning
                    :Statistics :Software-engineering)
   [:p
    "I completed my M.Sc. Computer Science at the University of Lethbridge co-supervised by Dr. Jackie Rice and Dr. John Anvik. For this work, I investigated using abstract syntax trees to measure a developer's experience with a piece of code. I created five new metrics that capture how much experience a developer has with the source code they are modifying. I used statistical and machine learning methods to evaluate these metrics in the context of defect detection. The final results showed that the new metrics were a statistically significant predictor of defects at commit time."]
   [:p
    "Below is the abstract for my work. I am also working on adding links to the thesis, slides from my thesis defense, and the project's GitHub repository with code for data collection and my final datasets."]

   [:div {:class "abstract"}
    [:h3 "Measuring Developer Experience with Abstract Syntax Trees"]
    [:h4 "Abstract"]
    [:blockquote {:style "text-align: justify;"}
     "Accurately representing a developer's programming knowledge and experience is difficult. Traditional metrics rely on counting the number of times a developer has used or made changes to pieces of code. When a developer has modified a file in the past they are less likely to introduce defects with a change. However, these metrics do not contain any general information on the structure or purpose of a piece of code and are only useful when developers work on a piece of code more than once. We investigated the use of several new metrics based on abstract syntax trees (ASTs) as a possible way to more completely measure a developer's experience. By using the ASTs of code previously modified by a developer we may be able to identify their experience with a piece of code they are modifying even if they have never modified that specific code before. Through statistical analysis and machine learning predictions we show that AST-based metrics capture a more general programming experience than count-based metrics. In their current form, AST-based metrics do not offer any significant improvements over existing metrics for defect prediction. However, our work offers a starting point for future use of ASTs for representation of knowledge and experience in defect prediction and other relevant areas."]]

   (snip/nav [["Thesis" "https://hdl.handle.net/10133/6638"]
              "Github Coming Soon" "Slides Coming Soon"])

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/h 2 "Program Wars")

   (snip/skills-key :HTML :CSS
                    :JavaScript :Vue.js
                    :Jest :Continuous-Integration)

   (snip/img-set ["/assets/screenshots/ss-program-wars-menu.webp"
                  "Program Wars gameplay"]
                 ["/assets/screenshots/ss-program-wars-gameplay.webp"
                  "Program Wars gameplay"])

   [:p
    "Program Wars is a web-based educational card game designed to teach fundamental programming and cybersecurity concepts. I worked with researchers to add new features to the game based on ongoing research projects. I completely redesigned the UI to more clearly present game information to users. The new code was designed with object-oriented design principles to allow more flexibility for future feature and game mode additions. I also worked to modularize the Vue components to improve code reuse with new features and game screens."]
   [:p
    "This project involved a lot of collaboration as my role was purely as a software developer. I worked hard to effectively communicate with researchers and provide a final product that met their needs as accuratley as possible."]

   (snip/nav-br
    [["GitHub" "https://github.com/strinsberg/Program-Wars"]
     ["Play Version 2.0" "https://program-wars.firebaseapp.com/"]
     ["Version 1.0 Paper"
      "https://opus.uleth.ca/server/api/core/bitstreams/d705aaaa-49f2-44da-8d0e-0cffebac0289/content"]])


   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/h 2 "Research Data Collection")

   (snip/skills
    "Python, Data Collection, MySql, APIs, Selenium, Technical Documentation")

   [:p
    "My first job as a programmer was to automate the collection of a large database of programming samples for researchers. This primarily involved writing Python scripts to interact with Google Big Query and the GitHub API to collect samples that met researchers needs. The scripts stored samples in a MySql database along with additional author information. In addition to the Python scripting, I was responsible for documenting the whole process with a technical report and user documentation. It was important that future researchers could easily add new programming samples, improve on the processes, or use my work as a starting point for similar data collection processes."]

   (snip/nav-br [["Github" "https://github.com/strinsberg/slrg_data"]])


   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   [:br]
   [:hr]
   (snip/h 1 "Personal Projects")

   [:p
    "I have done a lot of programming over the last 5+ years. As soon as I discovered programming, I knew best way to grow and learn was to practice as much as possible. I have included some of my favourites below. A few are school projects, and the rest I built just for fun or to learn something I was interested in. I have organized the projects into general categories to make it easier for interested parties to see relevant projects."]

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/subsec)
   (snip/h 2 "Interpreters, Compilers, and Virtual Machines")
   [:p
    "My favourite computer science topic is programming languages and their implementations. I also enjoy working the lower level constructs of compilers and virtual machines. As a result, I have worked on quite a few different projects that fall into this category. Most of my work with interpreters and compilers is on front end tech, but I am starting to experiement more more with code generation and optimizations."]

   (snip/h 3 "Rusp")
   (snip/skills
    "Rust, Clojure, Compiler Passes, Code Generation, Functional Programming")


   (snip/h 3 "Lt-64 VM")
   (snip/skills "C, Clojure, Python, Byte-Code, Stack-Based VM, Assembly")


   (snip/h 3 "Pascal Subset Compiler")
   (snip/skills
    "C++, Flex, Bison, OOP, Type Checking, Error Recovery, Code Generation")


   (snip/h 3 "Scheme Interpreters")
   (snip/skills "Rust, Scheme, Functional Programming")


   (snip/h 3 "Vrrm")
   (snip/skills "Rust, Stack-Based VM")


   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/subsec)
   (snip/h 2 "Cli Tools")
   [:p
    "Most of my projects are built in and for use on the linux terminal, but these don't fall into any of the other categories. I enjoy building tools that have a nice specific purpose and get a job done. I have not done as much of it as I would like, given that so many really great linux cli tools already exist. However, I have created a couple tools that were of practical use and some others that allowed me to learn a bit about a specific domain."]


   (snip/h 3 "Easy Mark")
   (snip/skills "Rust, Text Generation")

   (snip/h 3 "Clint")
   (snip/skills "Python, Testing")


   (snip/h 3 "Hockey Stats Viewer")
   (snip/skills "Awk, Data Transformation, Config Files")


   (snip/h 3 "Simple Text")
   (snip/skills "Python, NCurses, TUI")


   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/subsec)
   (snip/h 2 "Games and Game Engines")

   [:p
    "Some of my first programs were simple video games, though they are mostly lost due to a lack of knowledge of git at the time. I do not find myself as drawn to game design as I do to game engines or the tools that people might use to make games. However, these are complex topics with huge scope that are difficult to work on alone. Below is an example of an attempt to build a game engine for text-based games and one of my first completed games."]

   (snip/h 3 "Disaster on the Good Ship Lethbridge")
   (snip/skills "Python, C++, Unit Testing, OOP, UI, Tkinter, JSON")


   (snip/h 3 "Space Match 3000")
   (snip/skills "Lua, Love2d, UI")


   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/subsec)
   (snip/h 2 "Web Development")
   [:p "There is are only a couple examples in this category, though "
    [:a {:href "#program-wars"} "Program Wars"]
    " would be in here if it was not in the work experience section. Many of the lower level projects I have worked on are just not really suited to the web, or are built with tech that is not easy to deploy as a static website. With the advances in WASM though it opens up a lot of opportunities to integrate projects with websites, if only to demo them. The fact that I can write an interpreter in Rust and integrate it into a website easily is pretty cool."]

   (snip/h 3 "This Website")
   (snip/skills "Clojure, HTML, CSS, ClojureScript")


   (snip/h 3 "Rest API")
   (snip/skills
    "C++, Restbed, APIs, Back-End Development, Continuous Integration, JSON")


   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/subsec)
   (snip/h 2 "Scool")
   [:p
    "I got to work on some cool projects in school. Below are the ones that did not make it into other categories or did not get used as the basis for other projects."]

   (snip/h 3 "Competetive Programming")
   (snip/skills "C++, Problem Solving, Team Work")


   (snip/h 3 "Command Line Card Games")
   (snip/skills
    "C++, OOP, Gtest, Code Coverage, Static Analysis, Continuous Integration")


   ;
  ))
