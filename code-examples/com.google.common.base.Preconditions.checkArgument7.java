public Conversation getCurrentConversationByChannelId(Client client, String channelId, Supplier<Conversation> supplier) {
    Preconditions.checkNotNull(client);
    Preconditions.checkArgument(StringUtils.isNoneBlank(channelId));
    final ObjectId conversationId = storeService.mapChannelToCurrentConversationId(channelId);
    if (conversationId != null) {
        Conversation conversation = storeService.get(conversationId);
        if(Objects.equal(conversation.getOwner(), client.getId())){
            return getConversation(client, conversationId);
        } else {
            //this should never happen unless we have two clients with the same channelId
            throw new IllegalStateException("Conversation for channel '" + channelId + "' has a different owner "
                    + "as the current client (owner: " + conversation.getOwner() + ", client: " + client + ")!");
        }
    } else {
        final Conversation c = supplier.get();
        if(c != null){
            c.setId(null);
            c.setOwner(client.getId());
            c.setChannelId(channelId);
            return storeService.store(c);
        } else {
            return null;
        }
    }
}