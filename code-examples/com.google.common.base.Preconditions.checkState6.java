protected BasicTransactionSemantics createTransaction() {
  if (!open) {
    String msg = "Channel closed " + channelNameDescriptor;
    if (startupError != null) {
      msg += ". Due to " + startupError.getClass().getName() + ": " +
          startupError.getMessage();
      throw new IllegalStateException(msg, startupError);
    }
    throw new IllegalStateException(msg);
  }

  FileBackedTransaction trans = transactions.get();
  if (trans != null && !trans.isClosed()) {
    Preconditions.checkState(false,
        "Thread has transaction which is still open: " +
            trans.getStateAsString() + channelNameDescriptor);
  }
  trans = new FileBackedTransaction(log, TransactionIDOracle.next(),
      transactionCapacity, keepAlive, queueRemaining, getName(),
      fsyncPerTransaction, channelCounter);
  transactions.set(trans);
  return trans;
}