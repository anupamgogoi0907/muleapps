
package com.anupam.snake.connector.generated.adapters;

import com.anupam.snake.connector.SnakeConnector;
import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>SnakeConnectorProcessAdapter</code> is a wrapper around {@link SnakeConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-02-23T12:14:08-03:00", comments = "Build UNNAMED.2793.f49b6c7")
public class SnakeConnectorProcessAdapter
    extends SnakeConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<SnakeConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, SnakeConnectorCapabilitiesAdapter> getProcessTemplate() {
        final SnakeConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,SnakeConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, SnakeConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, SnakeConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
