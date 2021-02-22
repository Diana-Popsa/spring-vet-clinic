package ro.fasttrackit.vetclinic.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitSendConfig {

    @Bean
    @Primary
    public Queue consultationQueue() {
        return new Queue("consultation");
    }

    @Bean
    public Queue diagnosisQueue(){
        return new Queue("diagnosis");
    }


    @Bean
    public Binding bindingConsult (DirectExchange directExchange, Queue consultationQueue){
        return BindingBuilder.bind(consultationQueue).to(directExchange).with("consultation");
    }

    @Bean
    public Binding bindingDiagnosis (DirectExchange directExchange, Queue diagnosisQueue){
        return BindingBuilder.bind(diagnosisQueue).to(directExchange).with("diagnosis");
    }

//    @Bean
//    public Queue queue() {
//        return new Queue("consultation");
//    }
//
//    @Bean
//    public Queue queue2(){
//        return new Queue("diagnosis");
//    }


    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }


//    @Bean
//    public RabbitSendConfig sender(){
//        return new RabbitSendConfig();
//    }


//    @Bean
//    public Binding binding1(DirectExchange directExchange, Queue queue){
//        return BindingBuilder.bind(queue).to(directExchange);
//    }
//
//    @Bean
//    public Binding binding2(FanoutExchange fanout, Queue queue2){
//        return BindingBuilder.bind(queue2).to(fanout);
//    }

}
