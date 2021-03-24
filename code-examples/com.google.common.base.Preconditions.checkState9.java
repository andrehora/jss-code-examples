void readyTransaction(@Nonnull final PingPongTransaction tx) {
    // First mark the transaction as not locked.
    final boolean lockedMatch = LOCKED_UPDATER.compareAndSet(this, tx, null);
    Preconditions.checkState(lockedMatch, "Attempted to submit transaction %s while we have %s", tx, lockedTx);
    LOG.debug("Transaction {} unlocked", tx);

    /*
     * The transaction is ready. It will then be picked up by either next allocation,
     * or a background transaction completion callback.
     */
    final boolean success = READY_UPDATER.compareAndSet(this, null, tx);
    Preconditions.checkState(success, "Transaction %s collided on ready state", tx, readyTx);
    LOG.debug("Transaction {} readied", tx);

    /*
     * We do not see a transaction being in-flight, so we need to take care of dispatching
     * the transaction to the backend. We are in the ready case, we cannot short-cut
     * the checking of readyTx, as an in-flight transaction may have completed between us
     * setting the field above and us checking.
     */
    if (inflightTx == null) {
        synchronized (this) {
            processIfReady();
        }
    }
}