package pl.kozakowski.seleniumtestingautomat;

import org.reflections8.Reflections;
import org.reflections8.scanners.ResourcesScanner;
import org.reflections8.scanners.SubTypesScanner;
import org.reflections8.util.ClasspathHelper;
import org.reflections8.util.ConfigurationBuilder;
import org.reflections8.util.FilterBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TechnologyClassExtractor {

    Set<Class<? extends PageFactory>> classes;

    public TechnologyClassExtractor() {
        List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false), new ResourcesScanner())
                .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("pl.kozakowski.seleniumtestingautomat.pageFactory"))));// "pl.kozakowski.seleniumtestingautomat"))));//

         classes = reflections.getSubTypesOf(PageFactory.class);
    }

    public Set<Class<? extends PageFactory>> getInstalledTechnologyClasses() {
        return classes;
    }

}
