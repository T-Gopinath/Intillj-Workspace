package designPatterns.behavioural.mediator;

public class MediatorDemo {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User user1 = new ChatUser(chatRoom, "Alice");
        User user2 = new ChatUser(chatRoom, "Bob");
        User user3 = new ChatUser(chatRoom, "Charlie");

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        user1.send("Hello everyone!");
    }
}


/**
 * 🌱 Mediator in Spring Boot / Microservices
 * Real-world Use Cases
 *
 * Event-driven communication
 *
 * Workflow orchestration
 *
 * Saga pattern coordinators
 *
 * API Gateway / Orchestrator
 *
 * Example
 *
 * Spring ApplicationEventPublisher
 *
 * Workflow engine coordinating multiple services
 *
 * Order Service → Payment → Inventory via orchestrator
 */