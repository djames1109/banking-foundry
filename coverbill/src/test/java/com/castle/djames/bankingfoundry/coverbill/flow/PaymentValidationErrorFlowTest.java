package com.castle.djames.bankingfoundry.coverbill.flow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;

@WebMvcTest
@AutoConfigureRestTestClient
public class PaymentValidationErrorFlowTest {

    @Autowired
    private RestTestClient restTestClient;

    @Test
    public void testSubmitPayment_zeroAmount_returnsBadRequest() {
        var request = """
            {
                "source": {
                    "cardNumber": "ENCRYPTED_CARD_NUMBER"
                },
                "target": {
                    "bank": "BPI",
                    "productName": "BPI Credit Card",
                    "accountNumber": "{{$randomBankAccount}}",
                    "accountName": "{{$randomBankAccountName}}"
                },
                "amount": 0,
                "currency": "PHP",
                "paymentMode": {
                    "type": "ONE-TIME"
                }
            }
            """;

        restTestClient.post()
            .uri("/v1/payments/submit")
            .contentType(MediaType.APPLICATION_JSON)
            .body(request)
            .exchange()
            .expectStatus().isBadRequest();

    }

}
