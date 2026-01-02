package designPatterns.behavioural.chainOfResponsibility;

public class CEO extends Approver {

    @Override
    public void approveRequest(int amount) {
        System.out.println("CEO approved amount: " + amount);
    }
}

