/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

public class MgtTokenStyleInformationProvider {
	
	public de.tu_dresden.mgt.resource.mgt.IMgtTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("INTEGER".equals(tokenName)) {
			return new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenStyle(new int[] {0x00, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TESTSUITE".equals(tokenName)) {
			return new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("suiteName".equals(tokenName)) {
			return new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("systemUnderTest".equals(tokenName)) {
			return new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("adapter".equals(tokenName)) {
			return new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("TESTCASE".equals(tokenName)) {
			return new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("caseName".equals(tokenName)) {
			return new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("ASSERT".equals(tokenName)) {
			return new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("id".equals(tokenName)) {
			return new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("SEQUENCE".equals(tokenName)) {
			return new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("seq:".equals(tokenName)) {
			return new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		return null;
	}
	
}
