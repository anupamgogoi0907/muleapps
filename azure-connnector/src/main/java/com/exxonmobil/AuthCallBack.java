package com.exxonmobil;

import com.microsoft.aad.msal4j.*;
import com.microsoft.azure.servicebus.security.AzureActiveDirectoryTokenProvider.AuthenticationCallback;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class AuthCallBack implements AuthenticationCallback{

	private final String clientId;
    private final String clientSecret;

    public AuthCallBack(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    public CompletableFuture<String> acquireTokenAsync(String audience, String authority, Object state) {
        try {
            IClientCredential credential = ClientCredentialFactory.createFromSecret(this.clientSecret);
            ConfidentialClientApplication app = ((ConfidentialClientApplication.Builder) ConfidentialClientApplication.builder(this.clientId, credential).authority(authority)).build();
            ClientCredentialParameters parameters = ClientCredentialParameters.builder(Collections.singleton(audience + ".default")).build();
            IAuthenticationResult result = (IAuthenticationResult) app.acquireToken(parameters).join();
            return CompletableFuture.completedFuture(result.accessToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
