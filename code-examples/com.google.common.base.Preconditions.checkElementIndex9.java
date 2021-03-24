public void publishKeyPart(int j, EncryptionPublicKey publicKey) {
    Preconditions.checkState(publicParameters != null,
            "The public parameters need to have been defined first");
    Preconditions.checkElementIndex(j, publicParameters.getS(),
            "The index j should be lower than the number of authorities");
    publicKeyParts.put(j, publicKey);
}