package org.webants.openapitools.codegen.plugin.extension.withoutswagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;
import org.openapitools.codegen.SupportingFile;
import org.openapitools.codegen.languages.SpringCodegen;

import java.util.Collections;
import java.util.List;

public class SpringCodegenWithoutSwagger
        extends SpringCodegen {

    public static final String GENERATOR_NAME = "springCodegenWithoutSwagger";

    public static final String LIBRARY_WITHOUT_SWAGGER = "without-swagger";


    public SpringCodegenWithoutSwagger() {
        super();

        supportedLibraries.put(LIBRARY_WITHOUT_SWAGGER, "This library makes it possible to generate Spring");
    }

    @Override
    public String getName() {
        return GENERATOR_NAME;
    }

    @Override
    public List<SupportingFile> supportingFiles() {
        // this is necessary to remove supporting files like pom...
        // => the purpose of this extension is to generate just API and Models
        return Collections.emptyList();
    }

    @Override
    public void postProcessModelProperty(CodegenModel model, CodegenProperty property) {
        super.postProcessModelProperty(model, property);

        // cleanup swagger import
        model.imports.remove(ApiModelProperty.class.getSimpleName());
        model.imports.remove(ApiModel.class.getSimpleName());
    }

}
