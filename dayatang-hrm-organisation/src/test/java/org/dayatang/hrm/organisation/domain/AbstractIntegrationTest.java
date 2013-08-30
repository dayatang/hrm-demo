package org.dayatang.hrm.organisation.domain;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.dayatang.domain.InstanceFactory;
import com.dayatang.spring.factory.SpringIocUtils;

/**
 * 集成测试基类。用于管理持久化和IoC基础设施
 * 
 * @author yyang
 * 
 */
public class AbstractIntegrationTest {

	@BeforeClass
	public static void classSetUp() throws Exception {
		prepareIoC();
	}

	// 初始化IoC
	private static void prepareIoC() {
		SpringIocUtils.initInstanceProvider("/applicationContext.xml");
	}

	@AfterClass
	public static void classTearDown() throws Exception {
		resetIoC();
	}

	// 重设IoC为未初始化状态。
	private static void resetIoC() {
		InstanceFactory.setInstanceProvider(null);
	}

}
