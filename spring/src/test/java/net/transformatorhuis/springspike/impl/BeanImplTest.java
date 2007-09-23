package net.transformatorhuis.springspike.impl;

import junit.framework.TestCase;
import net.transformatorhuis.springspike.Bean;

public class BeanImplTest extends TestCase {

    public void testBeanIsABean() {
	Bean aBean = new BeanImpl();
        assertTrue(aBean.isABean());
    }

}