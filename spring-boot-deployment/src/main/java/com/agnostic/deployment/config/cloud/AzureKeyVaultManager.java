package com.agnostic.deployment.config.cloud;

import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureKeyVaultManager {

    public Secret getSecret() {
        var credential = new ClientSecretCredentialBuilder()
                .tenantId(System.getenv("AZURE_TENANT_ID"))
                .clientId(System.getenv("TEST_SPN_CLIENT_ID"))
                .clientSecret(System.getenv("TEST_SPN_CLIENT_SECRET"))
                .build();

        var secretClient = new SecretClientBuilder()
                .vaultUrl("https://agnostic-demo.vault.azure.net")
                .credential(credential)
                .buildClient();
        var retrievedSecret = secretClient.getSecret("password");
        return new Secret(retrievedSecret.getName(), retrievedSecret.getValue());
    }
}
