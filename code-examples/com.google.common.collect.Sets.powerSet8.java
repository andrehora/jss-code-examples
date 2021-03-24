public void recompile() {
  TIntIntIterator it = disposalAction.shaderPrograms.iterator();
  while (it.hasNext()) {
    it.advance();
    GL20.glDeleteProgram(it.value());
  }
  disposalAction.shaderPrograms.clear();
  uniformLocationMap.clear();
  bindMap.clear();
  disposalAction.shaderPrograms.put(0, shader.linkShaderProgram(0));
  for (Set<ShaderProgramFeature> permutation : Sets.powerSet(shader.getAvailableFeatures())) {
    int featureMask = ShaderProgramFeature.getBitset(permutation);
    disposalAction.shaderPrograms.put(featureMask, shader.linkShaderProgram(featureMask));
  }
  //resolves #966
  //Some of the uniforms are not updated constantly between frames
  //this function will rebind any uniforms that are not bound
  rebindVariables(materialData);
}