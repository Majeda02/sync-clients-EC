package ma.projet.client.api;

import ma.projet.client.services.VoitureHttpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final VoitureHttpService voitureHttpService;

    public ClientController(VoitureHttpService voitureHttpService) {
        this.voitureHttpService = voitureHttpService;
    }

    @GetMapping("/{id}/car/rest")
    public CarDto carRest(@PathVariable Long id) {
        return voitureHttpService.carViaRestTemplate(id);
    }

    @GetMapping("/{id}/car/feign")
    public CarDto carFeign(@PathVariable Long id) {
        return voitureHttpService.carViaFeign(id);
    }

    @GetMapping("/{id}/car/webclient")
    public CarDto carWebClient(@PathVariable Long id) {
        return voitureHttpService.carViaWebClient(id);
    }
}
