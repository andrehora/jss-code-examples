private void updateTopics(Set<String> topicNames) {
    Set<String> currentTopics = topicsByName.keySet();
    Set<String> topicsToAdd = Sets.difference(topicNames, currentTopics);
    Set<String> topicsToRemove = Sets.difference(currentTopics, topicNames);

    topicsToAdd.stream()
            .filter(topicName -> !topicName.equals("__consumer_offsets"))
            .forEach(topicName -> {
                try {
                    String partitionsPath = "/brokers/topics/" + topicName + "/partitions";
                    zkClient.waitUntilExists(partitionsPath, TimeUnit.SECONDS, 5);
                    topicsByName.put(topicName, new KafkaTopic(topicName, zkClient.getChildren(partitionsPath).size()));
                    log.info("Topic added: [{}]", topicName);
                } catch (Exception e) {
                    log.error("Exception fetching info for topic [{}]: {}", topicName, e.getMessage(), e);
                }
            });

    topicsToRemove.forEach(topicName -> {
        topicsByName.remove(topicName);
        log.info("Topic deleted: [{}]", topicName);
    });
}