package ro.fasttrackit.vetnotification.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ro.fasttrackit.vetnotification.model.MessageReceiverDiagnosis;

import java.time.Instant;
import java.util.Date;

@Component
@RabbitListener(queues = "diagnosis")
public class DiagnosisReceiver {

    @RabbitHandler
    public void receiveDiagnosis(String diagnosisMessage){
        ObjectMapper objectMapper2 = new ObjectMapper();

        try{
            MessageReceiverDiagnosis messageReceiverDiagnosis = objectMapper2.readValue(diagnosisMessage, MessageReceiverDiagnosis.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("[" + Date.from(Instant.now()) + "]" + " [-] Diagnosis: " + diagnosisMessage);
    }
}
