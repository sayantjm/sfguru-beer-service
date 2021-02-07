package sayant.springframeworkguru.sfgurubeerservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import sayant.springframeworkguru.brewery.model.events.ValidateOrderRequest;
import sayant.springframeworkguru.brewery.model.events.ValidateOrderResult;
import sayant.springframeworkguru.sfgurubeerservice.config.JmsConfig;
import sayant.springframeworkguru.sfgurubeerservice.service.BeerOrderValidationListener;

/**
 * Created by sayantjm on 7/2/21
 */
@RequiredArgsConstructor
@Component
public class BeerOrderValidationListenerImpl implements BeerOrderValidationListener {

    private final BeerOrderValidatorImpl validator;
    private final JmsTemplate jmsTemplate;

    @Override
    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_QUEUE)
    public void listen(ValidateOrderRequest validateOrderRequest) {

        Boolean isValid = validator.validateOrder(validateOrderRequest.getBeerOrderDto());

        jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE, ValidateOrderResult.builder()
                .orderId(validateOrderRequest.getBeerOrderDto().getId())
                .isValid(isValid)
                .build()
        );

    }
}
