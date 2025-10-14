package core;
import clinic.VeterinaryClinic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public VeterinaryClinic veterinaryClinic() {

        return new VeterinaryClinic();
    }

    @Bean
    public Zoo zoo() {
        return new Zoo(veterinaryClinic());
    }
}
