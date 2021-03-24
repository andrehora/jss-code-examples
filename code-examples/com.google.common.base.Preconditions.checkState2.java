public static void main(String[] args) {

	//Throws IllegalStateException - if expression is false
	//Preconditions.checkState(expression, errorMessage)

	Student student = new Student("Sriram", 2, "Chess");
	Student student2 = new Student("Charan", 8, "Cricket");

	/**
	 * Negative case
	 */
	try {
		Preconditions.checkState(student2.isKid(), 
				"This program requires Students below 5 years, but found %s", student2.getAge());
	} catch (IllegalStateException e) {
		System.out.println(e);
	}

	/**
	 * Positive case
	 */
	Preconditions.checkState(student.isKid(), 
			"This program requires Students below 5 years, but found %s", student.getAge());

	System.out.println("Thanks for providing valid input");
}