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

   (snip/img-set ["/assets/screenshots/ss-program-wars-menu.webp"
                  "Program Wars gameplay"]
                 ["/assets/screenshots/ss-program-wars-gameplay.webp"
                  "Program Wars gameplay"])


   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/h 2 "Research Data Collection")


   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   [:hr]
   (snip/h 1 "Current Projects")

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/h 2 "Rusp")

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/h 2 "Clint")

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/h 2 "This Website")


   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   [:hr]
   (snip/h 1 "Older Projects")

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/h 2 "Interpreters, VMs, and Compilers")
   (snip/h 3 "Scheme Interpreters")
   (snip/h 3 "Lt-64 VM")
   (snip/h 3 "Pascal Subset Compiler")

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/h 2 "Cli Tools")
   (snip/h 3 "Easy Mark")
   (snip/h 3 "Simple Text")
   (snip/h 3 "Hockey Stats Viewer")

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/h 2 "Games and Game Engines")
   (snip/h 3 "Disaster on the Good Ship Lethbridge")
   (snip/h 3 "Space Match 3000")

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (snip/h 2 "Scool")
   (snip/h 3 "Competetive Programming")
   (snip/h 3 "Rest API")
   (snip/h 3 "Command Line Card Games")
   ;
  ))
