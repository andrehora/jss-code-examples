public static Iterable<Object[]> compressionStrategiesAndByteOrders()
{
 Set<List<Object>> combinations = Sets.cartesianProduct(
   Sets.newHashSet(CompressionStrategy.noNoneValues()),
   Sets.newHashSet(ByteOrder.BIG_ENDIAN, ByteOrder.LITTLE_ENDIAN)
 );
 return Iterables.transform(
   combinations,
   (Function<List, Object[]>) input -> new Object[]{input.get(0), input.get(1)}
 );
}