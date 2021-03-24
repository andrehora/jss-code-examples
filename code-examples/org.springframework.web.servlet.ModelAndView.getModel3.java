public static Object assertAndReturnModelAttributeOfType(ModelAndView mav, Object modelName, Class expectedType)
		throws AssertionError {

	assertCondition(mav != null, "ModelAndView is null");
	assertCondition(mav.getModel() != null, "Model is null");
	final Object obj = mav.getModel().get(modelName);
	assertCondition(obj != null, "Model attribute with name '" + modelName + "' is null");

	assertCondition(expectedType.isAssignableFrom(obj.getClass()), "Model attribute is not of expected type '"
			+ expectedType.getName() + "' but rather of type '" + obj.getClass().getName() + "'");
	return obj;
}