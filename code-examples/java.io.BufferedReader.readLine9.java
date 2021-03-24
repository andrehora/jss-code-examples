public static void obterDadosBD() throws IOException{
    try {
        FileReader conf = new FileReader("config.txt");
        BufferedReader lerArq = new BufferedReader(conf);
        ConnectionFactory.DRIVER = lerArq.readLine();
        ConnectionFactory.URL = lerArq.readLine();
        ConnectionFactory.USER = lerArq.readLine();
        ConnectionFactory.PASS = lerArq.readLine();
        conf.close();
        
    } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null,"Erro ao abrir o arquivo config.txt");
    }
}