public <C extends ComponentConfiguration> Entry<QueryBuilder<C>,C> getQueryBuilder(String creator, Configuration conf) {
    String[] creatorParts = StringUtils.split(creator, ':');
    if(creatorParts.length >= 2){
        QueryBuilder<C> queryBuilder = (QueryBuilder<C>)builders.get(creatorParts[1]);
        if(queryBuilder == null){
            return null;
        }
        if(creatorParts.length >= 3){
            Optional<C> config = conf.getConfiguration(queryBuilder,creatorParts[2]);
            if(config.isPresent()){
                return new ImmutablePair<>(queryBuilder, config.get());
            } else { //the referenced config was not found
                return null;
            }
        } else { //no configuration in the creator string ... so a null configuration is OK
            return new ImmutablePair<>(queryBuilder, null);
        }
    } else {
        return null;
    }
}