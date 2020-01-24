package com.zloerysandbox.sandbox;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SandboxApplicationTests {

	@Test
	void contextLoads() {
	  // A good test would probably look like:
    // 0. Should tables names be properties/variables? Not sure how best to mock those out for tests
    // 0.1 I'm worried about multiple tests using the same table names, even though they're in the test database.
    // 1. Set up tables using defined sql schema
    // 2. Insert pre-defined data
    // 3. Test endpoints in different controllers using the preloaded data.
	}

}
