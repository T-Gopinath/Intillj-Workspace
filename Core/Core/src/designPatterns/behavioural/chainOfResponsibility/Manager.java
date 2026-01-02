package designPatterns.behavioural.chainOfResponsibility;

public class Manager extends Approver {

    @Override
    public void approveRequest(int amount) {
        if (amount <= 10_000) {
            System.out.println("Manager approved amount: " + amount);
        } else if (nextApprover != null) {
            nextApprover.approveRequest(amount);
        }
    }
}
