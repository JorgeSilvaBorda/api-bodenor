mvn io.quarkus:quarkus-maven-plugin:1.10.3.Final:create \
-DprojectGroupId=bodenor.api.lectura.service \
-DprojectArtifactId=api-lectura \
-DclassName="bodenor.api.lectura.service.MSLectura" \
-Dpath="/lectura" \
-Dextensions="resteasy,resteasy-mutiny,context-propagation,resteasy-jsonb,reactive-pg-client,mongodb-client,smallrye-openapi,hibernate-orm,hibernate-validator"
