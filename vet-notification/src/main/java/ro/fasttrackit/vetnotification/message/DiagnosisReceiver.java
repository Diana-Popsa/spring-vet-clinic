//package ro.fasttrackit.vetnotification.message;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@RabbitListener(queues = "diagnosis")
//public class DiagnosisReceiver {
//
//    @RabbitHandler
//    public void receive(Byte diagnosisMessage, String in) throws InterruptedException{
//        receive(in, 2);
//        System.out.println(" [-] Diagnosis`: " + diagnosisMessage);
//    }
//}
