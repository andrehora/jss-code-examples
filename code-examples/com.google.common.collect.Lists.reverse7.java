public void prepare() {
    this.finalDownstream.prepare();
    for (Projector projector : Lists.reverse(nodeProjectors)) {
        projector.prepare();
    }
    if (shardProjectionsIndex >= 0) {
        for (Projector p : shardProjectors) {
            p.prepare();
        }
    }
}