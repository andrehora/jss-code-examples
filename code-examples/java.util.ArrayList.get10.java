public boolean isFixedView(View v) {
    int i;
    ArrayList<FixedViewInfo> where = this.mHeaderViewInfos;
    int len = where.size();
    for (i = 0; i < len; i++) {
        if (((FixedViewInfo) where.get(i)).view == v) {
            return true;
        }
    }
    where = this.mFooterViewInfos;
    len = where.size();
    for (i = 0; i < len; i++) {
        if (((FixedViewInfo) where.get(i)).view == v) {
            return true;
        }
    }
    return false;
}