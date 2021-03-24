public void exportImage() {
  try {
    File file = IOUtility.selectFileToSave(FileType.IMAGE);
    if (file != null) {
      Rectangle drawingArea = getDrawingArea();
      String extension = FilenameUtils.getExtension(file.getName());
      if (extension.equals("svg")) {
        SVGGraphics2D svgGenerator = IOUtility.getSVGGraphics(drawingArea.getSize());
        paintDrawing(svgGenerator, drawingArea.x, drawingArea.y);
        svgGenerator.stream(new FileWriter(file));
        svgGenerator.dispose();
      } else {
        BufferedImage bi = new BufferedImage(drawingArea.width, drawingArea.height, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        paintDrawing(g, drawingArea.x, drawingArea.y);
        ImageIO.write(bi, extension, file);
        g.dispose();
      }
    }
  } catch (Exception e) {
    e.printStackTrace();
  }
}