package sw.paymentservice.paymentgateways;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class RazorpayPaymentGateway implements IPaymentGateway {

    @Autowired
    private RazorpayClient razorpayClient;

    @Override
    public String generatePaymentLink(Long amount, String orderId, String phoneNumber, String name, String email) {
        try{
            long currentTime = Instant.now().toEpochMilli();
            long futureTime = currentTime + (15 * 60 * 1000);

            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount",amount);
            paymentLinkRequest.put("currency","INR");
            paymentLinkRequest.put("accept_partial",true);
            paymentLinkRequest.put("first_min_partial_amount",100);
            paymentLinkRequest.put("expire_by",futureTime);
            paymentLinkRequest.put("reference_id",orderId);
            paymentLinkRequest.put("description","Payment for order id "+orderId);
            JSONObject customer = new JSONObject();
            customer.put("name",name);
            customer.put("contact",phoneNumber);
            customer.put("email",email);
            paymentLinkRequest.put("customer",customer);
            JSONObject notify = new JSONObject();
            notify.put("sms",true);
            notify.put("email",true);
            paymentLinkRequest.put("notify",notify);
            paymentLinkRequest.put("reminder_enable",true);
            paymentLinkRequest.put("callback_url","https://flipkart.com");
            paymentLinkRequest.put("callback_method","get");

            PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
            return payment.get("short_url").toString();
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }

    }
}
