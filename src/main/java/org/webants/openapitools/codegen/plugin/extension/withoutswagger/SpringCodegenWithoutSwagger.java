package org.webants.openapitools.codegen.plugin.extension.withoutswagger;

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
        return Collections.emptyList();
    }


}
