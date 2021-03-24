public Library buildLibraryFromRecordType(Record rec) {
	Library ret = new Library();
	DataTypes types = new DataTypes();
	ret.setTypes(types);
	List<Field> fields = new ArrayList<Field>();
	fields.addAll(rec.getField());
	rec.getField().clear();
	for (Field field : fields) {
		if (StringUtils.containsIgnoreCase(field.getType(), ":")) {
			String[] vals = StringUtils.split(field.getType(), ":");
			field.setType(field.getType());
			Use use = new Use();
			use.setLibrary(LibraryUtil.getLibraryUseNameFromName(vals[0]));
			if (!existing(use, ret))
				ret.getUse().add(use);
		}
		rec.getField().add(field);
	}
	ret.getTypes().getSimpleOrRecordOrConstant().add(rec);
	return ret;
}