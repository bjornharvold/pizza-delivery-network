package com.sevenpeaks.design.sdk;

import com.sevenpeaks.design.sdk.api.PizzaEntityControllerApi;
import com.sevenpeaks.design.sdk.invoker.ApiClient;
import com.sevenpeaks.design.sdk.model.EntityModelPizza;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created on: 11/28/21.
 *
 * @author Bjorn Harvold
 * Responsibility:
 */
public class PizzaDeliveryNetworkTest {
    private ApiClient apiClient;

    @Before
    public void setUp() {
        final WebClient webClient = WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/hal+json")
                .build();

        this.apiClient = new ApiClient(webClient);
    }

    @Test
    public void givenNetwork_whenLoad_thenVerify() {
        final PizzaEntityControllerApi api = new PizzaEntityControllerApi(this.apiClient);

        final Mono<EntityModelPizza> pizzaMono = api.getItemResourcePizzaGet("pizza-1");

        StepVerifier
                .create(pizzaMono)
                .assertNext(pizza -> {
                    assertNotNull(pizza);
                    assertEquals("Incorrect pizza", "Pizza Napoli", pizza.getName());
                })
                .expectComplete()
                .verify();

    }
}
