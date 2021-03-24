public void testScale_indexes_varargs_compute_intVarargs() {
  int[] dataset = Ints.toArray(SIXTEEN_SQUARES_INTEGERS);
  assertThat(Quantiles.scale(10).indexes(0, 10, 5, 1, 8, 1).compute(dataset))
      .comparingValuesUsing(QUANTILE_CORRESPONDENCE)
      .containsExactly(
          0, SIXTEEN_SQUARES_MIN,
          10, SIXTEEN_SQUARES_MAX,
          5, SIXTEEN_SQUARES_MEDIAN,
          1, SIXTEEN_SQUARES_DECILE_1,
          8, SIXTEEN_SQUARES_DECILE_8);
  assertThat(dataset).asList().isEqualTo(SIXTEEN_SQUARES_INTEGERS);
}