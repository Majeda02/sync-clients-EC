package ma.projet.client.clients;

import ma.projet.client.api.CarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-voiture")
public interface VoitureFeignClient {

    @GetMapping("/api/cars/byClient/{clientId}")
    CarDto getCarByClient(@PathVariable("clientId") Long clientId);
}
