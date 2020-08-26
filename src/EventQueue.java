import java.util.LinkedList;

/**
 * @author tanbb
 * @create 2020-08-26 9:24
 */
public class EventQueue {
    private final int max;

    static class Event{

    }

    private static LinkedList<Event> eventQueue = new LinkedList<>();

    private static final int DEFAULT_MAX_EVENT = 10;

    public EventQueue() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max) {
        this.max = max;
    }

    public void offer(Event event) {
        synchronized (eventQueue) {
            while (eventQueue.size() >= max) {
                System.out.println("queue is full");
                try {
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("the new event is submit");
            eventQueue.addLast(event);
            System.out.println(eventQueue.size());
            eventQueue.notifyAll();
        }
    }

    public Event take() {
        synchronized (eventQueue) {
            if (eventQueue.isEmpty()) {
                System.out.println("queue is empty");
                try {
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            this.eventQueue.notifyAll();
            System.out.println("this event "+event+" is handled");
            return event;
        }
    }
}
