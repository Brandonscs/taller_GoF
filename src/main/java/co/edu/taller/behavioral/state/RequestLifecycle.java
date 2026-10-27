package co.edu.taller.behavioral.state;

public class RequestLifecycle {
    public enum Status { RECEIVED, IN_REVIEW, APPROVED, REJECTED }

    private Status status = Status.RECEIVED;

    public Status status() {
        return status;
    }

    public void review() {
        if (status != Status.RECEIVED) {
            throw new IllegalStateException("Invalid transition to IN_REVIEW from " + status);
        }
        status = Status.IN_REVIEW;
    }

    public void approve() {
        if (status != Status.IN_REVIEW) {
            throw new IllegalStateException("Invalid transition to APPROVED from " + status);
        }
        status = Status.APPROVED;
    }

    public void reject() {
        if (status != Status.IN_REVIEW) {
            throw new IllegalStateException("Invalid transition to REJECTED from " + status);
        }
        status = Status.REJECTED;
    }
}