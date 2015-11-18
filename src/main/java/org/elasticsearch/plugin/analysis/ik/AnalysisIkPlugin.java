package org.elasticsearch.plugin.analysis.ik;

import org.elasticsearch.common.inject.AbstractModule;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.ESLoggerFactory;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.index.analysis.IkAnalysisBinderProcessor;
import org.elasticsearch.indices.analysis.IKIndicesAnalysisModule;
import org.elasticsearch.plugins.Plugin;

import java.util.Collection;
import java.util.Collections;
import java.util.logging.Logger;

import static java.rmi.Naming.bind;


public class AnalysisIkPlugin extends Plugin {
    private final Settings settings;

    public AnalysisIkPlugin(Settings settings){
        this.settings = settings;
    }

    @Override public String name() {
        return "analysis-ik";
    }


    @Override public String description() {
        return "ik analysis";
    }

    @Override
    public Collection<Module> nodeModules() {
        return Collections.<Module>singletonList(new IKIndicesAnalysisModule());
    }

    public static class ConfiguredExampleModule extends AbstractModule {
        @Override
        protected void configure() {
        }
    }

    public void onModule(AnalysisModule module) {
        module.addProcessor(new IkAnalysisBinderProcessor());
    }
}
