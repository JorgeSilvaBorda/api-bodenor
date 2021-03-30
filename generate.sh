mvn io.quarkus:quarkus-maven-plugin:1.10.3.Final:create \
-DprojectGroupId=bodenor.api.lectura.ms \
-DprojectArtifactId=ms-continuidad \
-DclassName="bodenor.api.lectura.service.MSContinuidad" \
-Dpath="/continuidad" \
-Dextensions="resteasy,resteasy-mutiny,context-propagation,resteasy-jsonb,rest-client,jdbc-mysql-client,mongodb-client,smallrye-openapi,hibernate-orm,hibernate-validator"
