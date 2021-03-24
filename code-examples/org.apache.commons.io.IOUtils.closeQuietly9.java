public static ProcessDefinition parseProcess(byte[] bytes,long processId,boolean parseChildren) throws Exception{
	ByteArrayInputStream bin=new ByteArrayInputStream(bytes);
	try{
		SAXReader reader=new SAXReader();
		Document document=reader.read(bin);
		Element root=document.getRootElement();
		if(processParser.support(root)){
			ProcessDefinition pd=(ProcessDefinition)processParser.parse(root,processId,parseChildren);
			return pd;
		}
		return null;
	}finally{
		IOUtils.closeQuietly(bin);
	}
}