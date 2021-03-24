@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
public ModelAndView uploadFile(MultipartFile file) throws IOException {
  
    ModelAndView modelAndView = new ModelAndView("file");
    InputStream in = file.getInputStream();
    File currDir = new File(".");
    String path = currDir.getAbsolutePath();
    FileOutputStream f = new FileOutputStream(
      path.substring(0, path.length()-1)+ file.getOriginalFilename());
    int ch = 0;
    while ((ch = in.read()) != -1) {
        f.write(ch);
    }
     
    f.flush();
    f.close();
     
    modelAndView.getModel().put("message", "File uploaded successfully!");
    return modelAndView;
}