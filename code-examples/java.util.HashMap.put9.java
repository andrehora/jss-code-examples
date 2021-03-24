public @Nullable Entrant calculateWinner() {
    HashMap<Entrant, Integer> wins = new HashMap<>();
    for (Map.Entry<String, Entrant> match : this.winnerStore.entrySet()) {
        Entrant winner = match.getValue();
        if (winner != null) {
            int winCount = Optional.fromNullable(wins.get(winner)).or(0) + 1;
            wins.put(winner, winCount);
            if (winCount > 1) {
                tourney.recordMatch(match.getKey());
                return winner;
            }
        }
    }

    if (this.getMatchesPlayed() > 2) tourney.recordMatch(this.winnerStore.keySet().iterator().next());
    return null;
}