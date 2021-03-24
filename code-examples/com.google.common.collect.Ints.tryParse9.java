private void resizeImage() {
  if (image.getUrl().equals(getIconImage().getUrl())) {
    unclipImage();
    return;
  }

  String width = getElement().getStyle().getWidth();
  String height = getElement().getStyle().getHeight();

  // the situation right after refreshing the page
  if (width.isEmpty() || height.isEmpty()) {
    return;
  }

  int frameWidth = Ints.tryParse(width.substring(0, width.indexOf("px")));
  int frameHeight = Ints.tryParse(height.substring(0, height.indexOf("px")));

  if (scalingMode.equals("0")) {
    float ratio = Math.min(frameWidth / (float) getPreferredWidth(),
        frameHeight / (float) getPreferredHeight());
    int scaledWidth = Double.valueOf(getPreferredWidth() * ratio).intValue();
    int scaledHeight = Double.valueOf(getPreferredHeight() * ratio).intValue();
    image.setSize(scaledWidth + "px", scaledHeight + "px");

  } else if (scalingMode.equals("1")) {
    image.setSize("100%", "100%");

  } else {
    throw new IllegalStateException("Illegal scaling mode: " + scalingMode);
  }
}