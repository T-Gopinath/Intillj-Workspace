package designPatterns.creational.builder;

public class BuilderDemo {
    public static void main(String[] args) {

        User user = new User.UserBuilder()
                .name("Gopinath")
                .email("gopi@mail.com")
                .age(30)
                .city("Chennai")
                .country("India")
                .build();

        System.out.println(user);
    }
}


/**
 * Real-World Examples
 *
 * StringBuilder in Java
 *
 * Lombok @Builder
 *
 * HTTP Request builders
 *
 * Spring UriComponentsBuilder
 */

//Builder Pattern in Microservices (Example)
/**
 * HttpRequest request = HttpRequest.newBuilder()
 *         .uri(URI.create("https://api.example.com/orders"))
 *         .header("Authorization", "Bearer token")
 *         .timeout(Duration.ofSeconds(10))
 *         .GET()
 *         .build();
 */
