# Extension for OpenAPITools "openapi-generator-maven-plugin"

### without swagger-annotation
This extension provides code-generation to generate JavaSpring-Boot without the swagger annotations.

* It extends the "SpringCodegen" class provided by "org.openapi.tools:openapi-generator".
  * And provides a new library which can be configured in the maven-plugin.  
* The modifications are done by providing modified mustache-templates for this library, which don't contain the swagger annotations. 

### just classes
The current implementation focuses on just generating **api** and **model** classes.
* it won't generate the project structure 


### how to extend
* currently, the extension consist just out of a few modified mustache-templates; so it can be extent easily


### how to use
The extension can be used just like the JavaSpring generator described on the OpenAPI Spec pages:
* https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-maven-plugin
* https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/spring.md

#### example
An example project with a working setup is contained in the sub-directory **sample**

There are just the following configurations, which are displayed in the example below:
* plugin-configuration: \<generatorName>springCodegenWithoutSwagger\</generatorName>
* plugin-configuration: \<library>without-swagger\</library>
* plugin-dependencies: this must contain the extension


```xml
<plugin>
    <groupId>org.openapitools</groupId>
    <artifactId>openapi-generator-maven-plugin</artifactId>
    <version>5.0.1</version>
    <executions>
        <execution>
            <goals>
                <goal>generate</goal>
            </goals>
            <configuration>
                <inputSpec>${project.basedir}/src/test/resources/v3_0_petstore.json</inputSpec>

                <output>${project.build.directory}/generated-test-sources/petstore</output>
                <addCompileSourceRoot>true</addCompileSourceRoot>

                <generateModels>true</generateModels>
                <modelPackage>org.webants.petstore.entity</modelPackage>

                <generateApis>true</generateApis>
                <apiPackage>org.webants.petstore.boundary</apiPackage>

                <generatorName>springCodegenWithoutSwagger</generatorName>
                <library>without-swagger</library>
                <configOptions>
                    <!-- Enable OpenAPI Jackson Nullable library -->
                    <openApiNullable>false</openApiNullable>
                    <!-- title will be used in application-configuration to configure the base-path -->
                    <title>petstore</title>
                    <apiFirst>false</apiFirst>
                    <delegatePattern>true</delegatePattern>
                    <interfaceOnly>false</interfaceOnly>
                    <sourceFolder>.</sourceFolder>
                    <useTags>true</useTags>
                </configOptions>
            </configuration>
        </execution>
    </executions>
    <dependencies>
        <dependency>
            <groupId>org.webants.openapitools.codegen.plugin.extension</groupId>
            <artifactId>without-swagger</artifactId>
            <version>5.0.1</version>
        </dependency>
    </dependencies>
</plugin>
```
