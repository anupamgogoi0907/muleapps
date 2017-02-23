
package com.anupam.snake.connector.generated.agents;

import com.anupam.snake.connector.generated.devkit.SplashScreenAgent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.apache.commons.lang.StringUtils;
import org.mule.api.MetadataAware;
import org.mule.api.MuleContext;
import org.mule.api.agent.Agent;
import org.mule.api.context.MuleContextAware;
import org.mule.api.registry.Registry;
import org.mule.util.StringMessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Agent implementation to add splash screen information for DevKit extensions at application startup
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-02-23T12:14:08-03:00", comments = "Build UNNAMED.2793.f49b6c7")
public class DefaultSplashScreenAgent implements SplashScreenAgent, Agent, MuleContextAware
{

    private int extensionsCount;
    private MuleContext muleContext;
    private static Logger logger = LoggerFactory.getLogger(DefaultSplashScreenAgent.class);

    public void setName(String name) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return "DevKitSplashScreenAgent";
    }

    public String getDescription() {
        return "DevKit Extension Information";
    }

    /**
     * Retrieves extensionsCount
     * 
     */
    public int getExtensionsCount() {
        return this.extensionsCount;
    }

    /**
     * Retrieves muleContext
     * 
     */
    public MuleContext getMuleContext() {
        return this.muleContext;
    }

    /**
     * Sets muleContext
     * 
     * @param value Value to set
     */
    public void setMuleContext(MuleContext value) {
        this.muleContext = value;
    }

    public void initialise() {
    }

    public void splash() {
        Registry registry = muleContext.getRegistry();
        Collection<MetadataAware> metadataAwares = registry.lookupObjects(MetadataAware.class);
        Map<Class, MetadataAware> metadataAwaresByClass = new HashMap<Class, MetadataAware>();
        for (MetadataAware connectorMetadata: metadataAwares) {
            metadataAwaresByClass.put(metadataAwares.getClass(), connectorMetadata);
        }
        extensionsCount = metadataAwaresByClass.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((("DevKit Extensions ("+ Integer.toString(extensionsCount))+") used in this application \n"));
        if (extensionsCount > 0) {
            for (MetadataAware connectorMetadata: metadataAwaresByClass.values()) {
                stringBuilder.append(StringUtils.capitalise(connectorMetadata.getModuleName()));
                stringBuilder.append(" ");
                stringBuilder.append(connectorMetadata.getModuleVersion());
                stringBuilder.append(" (DevKit ");
                stringBuilder.append(connectorMetadata.getDevkitVersion());
                stringBuilder.append(" Build ");
                stringBuilder.append(connectorMetadata.getDevkitBuild());
                stringBuilder.append(")+\n");
            }
        }
        logger.info(StringMessageUtils.getBoilerPlate(stringBuilder.toString(), '+', 80));
    }

    public void start() {
        splash();
    }

    public void stop() {
    }

    public void dispose() {
    }

}
