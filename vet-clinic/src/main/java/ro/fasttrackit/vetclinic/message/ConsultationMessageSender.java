//package ro.fasttrackit.vetclinic.message;
//
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Component;
//import ro.fasttrackit.vetclinic.model.ConsultationDto;
//import ro.fasttrackit.vetclinic.model.ConsultationMessageDto;
//
//@Component
//public class ConsultationMessageSender {
//    private final RabbitTemplate template;
//    private final DirectExchange directExchange;
//    private final ConsultationDto newConsultation;
//
//    public ConsultationMessageSender(RabbitTemplate template, DirectExchange directExchange, ConsultationDto newConsultation) {
//        this.template = template;
//        this.directExchange = directExchange;
//        this.newConsultation = newConsultation;
//    }
//
//    public void sendMessage() {
//        ConsultationMessageDto consultationCreatedMessage = new ConsultationMessageDto();
//        consultationCreatedMessage.setVetName(newConsultation.getVet().getFirstName() + " " + newConsultation.getVet().getLastName());
//        consultationCreatedMessage.setPetName(newConsultation.getPet().getName());
//        consultationCreatedMessage.setOwnerName(newConsultation.getOwner().getFirstName() + " " + newConsultation.getOwner().getLastName());
//
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            String stringMessageConverted = objectMapper.writeValueAsString(consultationCreatedMessage);
//            rabbitTemplate.convertAndSend(directExchange.getName(), "consultation", stringMessageConverted);
//        } catch (JsonProcessingException e) {
////            e.printStackTrace();
//        }
//        return mapEntityToConsultationResponse(saveEntity);
//    }
//
//}
//}
