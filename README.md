NewsPaper Scraper Service

API calls:
1. http://localhost:8083/author/allauthors
   This api gets the list of all authors on thehindu page.
   
2. http://Host:8083/author/get?name=nameOfAuthor
   Example: http://localhost:8083//author/get?name=Aseem%20Chhabra
   This api gets html data of the given author, which can be scrapped futher to get articles.
   
   
 
To run the Project
===================
1. go to the directory to clone the project
2. check out the master branch
3. cd spring-boot-rest-2
4. Execute - mvnw clean package
5. start the server - java -jar target\spring-boot-rest-2-0.0.1-SNAPSHOT.jar
6. Fire the api's in browser.


Project Architecture:
1. pom.xml contains spring boot dependencies and an addition Jsoup dependency.
   JSoup is used for html parsing/scrapping.
   
2. Beans
   Author.java - This stores name of author and link to his/her articles
   Articles.java - This should store title and url of article, url can further be clicked to get full article.
   
3. Utility class:
   ParseAuthors.java - collectAuthorData() method collects name and link of author by parsing the html of link https://www.thehindu.com/profile/.
   getData()- It gets html data for given author. Parsing of html is yet to be done.
   
4. Controller:
   This is communicating end which contains rest end points. Both api calls are given in the start os document.
   
   
