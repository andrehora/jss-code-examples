private void registerAllShaderPermutations() {
  Set<Set<ShaderProgramFeature>> allPermutations = Sets.powerSet(availableFeatures);
  for (Set<ShaderProgramFeature> permutation : allPermutations) {
    int fragShaderId = compileShader(GL20.GL_FRAGMENT_SHADER, permutation);
    int vertShaderId = compileShader(GL20.GL_VERTEX_SHADER, permutation);
    if (compileSuccess(fragShaderId) && compileSuccess(vertShaderId)) {
      int featureHash = ShaderProgramFeature.getBitset(permutation);
      disposalAction.fragmentPrograms.put(featureHash, fragShaderId);
      disposalAction.vertexPrograms.put(featureHash, vertShaderId);
    } else {
      throw new RuntimeException(String.format("Shader '%s' failed to compile for features '%s'.%n%n"
              + "Vertex Shader Info: %n%s%n"
              + "Fragment Shader Info: %n%s",
          getUrn(), permutation,
          getLogInfo(vertShaderId), getLogInfo(fragShaderId)));
    }
  }
  logger.debug("Compiled {} permutations for {}.", allPermutations.size(), getUrn());
}