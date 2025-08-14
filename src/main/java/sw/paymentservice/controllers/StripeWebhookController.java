package sw.paymentservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/stripeWebhook")
@RestController
public class StripeWebhookController {

    @PostMapping
    public void listenToStripeWebhookEvents(@RequestBody String event){
        System.out.println("Stripe Webhook Event: " + event);
    }
}
