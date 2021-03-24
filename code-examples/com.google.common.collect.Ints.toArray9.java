public void testScale_index_compute_intVarargs() {
  int[] dataset = Ints.toArray(SIXTEEN_SQUARES_INTEGERS);
  assertThat(Quantiles.scale(10).index(1).compute(dataset))
      .isWithin(ALLOWED_ERROR)
      .of(SIXTEEN_SQUARES_DECILE_1);
  assertThat(dataset).asList().isEqualTo(SIXTEEN_SQUARES_INTEGERS);
}