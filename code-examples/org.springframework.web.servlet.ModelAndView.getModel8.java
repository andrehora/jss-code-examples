private Collection<MenuItem> parseMenu(HttpServletRequest request, ModelAndView modelAndView, Collection<MenuItem> items) {
    Map<String, Object> sourceMap = modelAndView.getModel();
    final String[] search = new String[sourceMap.size()];
    final String[] replace = new String[sourceMap.size()];
    int i = 0;
    for (Map.Entry<String, Object> entry : sourceMap.entrySet()) {
        search[i] = String.format("${%s}", entry.getKey());
        replace[i++] = String.valueOf(entry.getValue());
    }
    items = parseItem(request, search, replace, items);
    return items;
}