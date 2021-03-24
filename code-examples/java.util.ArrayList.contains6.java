public void addObserver(Object observer, int id) {
    if (Looper.getMainLooper() != Looper.myLooper()){
            throw new RuntimeException("addObserver allowed only from MAIN thread");
    }

    if (broadcasting != 0) {
        ArrayList<Object> arrayList = addAfterBroadcast.get(id);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            addAfterBroadcast.put(id, arrayList);
        }
        arrayList.add(observer);
        return;
    }
    ArrayList<Object> objects = observers.get(id);
    if (objects == null) {
        observers.put(id, (objects = new ArrayList<>()));
    }
    if (objects.contains(observer)) {
        return;
    }
    objects.add(observer);
}