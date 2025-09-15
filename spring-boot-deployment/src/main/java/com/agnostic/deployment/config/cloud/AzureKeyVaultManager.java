package com.agnostic.deployment.config.cloud;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureKeyVaultManager {

    WebTarget webTarget;
    ObjectMapper objectMapper = new ObjectMapper();

    public Secret getSecret() {
        String secretName ="password";
        String accessToken = getAccessToken();
        String vaultUrl = "https://agnostic-demo.vault.azure.net";
        String secretEndpoint = vaultUrl + "/secrets/" + secretName + "?api-version=7.3";

        try {
            webTarget = ClientBuilder.newBuilder().build().target(secretEndpoint);
            Response response = webTarget
                    .request(MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + accessToken)
                    .get();

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed to retrieve secret");
            }
            String body = response.readEntity(String.class);
            JsonNode root = objectMapper.readTree(body);
            String value = root.get("value").asText();
            return new Secret(secretName, value);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching secret from Azure Key Vault", e);
        }
    }


    private String getAccessToken() {

        String azureTenantId = System.getenv("AZURE_TENANT_ID");
        String clientId = System.getenv("TEST_SPN_CLIENT_ID");
        String clientSecret = System.getenv("TEST_SPN_CLIENT_SECRET");
        Form form = new Form()
                .param("grant_type", "client_credentials")
                .param("client_id", clientId)
                .param("client_secret", clientSecret)
                .param("scope", "https://vault.azure.net/.default");

        String tokenUrl = "https://login.microsoftonline.com/" + azureTenantId + "/oauth2/v2.0/token";

        webTarget = ClientBuilder.newBuilder().build().target(tokenUrl);
        Response response = webTarget
                .request(MediaType.APPLICATION_FORM_URLENCODED)
                .post(Entity.form(form));

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed to obtain access token");
        }

        try {
            String body = response.readEntity(String.class);
            JsonNode root = objectMapper.readTree(body);
            return root.get("access_token").asText();

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse access token from response.", e);
        }
    }

}

