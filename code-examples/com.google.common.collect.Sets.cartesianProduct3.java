public void cartesian_product_guava () {

    Set<String> first = Sets.newHashSet("a", "b");
    Set<String> second = Sets.newHashSet("c", "d");

    Set<List<String>> cartesianProduct = Sets.cartesianProduct(first, second);

    List<String> b_c = Lists.newArrayList("b", "c");
    List<String> b_d = Lists.newArrayList("b", "d");
    List<String> a_c = Lists.newArrayList("a", "c");
    List<String> a_d = Lists.newArrayList("a", "d");

    assertThat(cartesianProduct,
            anyOf(containsInAnyOrder(b_c, b_d, a_c, a_d)));
}