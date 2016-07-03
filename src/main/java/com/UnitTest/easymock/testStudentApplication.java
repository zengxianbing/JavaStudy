package com.UnitTest.easymock;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Test;

public class testStudentApplication {

	IStudent student;
	StudentApplication application;

	@Test
	public void testdoMethod() {

		student = EasyMock.createMock(IStudent.class);
		EasyMock.expect(student.doMethod1()).andReturn("a").times(1);
		EasyMock.expect(student.doMethod2()).andReturn("b").times(1);
		EasyMock.expect(student.doMethod3()).andReturn("c").times(1);

		EasyMock.replay(student);

		application = new StudentApplication();
		application.setStudent(student);

		String getStr = application.doMethod();

		String cstr = "abcfff";
		Assert.assertEquals(getStr, cstr);
		EasyMock.verify(student);

	}
}
