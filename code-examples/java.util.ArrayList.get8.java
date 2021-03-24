static void updateItemsInDatabaseHelper(Context context, final ArrayList<ContentValues> valuesList,
        final ArrayList<ItemInfo> items, final String callingFunction) {
    final ContentResolver cr = context.getContentResolver();

    final StackTraceElement[] stackTrace = new Throwable().getStackTrace();
    Runnable r = new Runnable() {
        public void run() {
            ArrayList<ContentProviderOperation> ops =
                    new ArrayList<ContentProviderOperation>();
            int count = items.size();
            for (int i = 0; i < count; i++) {
                ItemInfo item = items.get(i);
                final long itemId = item.id;
                final Uri uri = LauncherSettings.Favorites.getContentUri(itemId);
                ContentValues values = valuesList.get(i);

                ops.add(ContentProviderOperation.newUpdate(uri).withValues(values).build());
                updateItemArrays(item, itemId, stackTrace);

            }
            try {
                cr.applyBatch(LauncherProvider.AUTHORITY, ops);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    runOnWorkerThread(r);
}