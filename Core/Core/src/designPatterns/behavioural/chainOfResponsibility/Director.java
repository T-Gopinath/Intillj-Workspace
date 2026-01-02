package designPatterns.behavioural.chainOfResponsibility;

public class Director extends Approver {

    @Override
    public void approveRequest(int amount) {
        if (amount <= 50_000) {
            System.out.println("Director approved amount: " + amount);
        } else if (nextApprover != null) {
            nextApprover.approveRequest(amount);
        }
    }
}

