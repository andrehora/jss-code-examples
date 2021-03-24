public static void validatePMMLVsSchema(PMML pmml, InputSchema schema) {
  List<Model> models = pmml.getModels();
  Preconditions.checkArgument(models.size() == 1,
      "Should have exactly one model, but had %s", models.size());

  Model model = models.get(0);
  Preconditions.checkArgument(model instanceof ClusteringModel);
  Preconditions.checkArgument(model.getMiningFunction() == MiningFunction.CLUSTERING);

  DataDictionary dictionary = pmml.getDataDictionary();
  Preconditions.checkArgument(
      schema.getFeatureNames().equals(AppPMMLUtils.getFeatureNames(dictionary)),
      "Feature names in schema don't match names in PMML");

  MiningSchema miningSchema = model.getMiningSchema();
  Preconditions.checkArgument(schema.getFeatureNames().equals(
      AppPMMLUtils.getFeatureNames(miningSchema)));

}