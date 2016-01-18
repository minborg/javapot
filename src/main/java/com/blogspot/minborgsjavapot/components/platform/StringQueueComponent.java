package com.blogspot.minborgsjavapot.components.platform;

public interface StringQueueComponent extends Component {

    boolean offer(String msg);

    String poll();
}
