public CompositeValidationIssueProcessor(final IValidationIssueProcessor first,
		final IValidationIssueProcessor... others) {
	processors = Lists.asList(first, others);
}