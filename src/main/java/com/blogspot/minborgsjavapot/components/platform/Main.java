package com.blogspot.minborgsjavapot.components.platform;

/**
 *
 * @author pemi
 */
public class Main {

    public static void main(String[] args) {
        ComponentHandler componentHandler = new ComponentHandler();
        setupComponents(componentHandler);
        ///
        putStuffInTheStingQueue(componentHandler);
        printStuffInTheStringQueue(componentHandler);

        // Select a new queue component (content of the old queue is lost)
        componentHandler.put(StringQueueComponent.class, new FileStringQueueComponent());

        putStuffInTheStingQueue(componentHandler);
        printStuffInTheStringQueue(componentHandler);

    }

    private static void putStuffInTheStingQueue(ComponentHandler componentHandler) {
        StringQueueComponent queue = componentHandler.get(StringQueueComponent.class);
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
    }

    private static void printStuffInTheStringQueue(ComponentHandler componentHandler) {
        StringQueueComponent queue = componentHandler.get(StringQueueComponent.class);
        System.out.println("Stuff in " + queue.getClass().getSimpleName());
        String s;
        while ((s = queue.poll()) != null) {
            System.out.println(s);
        }
    }

    private static void setupComponents(ComponentHandler componentHandler) {
        componentHandler.put(StringQueueComponent.class, new MemoryStringQueueComponent());
    }

}
