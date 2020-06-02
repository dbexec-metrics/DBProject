# Made By:-
    
    Rutvik Modi 
    Swarnaditya Maitra


# DBProject
Spark Execution Plan Generator and Metrics Monitoring UI

ENSURE that the main directory will consist of
1) .vs
2) backend
3) DB-Project-UI-master: This is the complete UI (HTML, CSS - bootstrap, grid and flexbox, JavaCcript and jQuery)
4) demo: This is the Spark Java project, also consists of the API made using Spring Boot
5) node_modules
6) public
7) src
8) package.json
9) package-lock.json

React.js form:
----------------
1) The main directory structure pertains to the React.js form, the source code for which is present in src folder. package.json will have all the used tech and their versions listed.

2) node_modules is the npm package for node.js that installs all the dependencies. On your local cloned repo, run:
    a) npm install
    b) npm audit fix
    Check that node is configured, using node -v and npm -v
    c) It contains the react-scripts folder which has all the scripts for running react.js
    d) Give .bin (inside node_modules) and react-scripts all permissions using git update-index --chmod=+x path/to/file (optional - needed for building on openshift)
    
    
3) src contains all the source files. The main react code is in App.js

4) open git bash inside the main repo, when all is configured and type: npm start   .....this will host the react form on http://localhost:3000

demo: (do not run from run tab)
-----------------
1) demo is the main backend part, dealing with all the data processing for user's SQL statements that were entered on the React Form.
2) Open up intelliJ, and open the project demo
3) We have already made the configuration changes, and imported all the maven, spark, and spring dependencies. 
4) Ensure that the path of all the files, specified inside the program, is where the files are actually present. This is important. Ensure that the path of the files f1, f2, f3, f4 and output.txt(in DB-Project-UI-master) is the same as that specified in the code. Ensure that files are pasted at these locations, if not already, or change the path to the appropriate locations of the files.
5) Click on Run tab -> Edit Configuration -> logs -> save console output to file. Enter the path of the output file here (ENSURE that the path is the same as DB-Project-UI-master)
6) To start up the project, on the bar below the title bar, at the right-hand side, beside "demo-application", there would be a green play button. Click it. The spring application should run. Check the console output
7) Now, this application runs infinitely, and goes active whenever the user submits in the React Form. 



DB-Project-UI-master
----------------------
1) There are two parts:
    a) Metrics-Monitoring-UI: Contains the Metrics UI that displays all the cluster info (for the cluster as a whole), as well has info for the individual apps currently running on Hadoop (general metrics). In addition, it displays all running spark applications, and the details of each individual application

    b) Spark Execution Monitor: Displays unresolved logical plan, resolved logical plan, optimized logical plan and physical implementation plan, corresponding to the SQL query entered by the user. The plans are stored in f1-f4.txt and console output of project is redirected to output.txt (truncation)
    
2) Inside Metrics-Monitoring-UI:
    a) The frontUI contains all the html files. Open main_cluster.html and navigate from there.
    b) assets contains all the css, js and image files
    
3) Inside Spark Execution Monitor:
    a) Open execution-plan.html. If the java sub-project (demo) is correctly configured, the execution plans corresponding to user's SQL query (entered in react.js form), will show up in the Execution plans section on the page.
    b) Note that the UI displays info from the f1.txt...f4.txt and output.txt files present here. Hence, in the Java project, verify that the paths are set.
    b) assets1 has all the css, js and image files
   
    

    

