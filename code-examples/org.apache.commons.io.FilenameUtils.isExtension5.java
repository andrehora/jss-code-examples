String filename = file.getName();
if(!FilenameUtils.isExtension(filename,"xls")){
  JOptionPane.showMessageDialog(null, "Choose an excel file!");
}