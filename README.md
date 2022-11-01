# IC 2.0 QA Automation template
This repository serves as a template to create a IC 2.0 QA automation module from scratch.

## Table of Contents
  - [Overview](#overview)
  - [Project Dependencies](#project-dependencies)
  - [IDE](#ide)
      - [Plugins](#plugins)
    - [Import project to Eclipse IDE](#import-project-to-eclipse-ide)
    - [Running test cases](#running-test-cases)
  - [Documentation](#documentation)
  - [FAQ](#faq)


## Overview
The goal of this template repository is to serve as a base project to create your QA module. It includes all the dependencies and utilities required to develop your own custom test cases.
To create a QA module based on this project click on `Use this template` button and follow the instructions from GitHub. For more details on how to set up your QA module please refer to the [Documentation section](#documentation).

## Project Dependencies
The project uses [Automation common library](https://github.com/HayGroup/ic_platform_qa_automation_common_library) as their main dependency. The library in question contains commons features that can be used by QA modules to facilitate the development of custom test cases.

## IDE
You are welcome to use any IDE of your preference, however, Eclipse IDE is recommended. You can download Eclipse Installer [here](https://www.eclipse.org/downloads/). After Eclipse Installer is downloaded, please install "Eclipse IDE for Java Developers". 


#### Plugins
Once Eclipse IDE is installed, make sure to also install the plugins listed below. To do so go to Eclipse -> Help -> Eclipse Marketplace.
- Cucumber
- TestNG
- Eclipse m2e - Maven support in Eclipse IDE Latest

<img src="https://user-images.githubusercontent.com/48956806/137987444-023fe727-3acb-4fcc-8f7f-bdfb17a26cdb.png" alt="Required plugins" width="600"/>

### Import project to Eclipse IDE
Under File tab -> Import -> under Maven folder, select "Existing Maven Projects" -> Next -> Find the local project folder path by clicking the "Browse" button -> Finish.

### Running test cases
To run the tests go to ***e2e-automation/src/test/java/runners*** and select the project which you want to run ( e.g. FunctionalRunner.java). Right click on the file -> Run As -> TestNG Test.

To run test cases without headless (meaning being able to see the browser GUI and the operations been operated on it) there are two options:

1. Using Eclipse, go to Run -> Run configurations -> select project -> VM arguments
   - Inside the box add `-Dheadless=false`


2. Using the command line, run `mvn -Dheadless=false clean install`

## Documentation
- Find more details on how to set up your IC 2.0 QA Automation module [here](https://kornferry.atlassian.net/wiki/spaces/I2/pages/316735792/IC2.0+-+QA+Automation+Onboarding).
- Refer [here](https://kornferry.atlassian.net/wiki/spaces/ICQA/pages/143425698/Videos) for more getting started videos on the IC 2.0 QA Automation module, such as how to write test cases, committing changes and API testing.

## FAQ
| Issue 	| Solution 	|
|---	|---	|
| Console log has no error and all tests passed, but browser is not poping up? 	| Make sure you run test cases without headless. Please refer to Running Test Cases section. 	|
