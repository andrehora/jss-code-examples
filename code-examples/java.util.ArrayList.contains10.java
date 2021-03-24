public static void saveShareAppIndexs2Sp(List<ResolveInfoWrap> list, Context context) {
    ArrayList<String> string = new ArrayList<>();
    for (ResolveInfoWrap resolveInfoWrap : list) {
        String name =resolveInfoWrap.resolveInfo.loadLabel(context.getPackageManager()).toString();
        if(!string.contains(name))
            string.add(name);
    }
    context.getSharedPreferences(ShareAppManagerActivity.SHARE_APPS, Context.MODE_PRIVATE).edit().
            putString(ConstantUtil.SHARE_APP_INDEX, new Gson().toJson(string)).apply();
}