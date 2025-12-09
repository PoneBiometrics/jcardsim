package com.licel.jcardsim.biometry;

import javacardx.biometry.BioException;
import javacardx.biometry.OwnerBioTemplate;
import javacardx.biometry.BioBuilder;
import org.bouncycastle.util.encoders.Hex;

/**
 * Fake ProxyClass for <code>BioBuilder</code>
 *
 * We don't use BioBuilder so instead we can use it to debug our caplet.
 */
public class BioBuilderDebug {
    public static final OwnerBioTemplate buildBioTemplate(byte one, byte two) throws BioException
    {
        System.out.println("BBDEBUG: " + one + " / " + two);

        return null;

    }

    // we use this function to examine parts of buffers
    public static OwnerBioTemplate buildBioTemplate(byte something, byte offset, byte[] in, byte length) throws BioException
    {
        byte[] tmp = new byte[length];
        System.arraycopy(in, offset, tmp, 0, length);
        System.out.println("BBDEBUG:(" + length + ", " + offset + ") " +  Hex.toHexString(tmp) + " " + something);

        return null;

    }
}
