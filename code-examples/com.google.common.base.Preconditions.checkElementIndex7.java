public FinalizationCodePart getFinalization(Integer i, List<List<Point>> upper_bold_p, Collection<BallotEntry> upper_b) {
    BigInteger p_prime = publicParameters.getPrimeField().getP_prime();
    Preconditions.checkArgument(upper_bold_p.stream().flatMap(Collection::stream)
                    .allMatch(point -> BigInteger.ZERO.compareTo(point.x) <= 0 &&
                            point.x.compareTo(p_prime) < 0 &&
                            BigInteger.ZERO.compareTo(point.y) <= 0 &&
                            point.y.compareTo(p_prime) < 0),
            "All points' coordinates must be in Z_p_prime");
    Preconditions.checkElementIndex(i, upper_bold_p.size());

    Object[] bold_p_i = upper_bold_p.get(i).toArray();
    byte[] upper_f_i = ByteArrayUtils.truncate(hash.recHash_L(bold_p_i), publicParameters.getUpper_l_f());

    BallotEntry ballotEntry = upper_b.stream().filter(b -> Objects.equals(b.getI(), i)).findFirst().orElseThrow(
            () -> new BallotNotFoundRuntimeException(String.format("Couldn't find any ballot for voter %d", i))
    );

    return new FinalizationCodePart(upper_f_i, ballotEntry.getBold_r());
}