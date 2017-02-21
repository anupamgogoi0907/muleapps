
package com.anupam.snake.connector.generated.adapters;

import com.anupam.snake.connector.SnakeConnector;
import javax.annotation.Generated;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;


/**
 * A <code>SnakeConnectorCapabilitiesAdapter</code> is a wrapper around {@link SnakeConnector } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-02-21T01:43:25-03:00", comments = "Build UNNAMED.2793.f49b6c7")
public class SnakeConnectorCapabilitiesAdapter
    extends SnakeConnector
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        return false;
    }

}
