# Flight Kiosk

~~~~
The release of the course work in Software Engineering by Group 103
~~~~

## Software Architecture
Java project without architectures

## Installation
Download the [release](https://gitee.com/electronick_pro/software-engineering2022-103/attach_files/1016969/download/software-engineering2022-103.jar) `JAR` file and you can start to run

## <span style="background-color:yellow;color:black">For this preview version - Database Fetching</span>
- This is a preview version and you may not able to add data to database through the program
- As a result, **database shall be fetched** before you start to use
- Database can be fetched from the release files `data.zip`
- You should extract files of `data.zip` to a folder
- Database is in a folder and you should set the value of `dataDir` the path of the folder in the configuration `xml` file
- The configuration file specification is in the document [Configuration Specification](Configuration%20Specification.md)

## Instructions

### Run directly (without configuration files) - *<span style="color:red">Unable for this preview version</span>*
- Run by directly double click on the `JAR` file
- Or run in command line like below:
  ```shell
  java -jar path/to/jar/file.jar
  ```
  which you can also observe the output of `System.out`,  `System.err`, etc.
### Run with a configuration file - *<span style="color:green">You should use this<span>*
- First you should have a configuration `xml` file, whose specification shall be seen in document [Configuration Specification](Configuration%20Specification.md)
- In this case, you can take `config.xml` as an example
- Before running the program, you should set the property `dataDir` to the **absolute path** of the folder where the downloaded `data.zip` is extracted
- Run in command line like below
  ```shell
  java -jar path/to/jar/file.jar path/to/configuration/file.xml
  ```