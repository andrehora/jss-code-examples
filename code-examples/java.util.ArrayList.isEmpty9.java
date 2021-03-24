public VParceledListSlice<ProviderInfo> queryContentProviders(String processName, int vuid, int flags) {
    int userId = VUserHandle.getUserId(vuid);
    checkUserId(userId);
    flags = updateFlagsNought(flags);
    ArrayList<ProviderInfo> finalList = new ArrayList<>(3);
    // reader
    synchronized (mPackages) {
        for (VPackage.ProviderComponent p : mProvidersByComponent.values()) {
            PackageSetting ps = (PackageSetting) p.owner.mExtras;
            if (processName == null || ps.appId == VUserHandle.getAppId(vuid) && p.info.processName.equals(processName)) {
                ProviderInfo providerInfo = PackageParserEx.generateProviderInfo(p, flags, ps.readUserState(userId), userId);
                finalList.add(providerInfo);
            }
        }
    }
    if (!finalList.isEmpty()) {
        Collections.sort(finalList, sProviderInitOrderSorter);
    }
    return new VParceledListSlice<>(finalList);
}