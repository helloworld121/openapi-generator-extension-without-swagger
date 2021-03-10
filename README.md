# Extension for OpenAPITools "openapi-generator-maven-plugin"

This extension for enables to generate Spring-Code without the swagger annotations.

**ATTENTION**: The generator provided by this extension may break other Spring outputs. Therefore, only use **this** extension to generate code without swagger-annotations.
It is still possible to generate other Spring outputs by configuring a different generator.

* It extends the "SpringCodegen" class provided by "org.openapi.tools:openapi-generator".
  * And provides a new library which can be configured in the maven-plugin.  
* The modifications are done by providing modified mustache-templates for this library, which removed swagger annotations. 
