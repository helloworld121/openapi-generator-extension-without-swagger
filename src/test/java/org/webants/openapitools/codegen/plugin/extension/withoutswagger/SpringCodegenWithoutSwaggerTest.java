package org.webants.openapitools.codegen.plugin.extension.withoutswagger;

import org.junit.jupiter.api.Test;
import org.openapitools.codegen.ClientOptInput;
import org.openapitools.codegen.CodegenConstants;
import org.openapitools.codegen.DefaultGenerator;
import org.openapitools.codegen.config.CodegenConfigurator;

import java.util.HashMap;
import java.util.Map;

public class SpringCodegenWithoutSwaggerTest {

    @Test
    public void run() {
        // configuration:
        // https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/spring.md


//        System.setProperty(CodegenConstants.SUPPORTING_FILES, Boolean.FALSE.toString());
//        System.setProperty(CodegenConstants.SUPPORTING_FILES, null);
//        System.setProperty(CodegenConstants.APIS, Boolean.TRUE.toString());
//        System.setProperty(CodegenConstants.MODELS, Boolean.TRUE.toString());


        // DefaultGenerator.generateSupportingFiles
//        Map<String, String> globalProperties = new HashMap<>();
//        globalProperties.put(CodegenConstants.SUPPORTING_FILES, Boolean.FALSE.toString());
//        globalProperties.put(CodegenConstants.GENERATE_APIS, Boolean.TRUE.toString());
//        globalProperties.put(CodegenConstants.GENERATE_MODELS, Boolean.TRUE.toString());

        Map<String, Object> additionalProperties = new HashMap<>();
        additionalProperties.put(CodegenConstants.SOURCE_FOLDER, "."); // skip supporting files => to avoid globalProperties - supportingFiles


        CodegenConfigurator configurator = new CodegenConfigurator()
                .setGeneratorName(SpringCodegenWithoutSwagger.GENERATOR_NAME)
                .setInputSpec("v3_0_petstore.json")
                .setOutputDir("target/junit-test4withoutSwagger")
                .setLibrary(SpringCodegenWithoutSwagger.LIBRARY_WITHOUT_SWAGGER)
//                .setGlobalProperties(globalProperties)
                .setAdditionalProperties(additionalProperties)
                ;

        ClientOptInput clientOptInput = configurator.toClientOptInput();
        DefaultGenerator generator = new DefaultGenerator();
        generator.opts(clientOptInput).generate();
    }

}
