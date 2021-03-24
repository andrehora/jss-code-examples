private DropTarget findDropTarget(int x, int y, int[] dropCoordinates) {
    final Rect r = mRectTemp;

    final ArrayList<DropTarget> dropTargets = mDropTargets;
    final int count = dropTargets.size();
    for (int i=count-1; i>=0; i--) {
        DropTarget target = dropTargets.get(i);
        if (!target.isDropEnabled())
            continue;

        target.getHitRectRelativeToDragLayer(r);

        mDragObject.x = x;
        mDragObject.y = y;
        if (r.contains(x, y)) {

            dropCoordinates[0] = x;
            dropCoordinates[1] = y;
            mLauncher.getDragLayer().mapCoordInSelfToDescendent((View) target, dropCoordinates);

            return target;
        }
    }
    return null;
}