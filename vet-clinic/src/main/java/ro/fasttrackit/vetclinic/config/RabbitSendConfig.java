package ro.fasttrackit.vetclinic.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitSendConfig {

    @Bean
    public Queue consultationQueue() {
        return new Queue("consultation");
    }

    @Bean
    public Queue diagnosisQueue() {
        return new Queue("diagnosis");
    }


    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }


    @Bean
    public Binding bindingConsult(DirectExchange directExchange, Queue consultationQueue) {
        return BindingBuilder.bind(consultationQueue).to(directExchange).with("consultation-msg");
    }

    @Bean
    public Binding bindingDiagnosis(DirectExchange directExchange, Queue diagnosisQueue) {
        return BindingBuilder.bind(diagnosisQueue).to(directExchange).with("diagnosis-msg");
    }

}
