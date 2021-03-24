public boolean hasVariableWithNameInBlock(String value)
{
    ArrayList<VariableDefinition> vd = getVariablesInBlock();
    //System.out.println(vd.size());
    for (int j = 0; j < vd.size(); j++) {
        VariableDefinition get = vd.get(j);
        //System.out.println(get.name+ " vs: "+value);
        if(get.name.equals(value))
            return true;
    }
    return false;
}