public void testForNonNullArgument(final String parameter)
{
	final String localParameter = checkNotNull(parameter, "Provided parameter is unacceptably null.");
}