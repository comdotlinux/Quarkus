package com.linux;

import io.quarkus.test.junit.NativeImageTest;
import org.junit.jupiter.api.Disabled;

@NativeImageTest
@Disabled("Only for now :P")
public class NativeShowersIT extends ShowersTest {

    // Execute the same tests but in native mode.
}
