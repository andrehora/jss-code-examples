private String buildConditions(String prefix, List<String> conditions, List<String> operators) {
	StringBuilder builder = new StringBuilder();
	if (conditions.size()>0) {
		if (StringUtils.trimToNull(prefix)!=null) {
			builder.append(" ").append(prefix).append(" ");
		}
		for (int i=0; i<conditions.size(); i++) {
			String condition = conditions.get(i);
			builder.append(condition).append(" ");
			if (i<conditions.size()-1) {
				String operator = StringUtils.trimToNull(operators.get(i));
				if (operator!=null) {
					builder.append(operator).append(" ");
				}
			}
		}
	}
	return builder.toString();
}