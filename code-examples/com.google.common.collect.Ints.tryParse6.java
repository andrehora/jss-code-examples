private static Set<ShardId> findAllShardsForIndex(Path indexPath) throws IOException {
    Set<ShardId> shardIds = new HashSet<>();
    if (Files.isDirectory(indexPath)) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(indexPath)) {
            String currentIndex = indexPath.getFileName().toString();
            for (Path shardPath : stream) {
                if (Files.isDirectory(shardPath)) {
                    Integer shardId = Ints.tryParse(shardPath.getFileName().toString());
                    if (shardId != null) {
                        ShardId id = new ShardId(currentIndex, shardId);
                        shardIds.add(id);
                    }
                }
            }
        }
    }
    return shardIds;
}