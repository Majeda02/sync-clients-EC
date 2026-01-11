package ma.projet.voiture.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class VoitureController {

    @Value("${car.simulatedDelayMs:20}")
    private long simulatedDelayMs;

    @GetMapping("/byClient/{clientId}")
    public CarDto getCarByClient(@PathVariable Long clientId) throws InterruptedException {
        if (simulatedDelayMs > 0) {
            Thread.sleep(simulatedDelayMs);
        }

        // Données en mémoire (stable pour tests)
        return switch (clientId.intValue()) {
            case 1 -> new CarDto(10L, "Toyota", "Yaris", 1L);
            case 2 -> new CarDto(11L, "Renault", "Clio", 2L);
            case 3 -> new CarDto(12L, "Peugeot", "208", 3L);
            default -> new CarDto(99L, "Dacia", "Sandero", clientId);
        };
    }
}
