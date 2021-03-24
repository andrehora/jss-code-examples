public void encodeDecodeShortListWithTwoByteArraysWithElementsLength56() {
    byte[] value1 = new byte[26];
    byte[] value2 = new byte[28];
    byte[] element1 = RLP.encodeElement(value1);
    byte[] element2 = RLP.encodeElement(value2);
    byte[] encoded = RLP.encodeList(element1, element2);

    Assert.assertNotNull(encoded);
    Assert.assertEquals(1 + 1 + 1 + 26 + 1 + 28, encoded.length);
    Assert.assertEquals((byte)(247 + 1), encoded[0]);
    Assert.assertEquals((byte)(56), encoded[1]);

    ArrayList<RLPElement> list = RLP.decode2(encoded);

    Assert.assertNotNull(list);
    Assert.assertEquals(1, list.size());

    RLPList list2 = (RLPList) list.get(0);

    Assert.assertNotNull(list2);
    Assert.assertEquals(2, list2.size());
    Assert.assertArrayEquals(value1, list2.get(0).getRLPData());
    Assert.assertArrayEquals(value2, list2.get(1).getRLPData());
}