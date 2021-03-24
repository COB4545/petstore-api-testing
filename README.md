# Pet Store Open API  testing with Serenity BDD framework

[![Java CI with Maven](https://github.com/COB4545/petstore-api-testing/actions/workflows/maven.yml/badge.svg)](https://github.com/COB4545/petstore-api-testing/actions/workflows/maven.yml)

What you need to run this Project:

* `java` and `maven`

```bash
# clone the repo
$ git clone https://github.com/COB4545/petstore-api-testing.git

# change directory 
$ cd petstore-api-testing

# Run Test Scenarios
$ mvn clean verify

 ```

# This Project is PetStore REST API automation :

  * Base url placed in this project is : https://petstore.swagger.io/v2/

  * In this mainly STORE&PET resources used to cover all the CRUD methods
     
  * CRUD METHODS : POST,GET,UPDATE,DELETE

  * Store REST resource : It Contains POST,GET,DELETE Methods
  * Pet REST resource: It Contains POST,PUT Methods
  * POST : Basically it does the Creation a record in SOurce
  * GET : Basically it does Retrieve from source
  * UPDATE: Basically it does Update or modify on any existing items in Source
  * DELETE : Basically it Deletes a record or particular item in Source

# Test Reports Path 'target/site/serenity/index.html'

 * The report contains 4 tabs ( "Overall Test Results" , "Requirements", "Capabilities" , "Features" )
    * Overall Test Results :
        1) Displays execution result in Pie chart
        2) Contains Execution Time and displays Fastest, slowest & Avg time of test
        3) Functional coverage view
    Note: after clicking on Feature it Navigates to Feature tab.

    * Requirements : Displays all the Features are in project with hierarchy
    
    * Capabilities : It displays All the capabilities like feature folders
    
    * Features: 
        1) displays All the features in project
        2) By clicking on each feature can browse all the Scenarios and corresponding steps
        3) Can verify input and output of each step by clicking on (+) symbol
