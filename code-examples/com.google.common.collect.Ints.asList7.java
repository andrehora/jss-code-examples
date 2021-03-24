public List<?> getValues(Tensor tensor){
	DataType dataType = tensor.dataType();

	switch(dataType){
		case FLOAT:
			return Floats.asList(TensorUtil.toFloatArray(tensor));
		case DOUBLE:
			return Doubles.asList(TensorUtil.toDoubleArray(tensor));
		case INT32:
			return Ints.asList(TensorUtil.toIntArray(tensor));
		case INT64:
			return Longs.asList(TensorUtil.toLongArray(tensor));
		case STRING:
			return Arrays.asList(TensorUtil.toStringArray(tensor));
		case BOOL:
			return Booleans.asList(TensorUtil.toBooleanArray(tensor));
		default:
			throw new IllegalArgumentException();
	}
}