public class SerializacaoDeserializacaoBase64ApacheCommons {

    public static void main(String[] args) {

        String textoOriginal = "esta é uma string de teste para serialização/deserialização em Base64";

        System.out.println("Texto original: " + textoOriginal);

        Base64 base64 = new Base64();

        String textoSerializado = base64.encodeAsString(textoOriginal.getBytes());

        System.out.println("Texto em Base64: " + textoSerializado);

        String textoDeserializado = new String(base64.decode(textoSerializado));

        System.out.println("Texto deserializado: "+ textoDeserializado);

    }
}