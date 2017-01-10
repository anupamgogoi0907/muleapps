
package com.anupam.rest.generated.adapters;

import com.anupam.rest.RestConnector;
import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>RestConnectorProcessAdapter</code> is a wrapper around {@link RestConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-01-10T05:33:56-02:00", comments = "Build UNNAMED.2793.f49b6c7")
public class RestConnectorProcessAdapter
    extends RestConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<RestConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, RestConnectorCapabilitiesAdapter> getProcessTemplate() {
        final RestConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,RestConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, RestConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, RestConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
