@Async
@Order(Ordered.LOWEST_PRECEDENCE)
@EventListener
void handleSomethingHasFuckedUp(final SomethingHasFuckedUpEvent event) {
    // We caught an unrecoverable exception in a thread, we better stop right now.
    logger.error("Event SomethingHasFuckedUpEvent caught.", event.getException());
    // Stop the application
    SpringApplication.exit(appContext, () -> 42);
}