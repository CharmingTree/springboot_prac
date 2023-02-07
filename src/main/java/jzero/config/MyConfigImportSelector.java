package jzero.config;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

public class MyConfigImportSelector implements DeferredImportSelector  {
    private final ClassLoader classLoader;

    public MyConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        return new String[] {
//                "jzero.config.autoconfig.DispatcherServletConfig",
//                "jzero.config.autoconfig.TomcatWebServerConfig"
//        };

        //Iterable<String> candidates = ImportCandidates.load(MyAutoConfigration.class, classLoader);
        //return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);
        List<String> autoConfigs = new ArrayList<>();
//        for ( String candidate : ImportCandidates.load(MyAutoConfigration.class, classLoader)) {
//            autoConfigs.add(candidate);
//        }

        // MyAutoConfiguration.class 의 풀 패스.imports 에서 찾는다.
        ImportCandidates.load(MyAutoConfigration.class, classLoader).forEach(autoConfigs::add);

        //return autoConfigs.toArray(new String[0]);
        return Arrays.copyOf(autoConfigs.toArray(), autoConfigs.size(), String[].class);
    }
}
