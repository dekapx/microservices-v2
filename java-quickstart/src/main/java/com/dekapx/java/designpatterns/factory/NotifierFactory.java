package com.dekapx.java.designpatterns.factory;

@FunctionalInterface
public interface NotifierFactory {
    Notifier getNotifier(NotifierType notifierType);
}
