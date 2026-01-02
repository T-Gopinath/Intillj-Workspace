package designPatterns.behavioural.chainOfResponsibility;

public abstract class Approver {

    protected Approver nextApprover;

    public void setNext(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void approveRequest(int amount);
}

