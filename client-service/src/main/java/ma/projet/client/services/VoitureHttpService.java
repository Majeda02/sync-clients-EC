package ma.projet.client.services;

import ma.projet.client.api.CarDto;
import ma.projet.client.clients.VoitureFeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class VoitureHttpService {

    private static final String VOITURE_BASE_URL = "http://service-voiture";

    private final RestTemplate restTemplate;
    private final VoitureFeignClient feignClient;
    private final WebClient.Builder webClientBuilder;

    public VoitureHttpService(RestTemplate restTemplate,
                             VoitureFeignClient feignClient,
                             WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplate;
        this.feignClient = feignClient;
        this.webClientBuilder = webClientBuilder;
    }

    public CarDto carViaRestTemplate(Long clientId) {
        String url = VOITURE_BASE_URL + "/api/cars/byClient/" + clientId;
        return restTemplate.getForObject(url, CarDto.class);
    }

    public CarDto carViaFeign(Long clientId) {
        return feignClient.getCarByClient(clientId);
    }

    public CarDto carViaWebClient(Long clientId) {
        return webClientBuilder.build()
                .get()
                .uri(VOITURE_BASE_URL + "/api/cars/byClient/{id}", clientId)
                .retrieve()
                .bodyToMono(CarDto.class)
                .block(); // sync mode for this lab
    }
}
