public static String fetchBrokerNameByAddr(final MQAdminExt adminExt, final String addr) throws Exception {
    ClusterInfo clusterInfoSerializeWrapper = adminExt.examineBrokerClusterInfo();
    HashMap<String/* brokerName */, BrokerData> brokerAddrTable =
        clusterInfoSerializeWrapper.getBrokerAddrTable();
    Iterator<Map.Entry<String, BrokerData>> it = brokerAddrTable.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry<String, BrokerData> entry = it.next();
        HashMap<Long, String> brokerAddrs = entry.getValue().getBrokerAddrs();
        if (brokerAddrs.containsValue(addr))
            return entry.getKey();
    }
    throw new Exception(
        "Make sure the specified broker addr exists or the nameserver which connected is correct.");
}