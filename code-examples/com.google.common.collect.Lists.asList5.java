public void create_new_unmodified_list () {

    String[] vals = {"test1", "test2"};
    List<String> myList = Lists.asList("test0", vals);

    assertNotNull(myList);
}