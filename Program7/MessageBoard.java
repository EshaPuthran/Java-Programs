package lab7;

public class MessageBoard {
	private String message;
    private boolean hasMessage = false;

    public void put(String msg) {
        synchronized (this) {
            while (hasMessage) {
                try {
                    wait(); // wait until the old message is consumed
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            message = msg;
            hasMessage = true;
            System.out.println("Producer sends: " + msg);
            notify(); // notify the waiting consumer
        }
    }

    public String get() {
        synchronized (this) {
            while (!hasMessage) {
                try {
                    wait(); // wait until a new message is produced
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            String msg = message;
            hasMessage = false;
            notify(); // notify the producer
            return msg;
        }
    }
}
