package com.zee.modulith.email;

import com.zee.modulith.order.dto.EmailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 18 May, 2024
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailManagement {

    @ApplicationModuleListener
    void mail(final EmailDto emailDto){
        System.out.println("Email properties received");

        if(!emailDto.orderComplete()){
            String body = "Dear " + emailDto.customerName() + ",\n" +
                    "An order was initialized with Id: " + emailDto.orderIdentifier() + " and total sum of: N"
                    + emailDto.totalAmount()/100;

            log.info("initial Email order details: {}", body);
        }else {
            String body = "Dear " + emailDto.customerName() + ",\n" +
                    "Your order with Id: " + emailDto.orderIdentifier() + " and total sum of: N"
                    + emailDto.totalAmount()/100 + " wss completed successfully";

            log.info("Email details completion details: {}", body);
        }
        log.info("Email sent to : {}", emailDto.email());
    }

}
