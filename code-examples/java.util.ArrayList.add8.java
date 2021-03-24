private static String getPlatformVersionDependentExtraValue(final String localeString,
        final String keyboardLayoutSetName, final boolean isAsciiCapable,
        final boolean isEmojiCapable) {
    final ArrayList<String> extraValueItems = new ArrayList<>();
    extraValueItems.add(KEYBOARD_LAYOUT_SET + "=" + keyboardLayoutSetName);
    if (isAsciiCapable) {
        extraValueItems.add(ASCII_CAPABLE);
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN &&
            SubtypeLocaleUtils.isExceptionalLocale(localeString)) {
        extraValueItems.add(UNTRANSLATABLE_STRING_IN_SUBTYPE_NAME + "=" +
                SubtypeLocaleUtils.getKeyboardLayoutSetDisplayName(keyboardLayoutSetName));
    }
    if (isEmojiCapable && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        extraValueItems.add(EMOJI_CAPABLE);
    }
    extraValueItems.add(IS_ADDITIONAL_SUBTYPE);
    return TextUtils.join(",", extraValueItems);
}