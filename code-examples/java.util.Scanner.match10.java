public static void setProxy(String proxyAddr)
{
	if(proxyAddr != null)
	{
		Scanner s = new Scanner(proxyAddr);
		
		// Split into "proxyAddr:proxyPort".
		proxyAddr = null;
		int proxyPort = 8080;
		try
		{
			s.findInLine("(http://|)([^:/]+)(:|)([0-9]*)(/|)");
			MatchResult m = s.match();
			
			if(m.groupCount() >= 2)
				proxyAddr = m.group(2);
			
			if(m.groupCount() >= 4 && !(m.group(4).length() == 0))
				proxyPort = Integer.parseInt(m.group(4));
		}finally
		{
			s.close();
		}
		
		if(proxyAddr != null)
		{
			SocketAddress sa = new InetSocketAddress(proxyAddr, proxyPort);
			setProxy(new Proxy(Type.HTTP, sa));
		}
	}
}