package org.example;

import jdk.jshell.spi.ExecutionControl;

public enum State {
    DEAD() {
       @Override
       public State withLiveNeighbours(int i) {
           return i==2?DEAD:ALIVE;
       }
    }, ALIVE() {
        @Override
        public State withLiveNeighbours(int i) {
            return i == 2 || i == 3 ? ALIVE : DEAD;
        }
    };

    public State withLiveNeighbours(int i) {
        throw new UnsupportedOperationException();
    }
}
