public void doSerialize(RegistrationData registrationData, IAccount account) throws IOException {
	HashMap<String, Object> data = new HashMap<String, Object>();
	data.put("publicKey", Format.convert(registrationData.getPublicKey()));

	account.putProperty(new AccountProperty(PropertyType.REGISTRATION, data));
}