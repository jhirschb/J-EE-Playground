# Mini Project including a datasource

## Setup

mvn archtype:generate \
  -DarchetypeGroupId=org.wildfly.archetype \
  -DarchetypeArtifactId=wildfly-jakartaee-webapp-archetype \
  -DarchetypeVersion=18.0.0.Final \

## TODO

## H2

create a directory for the h2.jar and the database files 
mkdir -p h2db/h2
cd h2db

Start the server
java -cp h2-1.4.193.jar org.h2.tools.Server -tcp -baseDir h2

