package com.exxonmobil;

import java.io.InputStream;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;

import com.microsoft.azure.servicebus.ClientFactory;
import com.microsoft.azure.servicebus.ClientSettings;
import com.microsoft.azure.servicebus.IMessage;
import com.microsoft.azure.servicebus.IMessageSender;
import com.microsoft.azure.servicebus.Message;
import com.microsoft.azure.servicebus.management.ManagementClient;
import com.microsoft.azure.servicebus.primitives.MessagingFactory;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import com.microsoft.azure.servicebus.security.TokenProvider;

public class AzureConnector {
	@Value("${azure.servicebus.tenantId}")
    private String tenantId;
	
	@Value("${azure.servicebus.clientId}")
	private String clientId;
	
	@Value("${azure.servicebus.clientSecret}")
    private String clientSecret ;
	
	@Value("${azure.servicebus.namespace}")
    private String namespace;
	
	
	@Value("${azure.servicebus.destination}")
    private String destination;


    private ConcurrentHashMap<String, IMessageSender> senderMap = new ConcurrentHashMap<String, IMessageSender>();
    private MessagingFactory messagingFactory;
    private ManagementClient managementClient;

    

    public void connect() throws Exception {
        try {
            TokenProvider provider = TokenProvider.createAzureActiveDirectoryTokenProvider(new AuthCallBack(this.clientId, this.clientSecret), String.format("https://login.microsoftonline.com/%s/", this.tenantId), this.namespace);
            ClientSettings clientSettings = new ClientSettings(provider);

            this.messagingFactory = MessagingFactory.createFromNamespaceName(this.namespace, clientSettings);
            this.managementClient = new ManagementClient(URI.create(String.format("sb://%s.servicebus.windows.net/", this.namespace)), clientSettings);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void disconnect() {
        try {
            this.messagingFactory.close();
            this.closeMessageSenders(this.senderMap);
            this.managementClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void closeMessageSenders(Map<String, IMessageSender> senders) throws ServiceBusException {
        Iterator<IMessageSender> iterator = senders.values().iterator();

        while (iterator.hasNext()) {
            IMessageSender sender = (IMessageSender) iterator.next();
            sender.close();
        }

    }

    private IMessageSender getOrCreateSenderMap(String destinationName) throws ServiceBusException, InterruptedException {
        if (!this.senderMap.containsKey(destinationName)) {
            this.senderMap.put(destinationName, ClientFactory.createMessageSenderFromEntityPath(this.messagingFactory, destinationName));
        }
        return (IMessageSender) this.senderMap.get(destinationName);
    }

    public void send(InputStream payload,String corelationID,String messageID) {
        try {
        	// Connect to Azure service bus.
        	connect();
        	
        	// Create message.
        	byte[] array=IOUtils.toByteArray(payload);
            IMessage message = new Message(array);
            message.setCorrelationId(corelationID);
            message.setMessageId(messageID);
            message.setContentType("application/json");
            
            // Send message.
            IMessageSender sender = this.getOrCreateSenderMap(destination);
            sender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
//			disconnect();
		}
    }
    
    

}
