package ro.fasttrackit.vetnotification.message;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ro.fasttrackit.vetnotification.model.MessageReceiverConsultation;


@Component
@RabbitListener(queues = "consultation")
public class ConsultationReceiver {


    @RabbitHandler
    public void receiveConsultation(String consultationMessage) {
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            MessageReceiverConsultation messageReceiverConsultation = objectMapper.readValue(consultationMessage, MessageReceiverConsultation.class);
            System.out.println("Owner Name: " + messageReceiverConsultation.getOwnerName() +
                    "Vet Name: " + messageReceiverConsultation.getVetName() +
                    "Pet Name: " + messageReceiverConsultation.getPetName());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(" [-] Consultation: " + consultationMessage);
    }

}
