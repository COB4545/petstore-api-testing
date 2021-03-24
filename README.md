# Pet Store Open API  testing with Serenity BDD framework

[![Java CI with Maven](https://github.com/COB4545/petstore-api-testing/actions/workflows/maven.yml/badge.svg)](https://github.com/COB4545/petstore-api-testing/actions/workflows/maven.yml)

What you need to run this app:

* `java` and `maven`

```bash
# clone the repo
$ git clone https://github.com/COB4545/petstore-api-testing.git

# change directory 
$ cd petstore-api-testing

# Run Test Scenarios
$ mvn clean verify

# Test Reports Path 'target/site/serenity/index.html'
$ The report contains 4 tabs ( "Overall Test Results" , "Requirements", "Capabilities" , "Features" )
    Overall Test Results : 
      1) Dispalys execution result in Pie chart
      2) Contains Execution Time and displays Fastest, slowest & Avg time of test
      3) Functional coverage view
    Note: after clicking on Feature it Navigates to Feature tab.
    
    Requirements : Displays all the Features are in project with higherirchy
    
    Capabilities : It displays All the capabilities like Fetaure folders
    
    Features: 
      1) displays All the features in project
      2) By clicking on each feature can browse all the Scenarios and corresponding steps
      3) Can verify input and outout of each steps by clicking on (+) symbol
       
 ```