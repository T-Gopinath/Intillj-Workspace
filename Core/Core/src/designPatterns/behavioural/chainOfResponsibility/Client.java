package designPatterns.behavioural.chainOfResponsibility;

public class Client {
    public static void main(String[] args) {

        Approver manager = new Manager();
        Approver director = new Director();
        Approver ceo = new CEO();

        manager.setNext(director);
        director.setNext(ceo);

        manager.approveRequest(8_000);
        manager.approveRequest(30_000);
        manager.approveRequest(1_00_000);
    }
}


/**
 * 6. Advantages
 *
 * ✅ Loose coupling
 * ✅ Open/Closed Principle
 * ✅ Easy to extend
 * ✅ Cleaner code
 */

/**
 * Common Use Cases
 *
 * Request filters (Servlet Filters)
 *
 * Spring Security filter chain
 *
 * Validation pipelines
 *
 * Logging / Auditing
 *
 * Rate limiting
 *
 * API Gateway request processing
 */