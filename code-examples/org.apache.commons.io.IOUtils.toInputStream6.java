public void mapper_boundWithMultipleNamedAndOneUnnamedInputStreams_shouldReadCorrespondingStreams() {
	String streamName = "foo";
	String secondStreamName = "bar";
	stream = new CarmlStream(streamName);
	InputStream inputStream = IOUtils.toInputStream(input);
	InputStream secondInputStream = IOUtils.toInputStream(secondInput);
	String unnamedInput = "unnamed test input";
	InputStream unnamedInputStream = IOUtils.toInputStream(unnamedInput);
	mapper.bindInputStream(streamName, inputStream);
	mapper.bindInputStream(secondStreamName, secondInputStream);
	mapper.bindInputStream(unnamedInputStream);
	assertThat(mapper.getSourceManager().getSource(streamName), is(input));
	assertThat(mapper.getSourceManager().getSource(secondStreamName), is(secondInput));
	assertThat(mapper.getSourceManager().getSource(RmlMapper.DEFAULT_STREAM_NAME), is(unnamedInput));
}