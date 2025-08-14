package sw.paymentservice.configurations;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayConfigurations {
    @Value("${rzpay.id}")
    private String rzpayId;

    @Value("${rzpay.secret}")
    private String rzpaySecret;

    @Bean
    public RazorpayClient razorpayClient() throws RazorpayException {
        return new RazorpayClient(rzpayId,rzpaySecret);
    }
}
