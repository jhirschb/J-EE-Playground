# J-EE-Playground
Sample Projects using Jakarta EE and related technologies
Use the API endpoints to call functions and observe the behaviour.


## Sample Projects
### jee-minimal

This minimalistic project only depends on the javax:javaee-api and was was created using an maven archetype, change groupId and artifactId for your own project.

mvn archetype:generate \
-DarchetypeGroupId=com.airhacks \
-DarchetypeArtifactId=javaee8-essentials-archetype \
-DarchetypeVersion=0.0.1 \
-Darchetype.interactive=false \
--batch-mode \
-Dversion=0.0.1 \
-DgroupId=playground.ee \
-DartifactId=jee-minimal

Add a web.xml file, as described in the wildfly docs (https://docs.wildfly.org/18/JavaEE_Tutorial.html).



### jee-jpa

mvn archetype:generate \
-DarchetypeGroupId=org.wildfly.archetype \
-DarchetypeArtifactId=wildfly-jakartaee-webapp-archetype \
-DarchetypeVersion=18.0.0.Final \
-DarchetypeInteractive=false --batch-mode \
-Dversion=0.0.1 -DgroupId=playground.ee -DartifactId=jee-jpa
