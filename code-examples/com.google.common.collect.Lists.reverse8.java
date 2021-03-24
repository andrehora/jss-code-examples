public BigInteger getYValue(BigInteger x, List<BigInteger> bold_a) {
    Preconditions.checkArgument(bold_a.size() >= 1,
            String.format("The size of bold_a should always be larger or equal to 1 (it is [%d]", bold_a.size()));
    if (x.equals(BigInteger.ZERO)) {
        return bold_a.get(0);
    } else {
        BigInteger y = BigInteger.ZERO;
        for (BigInteger a_i : Lists.reverse(bold_a)) {
            y = a_i.add(x.multiply(y).mod(primeField.getP_prime())).mod(primeField.getP_prime());
        }
        return y;
    }
}