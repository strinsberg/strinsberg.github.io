(ns portfolio
  (:require [snippets :as snip]))

(defn page
  []
  (snip/page
   "portfolio"
   "Steven's Portfolio"

   ;; Intro ;;
   ["Below is a collection of my work and personal projects. In addition to finishing a bachelor's and master's degree in computer science, I have put thousands of hours into personal projects and learning over the years. You can find a little bit of everything here, including interpreters, compilers, software engineering research, and a video game or two. While my research and work experience have more practical value, I worked on most of my personal projects to learn something new and have fun. The value of these projects lies in what the process taught me about the different technologies, the many approaches to problem-solving, and what it takes to design and build software."

    "I have tried to keep the descriptions short. Some projects have much more detail on GitHub and others are included as examples of work, but lack comprehensive documentation given they were primarily for experiementation. There are links to each project on GitHub and to other resources where applicable. Some projects include screenshots. You can click on them to view larger versions in another tab."]


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
              "GitHub Coming Soon" "Slides Coming Soon"])

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/h 2 "Program Wars")

   (snip/skills-key :HTML :CSS
                    :JavaScript :Vue.js
                    :Jest :Continuous-Integration)

   (snip/img-set ["/assets/screenshots/ss-program-wars-menu.webp"
                  "Program Wars game menu"]
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

   (snip/nav-br [["GitHub" "https://github.com/strinsberg/slrg_data"]])


   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   [:br]
   [:hr]
   (snip/h 1 "Personal Projects")

   [:p
    "As soon as I discovered programming, I knew best way to grow and learn was to practice as much as possible. I have done a lot of programming over the last 5+ years. A number of my projects are included in this section. A few are school projects, and the rest I built just for fun or to learn something I was interested in. I have organized the projects into general categories to make it easier for interested parties to see relevant projects."]

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/subsec)
   (snip/h 2 "Interpreters, Compilers, and Virtual Machines")
   [:p
    "My favourite computer science topic is programming languages and their implementations. I also enjoy working the lower level constructs of compilers and virtual machines. As a result, I have worked on quite a few different projects that fall into this category. Most of my work with interpreters and compilers is on front end tech, but I am starting to experiement more more with code generation and optimizations."]

   (snip/h 3 "Rusp")
   (snip/skills
    "Rust, Clojure, Compiler Passes, Code Generation, Functional Programming")

   [:p
    "Rusp is an attempt to compile a Lisp-like language to Rust. The project is in the early stages. Currently my main goal for the project is to experiement and get some experience with compiler passes and code generation. I have only just started experiementing with this, but it will involve manipulating the AST in order to produce sub langauges that are closer and closer to Rust. Once the process is able to produce a structure close to common intermediate representations I will experiement applying some simple optimization passes and then generate Rust code. The final code will require a library of Rust data structures that I have already written."]
   [:p
    "It would be cool if I can produce some reasonably efficient and safe Rust code. I am not expecting to produce a production ready language, but there is a lot to learn and the lessons can be applied to future projects or jobs. If I can get to the place where I can compile the compiler I will be excited."]

   (snip/nav-br [["GitHub" "https://github.com/strinsberg/rusp"]])


   (snip/h 3 "Lt-64 VM")
   (snip/skills "C, Clojure, Python, Byte-Code, Stack-Based VM, Assembly")

   [:p
    "Lt64 is a collection of projects built around a stack-based byte code virtual machine I wrote. The goal of the VM was to learn more about stack-based VMs and experiement with a simpler version of an assembly language. The vm had a fixed memory for the program, stack, string buffer, and free memory which was a bit akward in the end. I learned a lot about stack-based computers and got some nice experience with a lower level code."]
   [:p
    "In addition to the VM I built an assembler with a pretty simple assembly language that roughly translated to the instruction set of the VM. I did add some extras such as the ability to include other files, super simple macros, and separation for procedures. The syntax used clojure lists and keywords which made parsing and manipulating it. It resolved all the memory addresses for labels and then produced a file of bytes that could be read by the VM."]
   [:p
    "Finally, I wrote a simple Lisp interpreter in the assembly code. This was a good exercise in understanding why high level langauges exist. In the end I abandoned the project when I wrote a merge sort routine that would fail if the list had 300+ items in it. I could not discover the bug, though it may have been that I never got around to implementing garbage collection in the interpreter. The VM had a super basic debugger built in, but it was not enough to track down the problem."]

   (snip/nav-br [["Lt64 GitHub" "https://github.com/strinsberg/lt64"]
                 ["Lt64-Asm GitHub" "https://github.com/strinsberg/lt64-asm"]
                 ["Ltsp GitHub" "https://github.com/strinsberg/ltsp"]])


   (snip/h 3 "Pascal Subset Compiler")
   (snip/skills
    "C++, Flex, Bison, OOP, Type Checking, Error Recovery, Code Generation")

   [:p
    "Plcc is a compiler for a subset of Pascal. It started as a group project in a compiler design class with another student. After the semester was over I started from scratch to learn a little about compiler tools like Flex and Bison as well as experiment with parsing to an AST data structure and using that for code generation. I did learn a lot from the process but I had a lot of ideas and the project got a little out of hand and messy. The two projects were a great way to learn more about compilers and modifying the instructor provided stack-based VM to allow new features is part of what inspired me to work on Lt64."]

   (snip/nav-br
    [["Plcc GitHub" "https://github.com/strinsberg/plcc"]
     ["School Project GitHub" "https://github.com/strinsberg/pl_compiler"]
     ["Brinch Hansen Compiler Textbook"
      "http://pascal.hansotten.com/2020/10/23/per-brinch-hansen-on-pascal-compilers/"]])


   (snip/h 3 "Scheme Interpreters")
   (snip/skills "Rust, Scheme, Functional Programming")

   [:p
    "It may be obvious from some of the entries above, but I really enjoy Lisp like languages. My first introduction was to Scheme in a programming languages class where the course project was to build a simple compiler for a subset of Scheme using Racket. It was a group project slated for the second half of the semester, but I got started on it immediately and ended up writing two different versions by myself. I was even the only student whose project passed all of the instructors tests and got 100%. Of course this is to be expected when you spend 5x more time on the project than anyone else. I now mostly use Clojure as my main lisp-like language, but Scheme is still a nice language."]
   [:p
    "More recently, before moving on to Rusp, I built a Scheme interpreter in Rust as well. This project attempted to implement most of the R5RS standard. I did not quite get there, some math and numbers stuff is missing, there are no macros (a real problem for a lisp), and I setup the evaluation to work for continuations but never implemented them. A big reason I did not finish this was because I wanted to compile it and took the experience and moved on to Rusp. I did learn a lot about Rusp data structures and how I could represent Scheme structures in Rust. I used smart pointers instead of custom allocation and garbage collection, which has problems for a dynamically types language if you allow mutability. It is not always possible to identify circular structures in an efficent way to use weak pointer. So memory leaks are not hard to cause. As always I learned a lot and got much more comfortable writing Rust code."]

   (snip/nav-br [["My-Scheme GitHub" "https://github.com/strinsberg/my-scheme"]
                 "Online Demo Coming Soon"
                 ["School Project GitHub"
                  "https://github.com/strinsberg/scheme-interpreter"]])


   (snip/h 3 "Vrrm")
   (snip/skills "Rust, Stack-Based VM")

   [:p
    "This was another attempt at a virtual machine after lt64. My main goal was to simplify the memory model and try to add some heap memory with garbage collection. I tried to separate the program data from the stacks and to incorporate a separate data structure for dynamic memory. I got pretty far along and was successful in some ways. The issue with the setup was that once the memory is split up, if pointers are indicies for memory instead of raw pointers you have to encode where each pointer points to. It is not hard to do that when you are directly writing the byte code, but it takes more work to get right when generating code from another language. I also used an interface for the heap and started implementing something niave and it just didn't feel like it was going to work out. Like other projects, it was a good learning experience to force me to think more about the difficulties of writing a generic VM. I may write another VM in the future, but I think I will try to make it less general and more targeted to a specific language to make it easier to decide what features should be available in the VM versus the language."]

   (snip/nav-br [["GitHub" "https://github.com/strinsberg/vrrm"]])


   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/subsec)
   (snip/h 2 "Cli Tools")
   [:p
    "Most of my projects are built in and for use on the linux terminal, but these don't fall into any of the other categories. I enjoy building tools that have a nice specific purpose and get a job done. I have not done as much of it as I would like, given that so many really great linux cli tools already exist. However, I have created a couple tools that were of practical use and some others that allowed me to learn a bit about a specific domain."]


   (snip/h 3 "Easy Mark")
   (snip/skills "Rust, Text Generation")

   [:p
    "Easy Mark is one of my more practical personal projects. It was born out of my marking duties during the pandemic. All of the courses switched to having students submit PDF documents for their assignments. While it is not hard to annotate a PDF with comments when marking assignments it can be time consuming with 100 students and long assignments. A couple of professors used Crowdmark which drastically improves the efficiency of marking. One of the main benefits of using crowdmark is that you can attach a deduction to a comment and save it. Many students make very similar mistakes on a question and this feature allows easily reusing the comment. This is especially helpful if you want to give a nice long comment with some helpful information to help the student understand the question better."]
   [:p
    "I spent a couple of days and created a command line program that allowed me to reuse comments and automatically generate a grade sheet with marks and comments for each student. You coould add an assignment and questions. Then add students and give them marks for each question by either entering a new comment or selecting one from a list of previous comments that were sorted by the frequency of use. Using this program cut my marking time in half and allowed me to more effectively use the hours that I was allocated for each course while still giving the students useful feedback. While I love working on projects where the main goal is to experiment and learn, it is very satisfying to make something that has immediate practical value."]

   (snip/nav-br [["GitHub" "https://github.com/strinsberg/easy-mark"]])


   (snip/h 3 "Clint")
   (snip/skills "Python, Testing")

   [:p
    "Clint is a small python project to allow some testing of command line applications. It needs some love to be more practical, but it served me quite well when I was writing lt64 and was not sure what to use for testing a C program. It is also quite handy to have some integration style testing when you are designing programming languages. Unit tests are great for checking the behaviour of functions and classes, but often rely so much on the implementation that large design changes can require rewriting a lot of code. Tests that are based on the language can cover more syntax and semantics and are easy to change if the language design alters a bit. They also will not break with implementation changes that are common while prototyping."]
   [:p
    "Clint allowed me to test sending byte code to my VM and interacting with interpreters at the command line. I wrote tests in Python functions that would spawn an process for the cli program and send it input and compare its output to what I expected. Very simple but quite effective. I also put a little effort into printing out nice reports of all of the tests indicating whether they passed or not and any discrepancies between the actual and expected output. For a complex program this kind of testing will not be enough, but it gave me more than enough power to ensure my programs were working and the flexibility to allow me to experiement without breaking all my tests."]

   (snip/nav-br [["GitHub" "https://github.com/strinsberg/clint"]])


   (snip/h 3 "Hockey Stats Viewer")
   (snip/skills "Awk, Data Transformation, Config Files")

   [:p
    "Before I new about SQL databases or Pandas I wrote this command line tool to process hockey stats data to give me some insight for fantasy hockey drafts. I also kind of wanted to learn some Awk and it seemed like a good tool for processing csv data and generating reports. I actually felt like the result was pretty good for what it was, and having shown some interest in working with data helped me get my first job doing data collection. The program accepts some filter arguments for different stat categories and prints a list of all the players that met those requirements over previous years. I succesfully used it during fantasy hockey drafts in real time to filter out lists of players more effectively than just sorting by a single category in the draft app. If I had to do something like this again I could leverage databases and statistical tools to give me far more information, but this really did the trick for what I needed."]

   [:p "An example of running the script:"
    [:pre
     [:code
      "$> ./stats \"g=30\" \"a=40\" \"hits=50\"
-- Conditions: A>=40, G>=30, S>=300, 

Player                POS  GP   G    A    PTS  DIF  PPP  S    BLK  Year
-----------------------------------------------------------------------
Zach Parise           C    81   38   44   82   24   26   347  34   2009
Zach Parise           LW   82   45   49   94   30   30   364  17   2008
Vincent Lecavalier    C    81   40   52   92   -17  29   318  21   2007
Phil Kessel           RW   82   37   43   80   -5   20   305  30   2013
Patrick Sharp         LW   82   34   44   78   13   25   313  27   2013
Jarome Iginla         RW   82   50   48   98   27   33   338  10   2007
James Neal            LW   80   40   41   81   6    30   329  15   2011
Ilya Kovalchuk        LW   77   37   46   83   -9   29   310  18   2011
Henrik Zetterberg     C    77   31   42   73   13   30   309  31   2008
Henrik Zetterberg     LW   75   43   49   92   30   36   358  16   2007
----------------  10  -------------------------------------------------
Evgeni Malkin         C    75   50   59   109  18   34   339  41   2011
Eric Staal            C    82   38   44   82   -2   35   310  33   2007
Alex Ovechkin         LW   72   50   59   109  45   36   368  20   2009
Alex Ovechkin         LW   79   56   54   110  8    46   528  32   2008
Alex Ovechkin         LW   79   32   53   85   24   24   367  23   2010
----------------  15  -------------------------------------------------

-- Players with multiple seasons --
Alex Ovechkin          2008, 2009, 2010, 
Zach Parise            2008, 2009, 
Henrik Zetterberg      2007, 2008,"]]]

   (snip/nav [["GitHub" "https://github.com/strinsberg/hockey-stats"]])


   (snip/h 3 "Simple Text")
   (snip/skills "Python, NCurses, TUI")

   [:p
    "Simple text is a simple ncurses-based terminal text editor. Another old project from when I first started programming. I chose to use some niave data structures to keep things simple, but it was possible to open files, edit text, and save them. I managed to softwrap text and give a UI simlar to Nano. I would never use this program to edit text, but it gave me the opportunity to write some Python code, work on a UI in a simpler setting than a full GUI, and learn a bit about text editors."]

   (snip/nav-br [["GitHub" "https://github.com/strinsberg/simple-text"]])


   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/subsec)
   (snip/h 2 "Games and Game Engines")

   [:p
    "Some of my first programs were simple video games, though they are mostly lost due to a lack of knowledge of git at the time. I do not find myself as drawn to game design as I do to game engines or the tools that people might use to make games. However, these are complex topics with huge scope that are difficult to work on alone. Below is an example of an attempt to build a game engine for text-based games and one of my first completed games."]

   (snip/h 3 "Disaster on the Good Ship Lethbridge")
   (snip/skills "Python, C++, Unit Testing, OOP, UI, Tkinter, JSON")

   [:p
    "DGSL started as a school project that I got a little carried away with. In a course where we were learning about object oriented programming and design we were given a group project to write a text-based adventure game. We were told to use OOP as much as possible and experiement with some abstractions and design principles. I worked really hard to abstract and modularize user interactions, game entities, and behaviour. In the end our program looked more like a game engine than a simple text-based game. It was trivial to add new rooms, items, npcs, etc. to our game, though we did not have a good interface for creating all of the objects and just had one giant constructor that was so long our style checker wouldn't allow it. Apparently it is bad style to write 500+ line functions 😂."]
   [:p
    "After the semester I picked up the project again and tried to integrate loading JSON files to build the game world. This solved the problem of the gross long functions and gave me the idea that I could build an interface that would allow someone to build a text based game world without having to write any code. I rewrote most of the game engine in Python and then wrote a Python and Tk GUI to allow creating worlds. I never managed to completely finish it, and there were some flaws in the programs architecture. However, it was possible to create worlds with the GUI and run them with the engine. I re-created the game from the original project with the GUI and included it as a demo. Unfortunately, the demands of work and school and new interests meant I never got back to it. Of course, there are existing applications that work quite well for writing text-based games. I got some good Python experience and learned some GUI programming, so it was all worth it."]

   (snip/nav-br [["DGSL Engine GitHub"
                  "https://github.com/strinsberg/dgsl-text-adventure-engine"]
                 ["DGSL World Builder GitHub"
                  "https://github.com/strinsberg/dgsl-world-editor"]
                 ["School Project GitHub"
                  "https://github.com/strinsberg/good-ship-lethbridge"]])


   (snip/h 3 "Space Match 3000")
   (snip/skills "Lua, Love2d, UI")

   (snip/img-set ["/assets/screenshots/ss-space-match-menu.webp"
                  "Space Match 3000 game menu"]
                 ["/assets/screenshots/ss-space-match-gameplay.webp"
                  "Space Match 3000 gameplay"])

   [:p
    "Space Match 3000 is one of the first programs I wrote. It is a simple match 3 game using the Love2d game engine. It has a ridiculous UI that requires using the keyboard to navigate menus and using the mouse once the game starts. However, it is a finished program that has all the features I wanted to give it, including saving high scores if used on the desktop. I spent a lot of time experiementing with the algorithms that process a players moves and the board. I also spent some time on the architecture using the OOP state pattern to manage the different screens and game states. It was a good learning experience, especially learning how to debug when your programming language will not error when you mispell a variable name 😂."]
   [:p
    "There is a version of the game compiled to WASM available to demo online. The link is below. Try it out and enjoy the akward controls. The high scores do not work online. Also, it won't work properly on mobile devices."]

   (snip/nav-br [["GitHub" "https://github.com/strinsberg/space-match-3000"]
                 ["Online Demo"
                  "https://strinsberg.github.io/space-match-3000/"]])


   (snip/h 3 "OpenGL Graphics Project")
   (snip/skills "C++, OpenGL, 3D, Graphics")

   (snip/img-single ["/assets/screenshots/ss-graphics-project.webp"
                     "A basic 3d hummer driving on some roads."])

   [:p
    "For a graphics class out final project was to make an OpenGL program where you could drive a hummer around on some roads. We had to produce a few different kinds of 'buildings' and make it look kind of like driving around on city blocks. I am not sure if it counts as a video game, I titled it "
    [:em "Hummer Assault"]
    " but there is not action. You are railroaded onto the road surfaces and the project portion where we had to make it possible to shoot down buildings was cut due to the pandemic starting with a month left in the sememster. Still it was fun and I learned a bunch of stuff about graphics. It was supposed to be a group project, but while playing around to see what could be done I ended up doing it by myself in 3 days (my group members didn't mind 😂)."]

   (snip/nav-br [["GitHub"
                  "https://github.com/strinsberg/opengl-course-project"]])



   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/subsec)
   (snip/h 2 "Web Development")
   [:p "There is are only a couple examples in this category, though "
    [:a {:href "#program-wars"} "Program Wars"]
    " would be in here if it was not in the work experience section. Many of the lower level projects I have worked on are just not really suited to the web, or are built with tech that is not easy to deploy as a static website. With the advances in WASM though it opens up a lot of opportunities to integrate projects with websites, if only to demo them. The fact that I can write an interpreter in Rust and integrate it into a website easily is pretty cool."]

   (snip/h 3 "This Website")
   (snip/skills "Clojure, HTML, CSS, ClojureScript")

   [:p
    "A simple static website generated using Clojure. I started this site just writing some HTML to keep it simple and then tried to work with Markdown. In order to work with Markdown I setup a simple compilation process. However, as time went on I realized that there were a lot of little things that I could not do with Markdown, like opening links in another tab or linking to titles, without writing HTML. I also had lots of little things that were repeated and contained several HTML elements. I eventually decided to switch it up and use Clojure. I can write datastructures that are more concise than HTML and can be easily rendered to HTML. I can also write reusable components with Clojure functions as well as some complex logic for tasks like generating a table of contents from the headings on a page. The site is still a simple static site, but each page is a Clojure function that returns a datastructure to render as HTML. The workflow is still simple, but powerful, and does not require a full node/npm installation or the use of a heavy weight framework like React for such a simple site."]
   [:p "I also use a CSS framework "
    [:a {:href "https://latex.vercel.app/" :target= "_blank"} "LatexCSS"]
    " which keeps the page clean and adds darkmode and a fully responsive design. I have had to write a few JS functions to deal with darkmode, which I used ClojureScript and an embeded ClojureScript interpreter for (cause it is fun). These functions use local storage to identify which mode a visitor is in to maintain the theme during page switches and subsequent visits. I also have my images appear in horizontal lists on desktop and vertical lists on smaller devices that I took care of myself, not that it is hard. I think the result is nice and clean and professional looking overall."]

   (snip/nav-br [["GitHub"
                  "http://github.com/strinsberg/strinsberg.github.io"]])


   (snip/h 3 "Issue Tracker Express")
   (snip/skills
    "C++, Restbed, APIs, Back-End Development, Continuous Integration, JSON, Agile")

   (snip/img-set ["/assets/screenshots/ss-tracker-express-all.webp"
                  "Issue Tacker Express all issues page"]
                 ["/assets/screenshots/ss-tracker-express-single.webp"
                  "Issue Tacker Express all issues page"])

   [:p
    "This is a school project where we were tasked with building a REST API for a simple issue tracking system in C++. We also had to build a front-end client in HTML/CSS/JS to interact with the server. It was a fun project and a good introduction to back-end web development.I have not worked on similar projects because they require servers to maintain the project and I do not have the resources to deploy a back-end server for personal projects.  Note that the front-end is not very flashy as the REST server was the primary development goal for the project."]
   [:p
    "The project was a group project and a major aspect of it was working with some Agile concepts. Development was broken into several phases. First we prepared a proposal detailing the service we were planning on building and the functionality it would have. Then we had three 2 week sprints to do the development. We had to plan what we thought we could get done during each sprint and present a working product with a subset of our features at the end of each sprint. We were required to identify the difficulties and successes of the sprint and explain how we would move forward in future sprints in order to complete our goals. We also had to do a standup-like presentation to the class at the end of each sprint to show off our progress and talk about where we were and what we had planned. A school group project cannot really prepare one for working in an Agile environemnt in industry, but it was a nice introduction to the concepts and good practice thinking about a project as more than something to get done for a quick grade. This also means there is a lot of documentation on the project page if you want to know more."]

   (snip/nav-br [["GitHub" "https://github.com/strinsberg/tracker-express"]])


   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/subsec)
   (snip/h 2 "School")
   [:p
    "I got to work on lots of projects in school. Below are the ones that did not make it into other categories or did not get used as the basis for other projects."]

   (snip/h 3 "Competetive Programming")
   (snip/skills "C++, Problem Solving, Team Work")

   [:p
    "One of the best parts of the University of Lethbridge was the contest programming club run by Howard Cheng. I made many good friends and got opportunities to learn and use computer science concepts that are not covered in classes. It was also a great place to practice solving problems individually and as a team. I had the opportunity to go to the ICPC regional contests in 2018 and 2019. My teams placed 36 the first year and 29 the second year. The contests are quite competetive and a good bit of fun. My personality is better suited to larger projects where I can take my time and consider a problem and its solution more deeply. So, doing contests was a great way to put me out of my comfort zone and help me grow as a programmer, a team member, and a problem solver."]
   [:p
    "My repository for contest problems is below. It is not as extensive as it could be. A lot of the solutions done in a team environment are not present and sometimes I worked on school computers or even online IDEs and did not save my code to the repo. There is a folder for a course that Howard teaches on problem solving techniques which contains a number of problem solutions of varying difficulty. I also did most of Advent of Code one year and have solutions for that."]

   (snip/nav-br [["GitHub"
                  "https://github.com/strinsberg/competitive-programming"]])


   (snip/h 3 "Command Line Card Games")
   (snip/skills
    "C++, OOP, MVC, Gtest, Code Coverage, Static Analysis, Continuous Integration")

   [:p
    "Finally, a simple set of cli card games. The main focus of this project was to build a command line card game with some principles of OOP and MVC. The goal was to create code that was modular and would allow portions of the code to be used to create a second card game. We all wrote versions of Go Fish first. Then we were given another students code and asked to extend it to add the game Rummy to the program. We also used Gtest and Gmock to fully test the model and controller portions of the code and had a CI pipline to run tests and static analysis as part of our grade. This project was a great introduction to MVC. It was also a good introduction to thinking about how a program can be designed to make future feature extensions easier. No matter what you do, a growing program will accumulate tech debt, but there are lots of practices that can help to mitigate it. The project was also a nice introduction to the idea that programming is not that hard, but that program architecture requires a lot more careful thought and work to get right."]

   (snip/nav-br [["GitHub"
                  "https://github.com/strinsberg/card-game-extravaganza"]])

   ;
  ))
