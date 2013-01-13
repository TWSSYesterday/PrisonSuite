package com.wolvencraft.prison.metrics;
 
import java.io.IOException;
import java.util.logging.Level;

import com.wolvencraft.prison.PrisonSuite;
import com.wolvencraft.prison.metrics.Metrics.Graph;
import com.wolvencraft.prison.util.Message;
 
public class Statistics {
     
    private Metrics metrics;
     
    public Statistics(PrisonSuite plugin) {
    	if(PrisonSuite.getSettings().METRICS) {
	        try {
	        	this.metrics = new Metrics(plugin);
	        	if(!metrics.isOptOut()) {
	        		gatherData();
	        		metrics.start();
	        	}
	        }
	        catch (IOException e) { Message.log(Level.SEVERE, "Unable to start PluginMetrics"); }
    	} else {
    		Message.log("PluginMetrics disabled by the configuration");
    	}
    }
     
    private void gatherData() {
        Graph pluginsRunning = metrics.createGraph("Number of PrisonSuite plugins running");
    	Message.debug("Sending data to Metrics. " + PrisonSuite.getPlugins().size() + " plugins");
        
        int plugins = PrisonSuite.getPlugins().size();
        
        pluginsRunning.addPlotter(new Metrics.Plotter(plugins + "") {
            @Override
            public int getValue() { return 1; }
        });
    }
     
    public Metrics getMetrics() {
        return metrics;
    }
}