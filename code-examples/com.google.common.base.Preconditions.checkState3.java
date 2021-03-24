public void overloadSelection() {
	Boolean boxedBoolean = null;
	boolean aBoolean = true;
	Long boxedLong = null;
	int anInt = 1;
	// With a boxed predicate, no overloads can be selected in phase 1
	// ambiguous without the call to .booleanValue to unbox the Boolean
	checkState(boxedBoolean.booleanValue(), "",  1);
	// ambiguous without the cast to Object because the boxed predicate prevents any overload from
	// being selected in phase 1
	checkState(boxedBoolean, "", (Object) boxedLong);

	// ternaries introduce their own problems. because of the ternary (which requires a boxing
	// operation) no overload can be selected in phase 1.  and in phase 2 it is ambiguous since it
	// matches with the second parameter being boxed and without it being boxed.  The cast to Object
	// avoids this.
	checkState(aBoolean, "", aBoolean ? "" : anInt, (Object) anInt);

	// ambiguous without the .booleanValue() call since the boxing forces us into phase 2 resolution
	short s = 2;
	checkState(boxedBoolean.booleanValue(), "", s);
}