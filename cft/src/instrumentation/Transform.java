package instrumentation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class Transform implements ClassFileTransformer{

    public static final String classNumberReturn = "TransClass.class.2";

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (!className.equals("instrumentation/TransClass")) {
            return  null;
        }
        return getBytesFromFile(classNumberReturn);
    }

    public byte[] getBytesFromFile(String fileName) {
        try {
            File file = new File(fileName);
            InputStream in = new FileInputStream(file);
            long length = file.length();
            byte[] bytes = new byte[(int) length];
            int offset = 0;
            int numRead =0;


            while (offset<bytes.length&&(numRead=in.read(bytes,offset,bytes.length-offset))>0) {
                offset+=numRead;
            }
            if(offset<bytes.length){
                throw new IOException("could not completely read file"+file.getName());
            }
            in.close();
            return bytes;
        } catch (Exception e) {
            System.out.println("error occur in _ClassTransformer!"+e.getClass().getName());
            return null;
        }

    }


}
