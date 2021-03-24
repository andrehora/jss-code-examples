ArrayList<Emoticon> searchEmoticons(@NonNull final String searchQuery,
                                    @Nullable EmoticonProvider emoticonProvider) {
    SQLiteDatabase sqLiteDatabase = getReadableDatabase();
    Cursor cursor = sqLiteDatabase.query(EmoticonTagsColumns.TABLE,
            new String[]{EmoticonTagsColumns.UNICODE},      //Unicode.
            EmoticonTagsColumns.TAG + " LIKE ?", new String[]{searchQuery.trim() + "%"}, //Search for the tag
            null, null, null);

    ArrayList<Emoticon> emoticons = new ArrayList<>();
    while (cursor.moveToNext()) {
        String unicode = cursor.getString(cursor.getColumnIndex(EmoticonTagsColumns.UNICODE));

        //Check if there is icon available to display for custom emoticon page.
        if (emoticonProvider == null || emoticonProvider.hasEmoticonIcon(unicode)) {
            Emoticon emoticon = new Emoticon(unicode);
            if (!emoticons.contains(emoticon))  //Prevent duplicates.
                emoticons.add(new Emoticon(unicode));
        }
    }
    cursor.close();
    sqLiteDatabase.close();
    return emoticons;
}