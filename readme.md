# ppl-assignment-heiisenbergg
ppl-assignment-heiisenbergg created by GitHub Classroom

### Ajay Agrwal (RIT2015021)

### General Information
- Project consists of different codes for different Question.
- Developed on Intellij IDEA ide on Windows.
- jdk version 1.8.0_11 used
- Build system used : Gradle

### Running the project
- clone the project ,extract it
- I have provided a batch file for building each project. Batch file has name "build[Question no.].bat". Eg. build3.bat.
- You can either run it or follow steps given below.
- in cmd navigate to project root folder such as Question3,Question4,etc.
- to create jar files type "gradle build" on cmd
- navigate to 'build' folder
- navigate to 'libs' folder
- jar files of that particular question is created by name 'Third.jar','Fourth.jar', and likewise.
- to run a particular question on terminal type "java -jar " followed by Associated_jar file
- ex. To run question 3,cd to /buil/libs and run "java -jar Third.jar", enter and likewise for others questions
- jar files are name as "Third.jar", "Fourth.jar", "Fifth.jar", "Sixth.jar", "Seventh.jar", "Eigth.jar", "Nineth.jar", "Tenth.jar".
- I have also provided a master batch file named "buildAll.bat" which will build all the projects and thier javadocs.

### To generate javadoc
- in cmdl navigate to project root folder
- on terminal type "gradle javadoc"
- now navigate to build
- navigate to docs
- navigate to javadoc
- here Documentation is generated

### ClassDiagram
- in project folder class diagram is in file "class Diagram.pdf"
