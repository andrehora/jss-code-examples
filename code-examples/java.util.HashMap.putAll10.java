public void commitClickEvent(HashMap<String, Object> commonInfo, String viewName, HashMap<String, Object> viewData) {
    if (TextUtils.isEmpty(viewName)) {
        TrackerLog.d("commitClickEvent viewName is null");
        return;
    }
    TrackerLog.d("viewName=" + viewName);

    HashMap<String, String> argsInfo = new HashMap<String, String>();
    // add the common info
    if (commonInfo != null && !commonInfo.isEmpty()) {
        argsInfo.putAll(TrackerUtil.getHashMap(commonInfo));
    }

    if (argsInfo.containsKey(TrackerConstants.PAGE_NAME)) {
        argsInfo.remove(TrackerConstants.PAGE_NAME);
    }
    // add the special info
    if (viewData != null && !viewData.isEmpty()) {
        argsInfo.putAll(TrackerUtil.getHashMap(viewData));
    }

    if (GlobalsContext.trackerOpen) {
        if (!argsInfo.isEmpty()) {
            TrackerUtil.commitCtrlEvent(viewName, argsInfo);
        } else {
            TrackerUtil.commitCtrlEvent(viewName, null);
        }
    }
}