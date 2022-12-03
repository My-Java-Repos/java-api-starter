# Api Guideline Repo (Skeleton)

Quick start project that can be used to create a new java api 


## Requirements

for local DB
Follow the wiki
http://wiki.org.com/display/LINK/how+to+set+up+local+DB

to execute local liquibase
Follow the wiki
http://wiki.org.com/display/LINK/how+to+execute+liquibase+locally

## Usage

If you want to create a new java api within portal:
1. Clone this repo
2. Determine proper name for you application, i.e  "app-service"
3. The same name will be used to register in eureka
4. In bootstrap.yml replace spring.application.name with your app name
5. In build.gradle replace all "skeleton" with your app name
6. Replace all instances of skeleton-api with your project name
7. Replace any instance of "SERVICE-NAME" with the appropriate variable names

## Link-api-config settings
1. Clone link-api-config(this is where the settings for your project will go) url,https://github.com/link/link-api-config.git
2. Checkout out to a separate branch, then copy skeleton folder to another folder and name it same as your app name(the name must match)
3. To test your code before merging, after pushing your config branch out, in bootstrap.yml replace line (spring.cloud.config.label) with your branch name of link-api-config
    (by default it goes to master branch unless spring.cloud.config.label in the bootstrap.yml is uncommented and keep your branch name here)
4. Note that this is just a temp solution and cannot be pushed upto master with the spring.cloud.config.label pointed to your branch
5. Your changes must be pushed and a Pull request must be opened to merge your changes onto the master branch of link-api-config



## Jenkins Setup
1. Clone this repo http://linkbucket.org.com/scm/jnk/pipeline-scripts.git
2. Using this Jenkins job set up appropriate servers in respective environments
4. Portal standard is to have 1 node per application in dev and test, where as in stage it can 2, also in prod it can change as per the load
5. Once the project has been cloned navigate to  cd pipeline-scripts/bootapis/portal
6. Copy any existing project and name it as config.{your app name here}.groovy
7. We are only doing blue deployments so just need to modify the settings in blue section
8. Modify newrelic_name to the name you want for your application in new relic for APM
9. Then we need to modify the values for host and user which we get from the console output of the jenkins job from step 2.
10. Push your changes and submit a Pull Request

```
$ git clone https://github.com/link/java-skeleton-idx.git NEW-API-NAME-HERE
$ cd NEW-API-NAME-HERE
$ ./gradlew clean build
```
If tests pass, you should be able to run the APIs locally using Spring Boot's `bootRun` gradle task.
The following command will serve the APIs on port 8080 pointing to the `local` Spring profile.

$ ./gradlew bootRun

Documentation TODO:

*   Docker
*   Jenkinsfile 

## Important links

*   [Spring Cloud Netflix Documentation][1]
*   [Link Api Guide][2]
*   [Link Developer Guide (todo)][2]

[1]: http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html
[2]: http://wiki.org.com/display/LINK/API+Guide
