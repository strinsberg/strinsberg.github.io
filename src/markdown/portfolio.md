# Portfolio <!--** snippets/darkmode.html **-->

<div class=abstract>
<!--** snippets/navigation.md **-->
<br>

<summary>
Below is a collection of my work and personal projects. It is still a work in progress. I will add more descriptions, screenshots, and demos where possible. In addition to finishing a bachelor's and master's degree in computer science, I have put thousands of hours into personal projects and learning.

<br>

You can find a little bit of everything here, including interpreters, compilers, software engineering research, and a video game or two. While my research and work experience have more practical value, I worked on most of my personal projects to learn something new and have fun. The value of these projects lies in what the process taught me about the different technologies, the many approaches to problem-solving, and what it takes to design and build software.
</summary>
</div>

<hr>

# Contents

* [Work Experience](#work)
   - [Master's Thesis](#thesis)
   - [Program Wars](#pwars)
   - [Research Data Collection](#slrg)
* [Personal Projects](#projects)
   - [Interpreters, Compilers, and Virtual Machines](#langs)
   - [Command Line Tools](#cli)
   - [Games and Game Engines](#games)
   - [Others](#others)

<br>
<hr>

<h1 id="work">Work Experience</h1>

My experience in formal software development is somewhat limited. I worked as an electrician for many years before returning to school and changing careers. Since then, I've had three opportunities to work in a more formal environment. Most recently, I pursued my master's degree and researched using abstract syntax trees for recording programming knowledge and experience. Before that, I held two summer positions working for researchers. In one, I added new features to an educational web-based card game. In the other, I automated the collection of programming language samples for research and stored them in a simple database. Throughout these experiences, I had the pleasure of working with several great people and learning many new things.


<h2 id="thesis">Master's Thesis</h2>
I completed my M.Sc. Computer Science at the University of Lethbridge co-supervised by Dr. Jackie Rice and Dr. John Anvik. For this work, I investigated using abstract syntax trees to measure a developer's experience with a piece of code. I created five new metrics that capture how much experience a developer has with the source code they are modifying. I used statistical and machine learning methods to evaluate these metrics in the context of defect detection. The final results showed that the new metrics were a statistically significant predictor of defects at commit time.

Below is the abstract for my work. I am also working on adding links to the thesis, slides from my thesis defense, and the project's GitHub repository with code for data collection and my final datasets.

<div class=abstract>
<h3>Measuring Developer Experience with Abstract Syntax Trees</h3>
<h4>Abstract</h4>
</div>
<blockquote style="text-align: justify;">
Accurately representing a developer's programming knowledge and experience is difficult. Traditional metrics rely on counting the number of times a developer has used or made changes to pieces of code. When a developer has modified a file in the past they are less likely to introduce defects with a change. However, these metrics do not contain any general information on the structure or purpose of a piece of code and are only useful when developers work on a piece of code more than once. We investigated the use of several new metrics based on abstract syntax trees (ASTs) as a possible way to more completely measure a developer's experience. By using the ASTs of code previously modified by a developer we may be able to identify their experience with a piece of code they are modifying even if they have never modified that specific code before. Through statistical analysis and machine learning predictions we show that AST-based metrics capture a more general programming experience than count-based metrics. In their current form, AST-based metrics do not offer any significant improvements over existing metrics for defect prediction. However, our work offers a starting point for future use of ASTs for representation of knowledge and experience in defect prediction and other relevant areas.
</blockquote>

<nav class="nav-list">
<a href="https://hdl.handle.net/10133/6638" target="_blank">Thesis</a> |
*Slides Coming Soon* |
*GitHub Link Coming Soon* <!-- [Github](https://github.com/strinsberg/masters) -->
</nav>


<h2 id="pwars">Program Wars</h2>

Program wars is a web-based educational card game designed to teach fundamental programming and cybersecurity concepts, you can read the version 1.0 paper for more details. I was hired for the summer to collaborate with researchers looking to further expand the game and polish the code. We ended up working on a couple of different versions over the summer.

During the course of the summer there were actually two versions of the game and the code. When I started libraries had to be updated since it had been a while since anyone had worked on version 1.0. During this process I took a fair amount of time to clean up the code. Smaller parts of the code were reasonably clean, but over time having had several different summer student programmers add features had created a lot of jumbled and redundant things. I remade some of the Vue.js components and tried to better organize the code and the flow of information through the program. We also experimented with adding a number of new cards and concepts to the game during this period.

However, as the game progressed and the research changed several new features were added that took the game in a slightly different direction. It was also decided that with a potential version 3.0 that features like deck building and other game modes might be introduced. A single game mode can easily be designed to run on a single screen and have all the features coded to that screen. However, when you start adding different scoring systems, card designs, turn flow, and UI elements it is easier to have them as decoupled as possible and have multiple views for different modes. Even with the refactoring it was clear that extending version 1.5 to add these features would be difficult (at least with my current skill level and the possible skill level of future summer students). We decided to do a full rewrite using a more OOP design approach. This made it easy to share different features between game modes while being able to customize modes to have their own logic. Vue.js and Vuex are generally design for a more functional design than OOP, so there were some small things to smooth out, but it worked out quite well in the end and kept the code design similar to what summer students would be experienced with.

Another significant change I made was to the UI. In version 1.0 each player's turn took place on its own screen. This made it difficult to see what the other player's status was and to make decisions. I reorganized the UI to have both players on the screen at a time (and with 4 players in version 1.5). We added information elements for the player to get quick rules updates and a list of icons to show the last 10 plays that were made by each player.

<br>
<nav class="nav-list">
<a href="https://github.com/strinsberg/Program-Wars" target="_blank">GitHub</a> |
<a href="https://program-wars.firebaseapp.com" target="_blank">Play Version 2.0</a> |
<a href="https://opus.uleth.ca/server/api/core/bitstreams/d705aaaa-49f2-44da-8d0e-0cffebac0289/content" target="_blank">Version 1.0 Paper</a>
</nav>

<h2 id="slrg">Research Data Collection</h2>

This was my first job using my programming skills. It primarily involved building a database of programming samples for researchers. I spent most of my time writing and running Python scripts that used the GitHub API to download source code that had a single author. I also wrote some scripts that collected contest programming solutions from Codeforces.com. Once samples were collected they were stored in a MySql database along with relevant author information. The research involved using these samples and author information to train machine learning algorithms to identify sociolinguistic characteristics of the program's author such as their region, gender, or experience level.

In additions to creating the simple database of source code and author information I needed to make the scripts I wrote as easy as I could for future students to use to collect additional data. As it was my first go at this type of programming, I am not sure that I fully succeeded. However, I set the scripts up as best I could and used a config file to allow users to make some changes without having to modify the scripts. I also thoroughly documented both how to use the scripts and the technical details of how the data was collected.

It was a great learning experience and being involved with the research team is one of the things that motivated me to pursue a Master's degree. It also taught me that there are many more things to think about when writing programs for other people to use. And most importantly, if I write scripts that will run for days at a time they need to be as robust as possible and make it easy to restart them where they left off when they crash!

<br>
<nav class="nav-list">
<a href="https://github.com/strinsberg/slrg_data" target="_blank">GitHub</a>
</nav>

<br>
<hr>
<h1 id="projects">Personal Projects</h1>

Since discovering computer programming I have built a lot of things for fun and learning. I have listed many of them below. Some are more finished than others and a few are school projects or extensions of school projects. A few of them are even somewhat useful 😁.

<h2 id="langs">Interpreters, Compilers, and VMs</h2>

If there is one computer science topic I love the most it is programming languages and their implementations. The simple fact that I can give the computer instructions is pretty amazing, but combine that with all the abstractions and paradigms that can be added on top of those simple instructions. As a result I have spent a fair amount of time implementing and adjusting programming languages.

I really enjoy Lisp-like languages and this is where many of my personal attempts at interpreters and compilers have been focused. Lisp-like languages are also slightly more straightforward to parse, which can make them easier to get started with. With that simplicity comes a lot of power though and a lot of room for fun or practical extensions.

In the end though all of my projects are only for fun and personal learning. I am sure it is possible to make an efficient, full-featured, and robust programming language on my own, but it is not really practical. There are so many amazing languages out there that many people have spent many years refining. So, each of my projects have only been taken so far.

### Rusp

Rusp is an interpreter for a lisp-like language that I am working on. It will be somewhat like a mashup between Clojure and Scheme, but with some of my own syntax and built-in functions. While it is not terribly practical to try to design a new language, it is unlikely that it is a language that will ever see any real world use. Many smart people have worked for many years to make high quality, robust languages. So, I get to learn from those and experiment and learn even more from my successes and failures.

I have not been able to work on it for a while, and it is not super far along with functionality, but Rusp is my current side project. Most of the time so far has been setting up the data structures and basic compiler loop. I need a new implementation of macros to allow adding some basic lisp forms in a simpler way than hard coding them in Rust. Before I get too ahead of myself I want to solidify some of the design details and create a test spec independent of Rust to drive future development (See [Clint](#clint)).

One of my other major goals is to compile Rusp directly to Rust. This would not be a full interop style compilation like Clojure has, but it would enable a Rusp project to be compiled to a native binary. Compiled programs would still need to include a Rusp library for the lisp data structures, but it would not bundle the full interpreter into the runtime. Either way it is not something I will get to in the near future. Just a fun project for the future.

<a href="https://github.com/strinsberg/rusp" target="_blank">GitHub</a>

### Scheme 

As a precursor to Rusp I made a Scheme interpreter in Rust following the r5rs standard. I did not implement the whole standard. Most notably some number and math stuff is missing along with macros and continuations. I did refactor the interpreter to accommodate continuations, which was not trivial (at least for me), and never got around to adding them. I did get many of the built-in functions added, but it is not a full implementation.

In the end this project became a place where I learned how I could set up the lisp data structures in Rust. I moved on to work on Rusp which uses some of the data structures and algorithms, but is no longer Scheme.

I also learned how to use WASM to compile the interpreter and embed it in a web page. So, I will be adding a demo of the interpreter to my site. Then people can just try it out to see how well it works rather than having to take my word for it or read my code. Of course, it is just really cool that it is possible to make a project like this available on the web. How easy it is to do with Rust is one thing that will keep me coming back to Rust for future projects.

<a href="https://github.com/strinsberg/my-scheme" target="_blank">GitHub</a>

*Web Demo Coming Soon* <!--[Try It](/)-->

<a href="https://github.com/strinsberg/scheme-interpreter" target="_blank">Original School Project GitHub</a>

<h3 id="lt-64">Lt-64 VM</h3>

A fun little virtual machine that I made that has a fixed size memory. I also wrote an assembler for it and then wrote a simple lisp interpreter in the assembly language. Of course, I eventually ran into a bug I could not find the cause of and moved on. I would do many things differently, but it was a fun project. I also set it up to compile programs and append them to a copy of the interpreter in C which made it possible to solve programming contest problems with my own vm and language. Nothing like submitting 1000 lines of C code and a string of bytes to an online judge to solve a trivial problem 😂.

The code is a bit of a mess because over time I moved the single file vm into the assembler project and made edits to it that did not get transferred back to the main project. So, it is not really useable. However, I did learn many things about stack-based virtual machines and could use that knowledge to build a better one in the future.

<a href="https://github.com/strinsberg/lt64" target="_blank">GitHub</a>

<a href="https://github.com/strinsberg/lt64-asm" target="_blank">Assembler GitHub</a>

<a href="https://github.com/strinsberg/ltsp" target="_blank">Ltsp GitHub</a>

### Pascal Subset Compiler

This is a project that came out of a compilers course I took during my Bachelor's degree. We had to write a compiler for a subset of Pascal over the years. At the end of the semester before I started my summer job I spent a few weeks trying to expand the compiler and the vm that was provided. I rewrote the lexer and parser using Flex and Bison. The goal was to set up the compiler to generate an abstract syntax tree that I could them pass to a code generator. I wanted to be able to give myself the option of compiling to different targets in the future. It was mostly a success, but once work started I never got back to it. I also, made a couple mistakes trying to extend the vm for passing procedure arguments and the code got out of hand (though it was an ambitious project, so probably this should have been expected). I never got back to it and moved on to other projects, but again it was a wonderful learning experience.

<a href="https://github.com/strinsberg/plcc" target="_blank">GitHub</a>

<a href="https://github.com/strinsberg/pl_compiler" target="_blank">Original School Project GitHub</a>

<h2 id="cli">Command Line Tools</h2>

I have also made a few command line programs and tools over the years to help me accomplish a task or just to learn something and practice programming. I don't often have a need that cannot be met by an existing project, but it is fun to be able to build something useful.

### Easy Mark

I really enjoyed using Crowd Mark for marking in a few of my classes as a teaching assistant. However, very few of the classes I marked for used it. During the pandemic all assignments went virtual and this meant providing feedback by annotating PDFs. I decided at some point to write a tool that could make things a little easier for me. It mimicked Crowd marks ability to save comments and their deductions so that I could re-use them when many students had the same issue. Then I could just add the assignment questions and marks and for each student enter feedback for each question and let the program keep track of their marks. Once I was finished the tool spit out a latex document with the students marks and feedback that I compiled and uploaded. It saved me a lot of time and felt good to use my skills to actually help me get my work done. It was not perfect and by no means a replacement for Crowd Mark, but it did the trick.

<a href="https://github.com/strinsberg/easy-mark" target="_blank">GitHub</a>

<h3 id="clint">Clint (cli integration testing)</h3>

This is another program that I will continue actively working on. I originally built it to allow easily testing the [lt-64](#lt-64) vm. Because lt-64 was written in C it was not as easy to set up unit testing, and maybe not practical given the way the vm was constructed. So, I instead tested it by running the interpreter on bytes using a Python script. This allowed me to write a bunch of tests for different op-codes and features ahead of time and run them against the interpreter as I built it. It was also nice to use as when tests failed it would not stop running. So, I could write a lot of tests beforehand and implement whichever one I wanted and just see which ones would pass.

I assume that this is possible with more modern built-in testing frameworks, but this worked well when those were not available. I liked it so much that for command line programs I intend to keep using it and fine-tuning it for my needs. Having a testing tool that is language agnostic and runs tests without worrying about the implementation details is useful. It makes doing TDD much easier in my opinion. With built-in unit tests you have to know how you want to build your classes or functions already. For personal projects things are much more like prototypes and implementation and architecture change all the time. It is often not practical to do TDD in the situations and can just waste time if you scrap large portions of the code and implement them from scratch.

For projects like Rusp this kind of testing also allows me to write a language design spec in markup or code ahead of any implementation. If the language changes I can change the spec and not worry about the implementation details. It would also be possible to completely change the implementation language or environment and the spec would need little to no changes. And like most of my other projects, I get to contemplate an important software engineering topic and learn new things.

<a href="https://github.com/strinsberg/clint" target="_blank">GitHub</a>

### Hockey Stats Viewer

This should just be an SQL database lol. However, having it on my first resume may have gotten me my first programming job, so it was worth it. It is written in AWK, which was useful and not a bad idea, but also not the best technology for this type of project. However, at the time it gave me a tool that had some use when I was in a fantasy hockey league to filter players with the best stat spread for our league setup. I may have even won the year I used it during my draft, but I don't remember. It was a good learning experience, and the first program I wrote that accepted a config file, so it was worth it (beyond getting me a job). Plus, a professor once overheard me describing it to some friends and asked incredulously "You write programs in AWK?", which gave us all a good laugh.

<a href="https://github.com/strinsberg/hockey-stats" target="_blank">GitHub</a>

### Simple Text

I wrote an ncurses command line editor, and it worked! Like many of these projects it was just for fun and learning. I did everything as simply as I could, and I am sure if you opened a large file it would crash or freeze. So, no need to ditch Nano, Vim, Emacs, or VsCode anytime soon.

<a href="https://github.com/strinsberg/simple-text" target="_blank">GitHub</a>

<h2 id="games">Games And Game Engines</h2>

Like everyone that has learned to program I have made a few video games. I find I am generally more interested in creating the games architecture and algorithms than I am in writing a compelling and fun video game. As a result I have not really spent that much time making video games. Below are two projects that I put the most time and effort into.

### DGSL

This is another project that was born out of a class project. We were supposed to build a text adventure game and use OOP design principles. I took this a little too far and basically built a text adventure game engine rather than just a game. In the summer I rewrote it in Python as C++ made some things in my design a little cumbersome (or my design made C++ cumbersome?). The goal was to create a program that would allow people to somewhat easily create their own text adventure games without needing to code. I built a world editor with Python and Tkinter that did allow creating games, but I am not sure the result was all that user-friendly. It was fun though, and it truly could be used to make at least one type of text adventure game with a few updates to the engine for things like saving games.

This was my first attempt at using a GUI framework. It was also required making language agnostic data to pass between the world editor and the program. If you made a sufficiently complex game it would have spit out a nice big JSON file.

I also got some more experience with unit testing. The engine was nearly fully unit tested, though I may have gotten too excited about "mocking" things out. I am really not sure that the tests were as useful as they could have been. However, you have to do something to learn that you could do it better.

<a href="https://github.com/strinsberg/dgsl-text-adventure-engine" target="_blank">Engine GitHub</a>

<a href="https://github.com/strinsberg/dgsl-world-editor" target="_blank">World Builder GitHub</a>

<a href="https://github.com/strinsberg/good-ship-lethbridge" target="_blank">Original School Project GitHub</a>

### Space Match 3000

This is one of my earliest programming attempts. It is a very simple game that I wrote because I wanted to try writing some algorithms to deal with a match 3 board. I even ended up using the state pattern to make switching between game modes easier. The most important thing about it was that it was technically finished and worked if I compiled it for Linux and for my friends on Windows (thanks to the [Love2d](https://love2d.org/) framework). And now it is mostly playable online as well thanks to someone's WASM compiler. Though the UI design is not user-friendly, using keybinds to select menu elements and the mouse to play the actual game. And you can't save games online. But I finished it, and it worked, and it did what it was expected to do, and seemingly with few to no bugs. I even learned that spelling mistakes are far more costly in a language like Lua where every variable is set to nil even if it has never been declared before. Nothing like 4 hours of debugging to find you got two letters in a variable name swapped 😢.

<a href="https://github.com/strinsberg/space-match-3000" target="_blank">GitHub</a>

<a href="https://strinsberg.github.io/space-match-3000/" target="_blank">Play The Game</a>

<h2 id="others">Others</h2>

Finally, some other projects that I have worked on over the years. These include some of my competitive programming solutions and some other school projects.

### Competitive Programming

I was on a competitive programming team for two years while doing my Bachelor's degree at the University of Lethbridge. Honestly, it was not my strong suit. I am more of a slow contemplative problem solver and to be really successful at one needs to be fast. It was really fun and I thoroughly enjoyed spending time with the other students and the coach Howard Cheng. I even met several of my best friends there. I continued to be involved during my Master's (as much as was possible during the Pandemic), but could no longer compete. And even if it was not my style of activity I did learn a lot from it and get invaluable practice solving problems. It does really compliment the academic environment and personal projects.

The linked repo contains some of my solutions. Most of my solutions were done on school computers and not saved to my GitHub. However, I will continue adding them as I do them for interview prep and for fun when I want a break from building larger personal projects. I do have most of one year's Advent of Code solutions and some solutions from a course taught at ULeth focusing on contest programming style problem-solving.

<a href="https://github.com/strinsberg/competitive-programming" target="_blank">GitHub</a>

### Issue Tracker REST API

A school project where we built a REST API in C++ and a simple web client to access it. The project was also done to try and simulate Agile development. We did it in teams of 3 and had to present proposals and do three bi-weekly standup meetings where we presented our progress to our class. The goal was to identify all of our goals for each two-week sprint and talk about what we achieved and didn't and discuss our plan for the next sprint. The API is quite simple, but it takes requests from the website and stores or returns issue information. It was a fun project and a good opportunity to learn some things about the software development lifecycle. It was also fun to work on a project that was not that is very applicable to the world of software development. Though there are definitely easier technologies to build rest services with than C++ 😉.

<a href="https://github.com/strinsberg/tracker-express" target="_blank">GitHub</a>

### Command Line Card Games

A couple of school projects where we had to implement some card games for the command line. These focused on using OOP design, doing unit testing and mocking, and using continuous integration tools to automate testing, code coverage, and style checkers. One of the projects we were given code written by other students for one card game and had to try to use OOP to extend it to add another card game with as much code reuse as was practical. Like many of the school projects these were good learning experience, but were very simple and difficult to really sink your teeth into the principles involved.

<a href="https://github.com/strinsberg/card-game-extravaganza" target="_blank">Rummy Extension GitHub</a>

<a href="https://github.com/strinsberg/old-maid" target="_blank">Old Maid GitHub</a>
