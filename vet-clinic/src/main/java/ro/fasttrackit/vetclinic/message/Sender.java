//package ro.fasttrackit.vetclinic.message;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Component;
//import ro.fasttrackit.vetclinic.model.ConsultationDto;
//import ro.fasttrackit.vetclinic.model.DiagnosisDto;
//
//import java.io.IOException;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@Component
//public class Sender {
//
//    private final RabbitTemplate template;
//    private final DirectExchange directExchange;
//
//
//    AtomicInteger index = new AtomicInteger();
//    AtomicInteger count = new AtomicInteger();
//
//    public Sender(RabbitTemplate template, DirectExchange directExchange) {
//        this.template = template;
//        this.directExchange = directExchange;
//    }
//
//    private final String[] keys = {"consultation", "diagnosis"};
//
//
//    public void sendMessage() throws IOException {
//        StringBuilder builder = new StringBuilder();
//        ObjectMapper objectMapper = new ObjectMapper();
//        ConsultationDto consultation = new ConsultationDto();
//        DiagnosisDto diagnosis = new DiagnosisDto();
//
//
//        if (this.index.incrementAndGet() == 2) {
//            this.index.set(0);
//        }
//        String key = keys[this.index.get()];
//        builder.append(key).append(' ');
//        builder.append(this.count.get());
//        String message = builder.toString();
//        template.convertAndSend(directExchange.getName(), key, message);
//        System.out.println(" [x] Sent '" + message + "'");
////
////        if (key == "consultation") {
////            String message = "Consultation created: " + Date.from(Instant.now()) + consultation;
////            this.template.convertAndSend(objectMapper.writeValueAsBytes(consultation));
////            System.out.println("[x] Sent '" + message + "'");
////        } else if (key == "diagnosis") {
////            String message = "Consultation created: " + Date.from(Instant.now()) + diagnosis;
////            this.template.convertAndSend(objectMapper.writeValueAsBytes(consultation));
////            System.out.println("[x] Sent '" + message + "'");
////        }
//
//
//    }
//
//}
