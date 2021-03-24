public void split_string_white_space_using_apache_commons() {

    String[] elementsInString = StringUtils.split(
            "Yo,Gabba, Gabba, Keep Trying", ",");

    logger.info(Arrays.toString(elementsInString));

    assertTrue(elementsInString.length == 4);
}